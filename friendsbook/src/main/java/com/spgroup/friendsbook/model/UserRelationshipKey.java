package com.spgroup.friendsbook.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Embeddable
public class UserRelationshipKey implements Serializable{

	@Column(name="user_id")
	@NotNull
	private Integer userId;
	
	@Column(name="friend_id")
	@NotNull
	private Integer friendId;

	public UserRelationshipKey() {

	}

	public UserRelationshipKey(Integer userId, Integer friendId) {
		super();
		this.userId = userId;
		this.friendId = friendId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFriendId() {
		return friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	@Override
	public String toString() {
		return "UserRelationshipKey [userId=" + userId + ", friendId=" + friendId + "]";
	}
	

	
	
	
	
}
