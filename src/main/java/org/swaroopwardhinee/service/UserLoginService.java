package org.swaroopwardhinee.service;

import org.swaroopwardhinee.exception.CustomException;
import org.swaroopwardhinee.request.LoginRequest;
import org.swaroopwardhinee.response.LoginResponse;

public interface UserLoginService {

	public LoginResponse userLogin(LoginRequest loginRequest) throws CustomException;

}
