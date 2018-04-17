package com.spgroup.friendsbook.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class SubscribeRequest {

	@Email(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	@NotNull
	private String requestor;
	
	@Email(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	@NotNull
	private String target;

	public SubscribeRequest() {
	}
	
	public SubscribeRequest(String requestor,String target) {
		super();
		this.requestor = requestor;
		this.target = target;
	}

	public String getRequestor() {
		return requestor;
	}

	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return "SubscribeRequest [requestor=" + requestor + ", target=" + target + "]";
	}
	
	
}
