package org.swaroopwardhinee.request;

import javax.validation.constraints.NotBlank;

public class ForgotPasswordRequest {

	@NotBlank(message = "C003")
	private String emailId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
