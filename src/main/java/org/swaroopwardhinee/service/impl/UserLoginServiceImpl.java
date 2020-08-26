package org.swaroopwardhinee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.swaroopwardhinee.exception.CustomException;
import org.swaroopwardhinee.mappers.ErrorInfoMapper;
import org.swaroopwardhinee.mappers.UserRolesMapper;
import org.swaroopwardhinee.mappers.UsersMapper;
import org.swaroopwardhinee.models.ErrorInfoExample;
import org.swaroopwardhinee.models.UserRoles;
import org.swaroopwardhinee.models.UserRolesExample;
import org.swaroopwardhinee.models.Users;
import org.swaroopwardhinee.models.UsersExample;
import org.swaroopwardhinee.request.LoginRequest;
import org.swaroopwardhinee.response.LoginResponse;
import org.swaroopwardhinee.service.UserLoginService;
import org.swaroopwardhinee.util.EncrypterHelper;
import org.swaroopwardhinee.util.JwtTokenService;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UsersMapper accountMapper;

	@Autowired
	private ErrorInfoMapper errorInfoMapper;

	@Autowired
	private JwtTokenService jwtUtil;

	@Autowired
	private UserRolesMapper userRoleMapper;

	@Autowired
	private EncrypterHelper encrypterHelper;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public LoginResponse userLogin(LoginRequest loginRequest) throws CustomException {

		ErrorInfoExample errorInfoExample = new ErrorInfoExample();
		/*
		 * Validate the user login details by using the authentication manager. If it's
		 * a not valid login details it throw an error C011.
		 */
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getLoginPassCd()));
		} catch (Exception e) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C009");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		/*
		 * It will check the role type of the user matched with corresponding Login user
		 * details in DB. If not it will throw an error C019.
		 */
		UsersExample accountExample = new UsersExample();
		accountExample.createCriteria().andEmailEqualTo(loginRequest.getUserName());
		List<Users> accountList = accountMapper.selectByExample(accountExample);
		if (!Boolean.TRUE.equals(accountList.get(0).getIsActive())) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C012");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		UserRolesExample rolesExample = new UserRolesExample();
		rolesExample.createCriteria().andUserIdEqualTo(accountList.get(0).getUserId());
		List<UserRoles> roleList = userRoleMapper.selectByExample(rolesExample);
		boolean flag = false;
		if (roleList != null && roleList.isEmpty()) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C013");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		} else {
			for (UserRoles userRole : roleList) {
				if (userRole.getIsActive() && userRole.getIsDefault()) {
					flag = true;
				}
			}
		}
		if (!flag) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C013");
			throw new CustomException(errorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		/*
		 * If it's a success login details then it will generate access token for the
		 * user. This access token only valid for 30mins.
		 */
		String token = jwtUtil.generateToken(loginRequest.getUserName());
		String encryptKey = encrypterHelper.encrypt("Bearer " + token, "");
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setAccessToken(encryptKey);
		return loginResponse;
	}

}
