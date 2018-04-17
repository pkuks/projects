package com.spgroup.friendsbook.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EligibleForUpdateRequest {

	@Email(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	@NotNull
	private String sender;
	
	@NotNull
	@NotEmpty
	private String text;

	public EligibleForUpdateRequest() {
	}	

	public EligibleForUpdateRequest(String sender,String text) {
		super();
		this.sender = sender;
		this.text = text;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "EligibleForUpdateRequest [sender=" + sender + ", text=" + text + "]";
	}	
	
	
	
	
}
