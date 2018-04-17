package com.spgroup.friendsbook.response;

import java.util.List;

public class EligibleForUpdateResponse {

	private boolean success;
	
	private List<String> recipients;
	
	public EligibleForUpdateResponse() {
	}
	
	public EligibleForUpdateResponse(boolean success, List<String> recipients, int count) {
		super();
		this.success = success;
		this.recipients = recipients;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<String> getRecipients() {
		return recipients;
	}

	public void setFriends(List<String> recipients) {
		this.recipients = recipients;
	}

	@Override
	public String toString() {
		return "EligibleForUpdateResponse [success=" + success + ", recipients=" + recipients + "]";
	}
	
}
