package org.swaroopwardhinee.service;

import org.swaroopwardhinee.exception.CustomException;
import org.swaroopwardhinee.request.ResetPasswordRequest;

public interface ResetPasswordService {

	public String resetPassword(String token, ResetPasswordRequest resetPasswordReq) throws CustomException;
}
