package com.spgroup.friendsbook.request;

import java.util.List;

import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spgroup.friendsbook.exception.CustomException;
import com.spgroup.friendsbook.utils.EmailUtils;

public class Request {

	private static Logger logger = LoggerFactory.getLogger(Request.class);

	@Size(min = 2, max = 2)
	private List<String> friends;

	public Request() {
	}

	public Request(List<String> friends) {
		super();
		this.friends = friends;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "RetrieveCommon [friends=" + friends + "]";
	}

	public void checkEmails() throws CustomException {	
		EmailUtils.check(friends.get(0), friends.get(1));
		
		//check if both emails are same
		if(friends.get(0).equalsIgnoreCase(friends.get(1))) {
			logger.error("Email Address is duplicated");
			throw new CustomException("Email Address is duplicated");
		} 
		
	}
	
	
	
}
