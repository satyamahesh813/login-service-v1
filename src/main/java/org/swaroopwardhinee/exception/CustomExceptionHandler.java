package org.swaroopwardhinee.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.swaroopwardhinee.mappers.ErrorInfoMapper;
import org.swaroopwardhinee.models.ErrorInfo;
import org.swaroopwardhinee.models.ErrorInfoExample;
import org.swaroopwardhinee.response.CustomResponse;
import org.swaroopwardhinee.response.ErrorResponse;

@RestControllerAdvice
@RestController
public class CustomExceptionHandler {

	@Autowired
	private ErrorInfoMapper errorInfo;

	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<CustomResponse> handleException(CustomException ex, WebRequest req) {
		CustomResponse customResponse = null;
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ex.getErrorInfo().getErrorCode());
		errorResponse.setErrorDesc(ex.getErrorInfo().getErrorDesc());
		customResponse = new CustomResponse(null, false, errorResponse);
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public final ResponseEntity<CustomResponse> handleMethodException(MethodArgumentNotValidException ex,
			WebRequest req) {

		BindingResult bindingResult = ex.getBindingResult();
		String errorCode = bindingResult.getFieldErrors().get(0).getDefaultMessage().trim();
		ErrorInfoExample example = new ErrorInfoExample();
		example.createCriteria().andErrorCodeEqualTo(errorCode);
		ErrorInfo swaErrorInfo = errorInfo.selectByExample(example).get(0);
		CustomResponse customResponse = null;
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(swaErrorInfo.getErrorCode());
		errorResponse.setErrorDesc(swaErrorInfo.getErrorDesc());
		customResponse = new CustomResponse(null, false, errorResponse);
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}

}
