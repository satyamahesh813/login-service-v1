package org.swaroopwardhinee.response;

public class CustomResponse {

	private String code;
	private String status;
	private Object response;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CustomResponse(String code, String status, Object response) {
		this.code = code;
		this.status = status;
		this.response = response;
	}

	public CustomResponse(String code, boolean status, Object response) {
		this.code = code;
		this.status = status ? "SUCCESS" : "FAILED";
		this.response = response;
	}
	
	public CustomResponse() {
		this.code = "200";
		this.status = "SUCCESS";
		this.response = "";
	}

}
