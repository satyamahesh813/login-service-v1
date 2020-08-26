package org.swaroopwardhinee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.swaroopwardhinee.exception.CustomException;
import org.swaroopwardhinee.request.ForgotPasswordRequest;
import org.swaroopwardhinee.request.LoginRequest;
import org.swaroopwardhinee.request.ResetPasswordRequest;
import org.swaroopwardhinee.request.UserRegisterRequest;
import org.swaroopwardhinee.response.CustomResponse;
import org.swaroopwardhinee.response.LoginResponse;
import org.swaroopwardhinee.service.ForgotPasswordService;
import org.swaroopwardhinee.service.ResetPasswordService;
import org.swaroopwardhinee.service.UserLoginService;
import org.swaroopwardhinee.service.UserService;
import org.swaroopwardhinee.util.CommonUtil;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	private UserService userService;

	@Autowired
	private UserLoginService userLoginService;

	@Autowired
	private ForgotPasswordService forgotPasswordService;

	@Autowired
	private ResetPasswordService resetPasswordService;

	@PostMapping("/register")
	public ResponseEntity<CustomResponse> userRegister(@Validated @RequestBody UserRegisterRequest userRegister)
			throws CustomException {

		CustomResponse customResponse = null;
		ResponseEntity<CustomResponse> response = null;
		try {
			String studentId = userService.userRegister(userRegister);
			customResponse = new CustomResponse(null, true, studentId);
			response = new ResponseEntity<>(customResponse, HttpStatus.OK);
		} catch (CustomException ex) {
			commonUtil.handleServiceExceptio(ex);
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@PostMapping("/login")
	public ResponseEntity<CustomResponse> userLogin(@Validated @RequestBody LoginRequest LoginRequest)
			throws CustomException {

		CustomResponse customResponse = null;
		ResponseEntity<CustomResponse> response = null;
		try {
			LoginResponse loginResponse = userLoginService.userLogin(LoginRequest);
			customResponse = new CustomResponse(null, true, loginResponse);
			response = new ResponseEntity<>(customResponse, HttpStatus.OK);
		} catch (CustomException ex) {
			commonUtil.handleServiceExceptio(ex);
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@PostMapping("/forgotpassword")
	public ResponseEntity<CustomResponse> forgotPassword(
			@Validated @RequestBody ForgotPasswordRequest forgotPasswordReq) throws CustomException {

		CustomResponse customResponse = null;
		ResponseEntity<CustomResponse> response = null;
		try {
			String forgotPasswordResponse = forgotPasswordService.forgotPassword(forgotPasswordReq);
			customResponse = new CustomResponse(null, true, forgotPasswordResponse);
			response = new ResponseEntity<>(customResponse, HttpStatus.OK);
		} catch (CustomException ex) {
			commonUtil.handleServiceExceptio(ex);
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@PostMapping("/resetpassword")
	public ResponseEntity<CustomResponse> resetPassword(@Validated @RequestParam String token,
			@RequestBody ResetPasswordRequest resetPassword) throws CustomException {

		CustomResponse customResponse = null;
		ResponseEntity<CustomResponse> response = null;
		try {
			String forgotPasswordResponse = resetPasswordService.resetPassword(token, resetPassword);
			customResponse = new CustomResponse(null, true, forgotPasswordResponse);
			response = new ResponseEntity<>(customResponse, HttpStatus.OK);
		} catch (CustomException ex) {
			commonUtil.handleServiceExceptio(ex);
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
