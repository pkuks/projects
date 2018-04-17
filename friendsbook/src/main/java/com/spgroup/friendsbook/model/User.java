package com.spgroup.friendsbook.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name="user")
@ApiModel(description="Details about the user. ")
public class User {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="email_address")
	@NotNull
	@Email
	@Size(max=80)
	private String emailAddress;
	
	@OneToMany(mappedBy="key.userId", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	List<UserRelationship> friends;

	
	public User(String emailAddress) {
		super();
		this.emailAddress = emailAddress;
	}
	
	public User() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<UserRelationship> getFriends() {
		return friends;
	}

	public void setFriends(List<UserRelationship> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", emailAddress=" + emailAddress + "]";
	}
	
	
	
	
	
	
	
	
}
