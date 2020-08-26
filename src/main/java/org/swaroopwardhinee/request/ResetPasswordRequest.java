package org.swaroopwardhinee.request;

import javax.validation.constraints.NotBlank;

public class ResetPasswordRequest {

	@NotBlank(message = "C003")
	private String emailId;

	@NotBlank(message = "C005")
	private String password;

	@NotBlank(message = "C010")
	private String confirmPassword;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
