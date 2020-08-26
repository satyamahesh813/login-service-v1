package org.swaroopwardhinee.exception;

import org.swaroopwardhinee.models.ErrorInfo;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	private final transient ErrorInfo errorInfo;

	public CustomException() {
		this.errorInfo = new ErrorInfo();
	}

	public CustomException(ErrorInfo errorMd) {
		this.errorInfo = errorMd;
	}

	public ErrorInfo getErrorInfo() {
		return this.errorInfo;
	}

}
