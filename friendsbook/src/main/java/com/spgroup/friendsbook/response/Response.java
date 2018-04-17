package com.spgroup.friendsbook.response;

public class Response {

	public boolean success;

	public Response() {
	}
	
	
	public Response(boolean success) {
		super();
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}


	@Override
	public String toString() {
		return "ConnectResponse [success=" + success + "]";
	}
	
	
	
	
}
