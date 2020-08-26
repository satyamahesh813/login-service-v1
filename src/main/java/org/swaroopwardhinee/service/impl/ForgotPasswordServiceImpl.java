package org.swaroopwardhinee.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.swaroopwardhinee.exception.CustomException;
import org.swaroopwardhinee.feign.EmailFeign;
import org.swaroopwardhinee.mappers.ErrorInfoMapper;
import org.swaroopwardhinee.mappers.ForgotPasswordMapper;
import org.swaroopwardhinee.mappers.UsersMapper;
import org.swaroopwardhinee.models.ErrorInfoExample;
import org.swaroopwardhinee.models.ForgotPassword;
import org.swaroopwardhinee.models.Users;
import org.swaroopwardhinee.models.UsersExample;
import org.swaroopwardhinee.request.EmailRequest;
import org.swaroopwardhinee.request.ForgotPasswordRequest;
import org.swaroopwardhinee.response.CustomResponse;
import org.swaroopwardhinee.service.ForgotPasswordService;
import org.swaroopwardhinee.util.CommonUtil;

@Service
@Transactional(rollbackFor = Exception.class)
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private ErrorInfoMapper errorInfoMapper;

	@Autowired
	private ForgotPasswordMapper forgotPasswordMapper;

	@Autowired
	private EmailFeign emailFeign;

	@Autowired
	private CommonUtil commonUtil;

	@Override
	public String forgotPassword(ForgotPasswordRequest forgotPasswordRequest) throws CustomException {

		ErrorInfoExample errorInfoExample = new ErrorInfoExample();
		String response = null;
		UsersExample usersExample = new UsersExample();
		usersExample.createCriteria().andEmailEqualTo(forgotPasswordRequest.getEmailId());
		List<Users> usersList = usersMapper.selectByExample(usersExample);
		if (usersList == null || usersList.isEmpty()) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C020");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		}
		Users user = usersList.get(0);

		if (!Boolean.TRUE.equals(user.getIsActive())) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C012");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		String token = commonUtil.generateToken();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encryptToken = bCryptPasswordEncoder.encode(token);
		ForgotPassword forgotPassword = new ForgotPassword();
		forgotPassword.setCreatedBy(user.getUserId());
		forgotPassword.setCreatedOn(new Date());
		forgotPassword.setUserId(user.getUserId());
		forgotPassword.setToken(token);
		int count = forgotPasswordMapper.insert(forgotPassword);
		if (count <= 0) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C016");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		String forgotPwdToken = "http://localhost:8002/confirm-reset?token=" + encryptToken;
		StringBuilder sb = new StringBuilder();
		EmailRequest emailRequest = new EmailRequest();
		emailRequest.setFromEmailId("satyamahesh8@gmail.com");
		emailRequest.setToEmailId(user.getEmail());
		sb.append("<h3>Hi " + user.getFirstName() + ",</h3>");
		sb.append("<h4><p>To complete password reset process. Please click the below link.</p></h4>");
		sb.append("<p>" + forgotPwdToken + "</p>");
		sb.append("<br/>");
		sb.append("<h4><p>Regards,</p></h4>");
		sb.append("Swaroopwardhinee Org");
		emailRequest.setSubject("Password Reset Link.");
		emailRequest.setContent(sb.toString());
		try {
			ResponseEntity<CustomResponse> res = emailFeign.sendEmail(emailRequest);
			response = (String) res.getBody().getResponse();
		} catch (Exception e) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("E001");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		return response;
	}
}
