package com.spgroup.friendsbook.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spgroup.friendsbook.exception.UserNotFoundException;
import com.spgroup.friendsbook.model.FriendType;
import com.spgroup.friendsbook.model.User;
import com.spgroup.friendsbook.model.UserRelationship;

@Component
public class ManageFriendServiceImpl implements ManageFriendService{

	private static final Logger logger = LoggerFactory.getLogger(ManageFriendServiceImpl.class);
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRelationshipService userRelationshipService;
	
	//1. As a user, I need an API to create a friend connection between two email addresses.
	
	public UserRelationship connect(String email1, String email2) {
	
		//create user
		User user1 = userService.create(email1);
		User user2 = userService.create(email2);
		logger.info("User 1 " + user1.toString());
		logger.info("User 2 " + user2.toString());
		
		UserRelationship userRelationship1 = userRelationshipService.connect(user1.getUserId(), user2.getUserId());
		
		//create userRelationship
		//UserRelationshipKey key1 = new UserRelationshipKey(user1.getUserId(), user2.getUserId());
		//UserRelationship userRelationship1 = userRelationshipService.create(key1,FriendType.FRIEND, false);
		
		//UserRelationshipKey key2 = new UserRelationshipKey(user2.getUserId(), user1.getUserId());
		//userRelationshipService.create(key2,FriendType.FRIEND, false);
		
		return userRelationship1;
	}
	
	//2. As a user, I need an API to retrieve the friends list for an email address.
	public Set<String> retrieveFriends(String email){
		Set<String> friends = new HashSet<String>();
		User user = retreiveUser(email);
		List<UserRelationship> userRelations = user.getFriends();
		for (UserRelationship userRelation : userRelations) {
			if(FriendType.FRIEND.equals(userRelation.getType())) {
				friends.add(userRelation.getFriend().getEmailAddress());
			}
		}
		return friends;
	}
	
	public User retreiveUser(String email) {
		User user = userService.findByEmail(email);
		if(user == null) {
			logger.error("User with email {} doesn't exists", email);
			throw new UserNotFoundException("User with email :" + email + " doesn't exist");
		}
		return user;
	}
		
	//3. As a user, I need an API to retrieve the common friends list between two email addresses.
	@Override
	public List<String> retrieveCommon(String email1, String email2) {
		
		List<String> commonFriends = new ArrayList<String>();
		Set<String> friend1 = retrieveFriends(email1);
		Set<String> friend2 = retrieveFriends(email2);
		
		if(friend1.size() > 0 && friend2.size() > 0) {
			for(String friend: friend2) {
				if(friend1.contains(friend)) {
					commonFriends.add(friend);
				}
			}
		}
		return commonFriends;
	}

	//4. As a user, I need an API to subscribe to updates from an email address.
	@Override
	public UserRelationship subscribe(String requestorEmail, String targetEmail) {
		//create user
		User requestor = userService.create(requestorEmail);
		User target = userService.create(targetEmail);
		logger.info("User 1 " + requestor.toString());
		logger.info("User 2 " + target.toString());
		
		//subscribe userRelationship
		UserRelationship userRelationship = userRelationshipService.subscribe(requestor.getUserId(), target.getUserId());
		//UserRelationshipKey key = new UserRelationshipKey(requestor.getUserId(), target.getUserId());
		//UserRelationship userRelationship = userRelationshipService.create(key,FriendType.SUBSCRIBE, false);
		
		return userRelationship;

	}
		
	//5. As a user, I need an API to block updates from an email address.
	@Override
	public UserRelationship block(String requestorEmail, String targetEmail) {
		//create user
		User requestor = userService.create(requestorEmail);
		User target = userService.create(targetEmail);
		logger.info("Requestor " + requestor.toString());
		logger.info("Target " + target.toString());
		
		//block
		UserRelationship userRelationship = userRelationshipService.block(
				requestor.getUserId(), target.getUserId());

		logger.info("Block User Relationship " + userRelationship.toString());
		return userRelationship;

	}
	
	//6. As a user, I need an API to retrieve all email addresses that can receive updates from an email address.
	@Override
	public List<String> getEligibilityList(String senderEmail) {
		User sender = userService.findByEmail(senderEmail);
		List<String> recipients = userRelationshipService.getEligibilityList(sender.getUserId());
		logger.info("Recipients " + recipients.toString());
		return recipients;

	}

}
