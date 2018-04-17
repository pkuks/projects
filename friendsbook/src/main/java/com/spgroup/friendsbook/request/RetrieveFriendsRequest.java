package com.spgroup.friendsbook.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class RetrieveFriendsRequest {

	@Email(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	@NotNull
	public String email;
	
	public RetrieveFriendsRequest() {
		
	}

	public RetrieveFriendsRequest(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RetrieveFriendsRequest [email=" + email + "]";
	}
	
	
	
	
}
