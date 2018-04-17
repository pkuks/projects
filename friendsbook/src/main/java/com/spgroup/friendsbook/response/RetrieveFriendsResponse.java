package com.spgroup.friendsbook.response;

import java.util.List;

public class RetrieveFriendsResponse {

	private boolean success;
	
	private List<String> friends;
	
	private int count = 0;

	public RetrieveFriendsResponse() {
	}
	
	public RetrieveFriendsResponse(boolean success, List<String> friends, int count) {
		super();
		this.success = success;
		this.friends = friends;
		this.count = count;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "RetrieveFriendsResponse [success=" + success + ", friends=" + friends + ", count=" + count + "]";
	}

}
