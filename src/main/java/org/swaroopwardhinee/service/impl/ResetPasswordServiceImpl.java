package org.swaroopwardhinee.service.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.swaroopwardhinee.exception.CustomException;
import org.swaroopwardhinee.mappers.ErrorInfoMapper;
import org.swaroopwardhinee.mappers.ForgotPasswordMapper;
import org.swaroopwardhinee.mappers.UsersMapper;
import org.swaroopwardhinee.models.ErrorInfoExample;
import org.swaroopwardhinee.models.ForgotPassword;
import org.swaroopwardhinee.models.ForgotPasswordExample;
import org.swaroopwardhinee.models.Users;
import org.swaroopwardhinee.models.UsersExample;
import org.swaroopwardhinee.request.ResetPasswordRequest;
import org.swaroopwardhinee.service.ResetPasswordService;
import org.swaroopwardhinee.util.CommonUtil;
import org.swaroopwardhinee.util.EncrypterHelper;

@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {

	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private ForgotPasswordMapper forgotPasswordMapper;

	@Autowired
	private ErrorInfoMapper errorInfoMapper;

	@Autowired
	private EncrypterHelper encrypterHelper;

	@Override
	public String resetPassword(String token, ResetPasswordRequest resetPasswordReq) throws CustomException {

		ErrorInfoExample errorInfoExample = new ErrorInfoExample();

		if ((resetPasswordReq.getPassword().length() < 8 && resetPasswordReq.getPassword().length() > 16)
				|| (resetPasswordReq.getConfirmPassword().length() < 8
						&& resetPasswordReq.getConfirmPassword().length() > 16)) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C006");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		if (!resetPasswordReq.getPassword().equals(resetPasswordReq.getConfirmPassword())) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C011");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		UsersExample usersExample = new UsersExample();
		usersExample.createCriteria().andEmailEqualTo(resetPasswordReq.getEmailId());
		List<Users> userDetail = usersMapper.selectByExample(usersExample);
		if (userDetail == null || userDetail.isEmpty()) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C022");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		if (!Boolean.TRUE.equals(userDetail.get(0).getIsActive())) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C012");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		ForgotPasswordExample passwordExample = new ForgotPasswordExample();
		passwordExample.createCriteria().andUserIdEqualTo(userDetail.get(0).getUserId()).andTokenEqualTo(token);
		List<ForgotPassword> forgotPasswordList = forgotPasswordMapper.selectByExample(passwordExample);
		if (forgotPasswordList == null || forgotPasswordList.isEmpty()) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C022");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		boolean isTokenExpired = commonUtil
				.isTokenExpired(convertToLocalDateTimeViaMilisecond(forgotPasswordList.get(0).getCreatedOn()));
		if (isTokenExpired) {
			forgotPasswordMapper.deleteByExample(passwordExample);
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C021");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		Users users = new Users();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String hashPwd = bCryptPasswordEncoder.encode(resetPasswordReq.getPassword());
		String salt = commonUtil.getSaltString();
		users.setModifiedBy(userDetail.get(0).getUserId());
		users.setModifiedOn(new Date());
		users.setPasswordSalt(salt);
		users.setPassword(encrypterHelper.encrypt(hashPwd, salt));

		UsersExample userExp = new UsersExample();
		userExp.createCriteria().andUserIdEqualTo(userDetail.get(0).getUserId())
				.andEmailEqualTo(resetPasswordReq.getEmailId());
		int updateCount = usersMapper.updateByExampleSelective(users, userExp);
		if (updateCount <= 0) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C016");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		}
		forgotPasswordMapper.deleteByExample(passwordExample);
		return "SUCCESS";
	}

	public LocalDateTime convertToLocalDateTimeViaMilisecond(Date dateToConvert) {
		return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

}
