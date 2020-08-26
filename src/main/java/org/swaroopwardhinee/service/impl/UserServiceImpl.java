package org.swaroopwardhinee.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.swaroopwardhinee.exception.CustomException;
import org.swaroopwardhinee.mappers.ErrorInfoMapper;
import org.swaroopwardhinee.mappers.RolesMapper;
import org.swaroopwardhinee.mappers.UserRolesMapper;
import org.swaroopwardhinee.mappers.UsersMapper;
import org.swaroopwardhinee.models.ErrorInfoExample;
import org.swaroopwardhinee.models.Roles;
import org.swaroopwardhinee.models.RolesExample;
import org.swaroopwardhinee.models.UserRoles;
import org.swaroopwardhinee.models.Users;
import org.swaroopwardhinee.request.UserRegisterRequest;
import org.swaroopwardhinee.service.UserService;
import org.swaroopwardhinee.util.CommonUtil;
import org.swaroopwardhinee.util.EncrypterHelper;
import org.swaroopwardhinee.validator.UserValidator;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private ErrorInfoMapper swaErrorInfoMapper;

	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private UserRolesMapper userRoleMapper;

	@Autowired
	private RolesMapper rolesMapper;

	@Autowired
	private EncrypterHelper encrypterHelper;

	@Override
	public String userRegister(UserRegisterRequest userDetails) throws CustomException {

		ErrorInfoExample errorInfoExample = new ErrorInfoExample();

		userValidator.validateFields(userDetails);

		String userId = commonUtil.generateStudentId();
		Users users = new Users();
		users.setCreatedOn(new Date());
		users.setCreatedBy(userId);
		users.setUserId(userId);
		users.setEmail(userDetails.getEmailId());
		users.setFirstName(userDetails.getFirstName());
		users.setMiddleName(userDetails.getMiddleName());
		users.setLastName(userDetails.getLastName());
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String hashPwd = bCryptPasswordEncoder.encode(userDetails.getPassCd());
		String salt = commonUtil.getSaltString();
		users.setPasswordSalt(salt);
		users.setPassword(encrypterHelper.encrypt(hashPwd, salt));
		users.setIsActive(true);
		int userCount = usersMapper.insert(users);
		if (userCount <= 0) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C016");
			throw new CustomException(swaErrorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		UserRoles userRoles = new UserRoles();
		userRoles.setCreatedOn(new Date());
		userRoles.setCreatedBy(users.getUserId());
		userRoles.setUserId(users.getUserId());
		userRoles.setIsActive(true);
		userRoles.setIsDefault(true);

		RolesExample rolesExample = new RolesExample();
		rolesExample.createCriteria().andNameEqualTo("Default");
		List<Roles> rolesList = rolesMapper.selectByExample(rolesExample);
		if (rolesList != null && !rolesList.isEmpty()) {
			userRoles.setRoleId(rolesList.get(0).getId());
		}
		int roleCount = userRoleMapper.insert(userRoles);
		if (roleCount <= 0) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C016");
			throw new CustomException(swaErrorInfoMapper.selectByExample(errorInfoExample).get(0));
		}
		return "SUCCESS";
	}

}
