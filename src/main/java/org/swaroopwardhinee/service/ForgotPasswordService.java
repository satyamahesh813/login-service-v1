package org.swaroopwardhinee.service;

import org.swaroopwardhinee.exception.CustomException;
import org.swaroopwardhinee.request.ForgotPasswordRequest;

public interface ForgotPasswordService {

	public String forgotPassword(ForgotPasswordRequest forgotPasswordRequest) throws CustomException;

}
