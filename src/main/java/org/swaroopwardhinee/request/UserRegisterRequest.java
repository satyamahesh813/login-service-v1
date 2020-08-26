package org.swaroopwardhinee.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRegisterRequest {

	@NotBlank(message = "C003")
	@Email(message = "C001")
	private String emailId;

	@NotBlank(message = "C002")
	private String firstName;

	private String middleName;

	@NotBlank(message = "C004")
	private String lastName;

	@NotBlank(message = "C005")
	// @Pattern(regexp="((?=.*[a-z])(?=.*\\\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,16})",
	private String passCd;

	@NotBlank(message = "C010")
	private String confPassCd;


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassCd() {
		return passCd;
	}

	public void setPassCd(String passCd) {
		this.passCd = passCd;
	}

	public String getConfPassCd() {
		return confPassCd;
	}

	public void setConfPassCd(String confPassCd) {
		this.confPassCd = confPassCd;
	}
}
