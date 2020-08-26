package org.swaroopwardhinee.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

	@NotBlank(message = "C003")
	private String userName;

	@NotBlank(message = "C005")
	private String loginPassCd;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginPassCd() {
		return loginPassCd;
	}

	public void setLoginPassCd(String loginPassCd) {
		this.loginPassCd = loginPassCd;
	}
}
