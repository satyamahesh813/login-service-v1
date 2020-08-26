package org.swaroopwardhinee.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.swaroopwardhinee.exception.CustomException;
import org.swaroopwardhinee.mappers.ErrorInfoMapper;
import org.swaroopwardhinee.mappers.UsersMapper;
import org.swaroopwardhinee.models.ErrorInfoExample;
import org.swaroopwardhinee.models.UsersExample;
import org.swaroopwardhinee.request.UserRegisterRequest;

@Component
public class UserValidator {

	@Autowired
	private ErrorInfoMapper swaErrorInfoMapper;

	@Autowired
	private UsersMapper accountMapper;

	public void validateFields(UserRegisterRequest userRegister) throws CustomException {

		ErrorInfoExample errorInfoExample = new ErrorInfoExample();

		if ((userRegister.getPassCd().length() < 8 && userRegister.getPassCd().length() > 16)
				|| (userRegister.getConfPassCd().length() < 8 && userRegister.getConfPassCd().length() > 16)) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C006");
			throw new CustomException(swaErrorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		if (!userRegister.getPassCd().equals(userRegister.getConfPassCd())) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C011");
			throw new CustomException(swaErrorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

		UsersExample accountExample = new UsersExample();
		accountExample.createCriteria().andEmailEqualTo(userRegister.getEmailId());
		int count = accountMapper.countByExample(accountExample);
		if (count > 0) {
			errorInfoExample.createCriteria().andErrorCodeEqualTo("C008");
			throw new CustomException(swaErrorInfoMapper.selectByExample(errorInfoExample).get(0));
		}

	}

}
