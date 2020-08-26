package org.swaroopwardhinee.service;

import org.swaroopwardhinee.exception.CustomException;
import org.swaroopwardhinee.request.UserRegisterRequest;

public interface UserService {
	
	public String userRegister(UserRegisterRequest userRegister) throws CustomException;

}
