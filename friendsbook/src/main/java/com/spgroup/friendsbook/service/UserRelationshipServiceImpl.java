package com.spgroup.friendsbook.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spgroup.friendsbook.model.FriendType;
import com.spgroup.friendsbook.model.UserRelationship;
import com.spgroup.friendsbook.model.UserRelationshipKey;
import com.spgroup.friendsbook.repository.UserRelationshipRepository;

@Component
public class UserRelationshipServiceImpl implements UserRelationshipService {

	private static final Logger logger = LoggerFactory.getLogger(UserRelationshipServiceImpl.class);

	@Autowired
	public UserRelationshipRepository userRelationshipRepository;

	@Override
	public UserRelationship create(UserRelationshipKey key, FriendType type, boolean b) {
		//UserRelationship userRelationship = new UserRelationship(key,type, b);
		//userRelationshipRepository.save(userRelationship);
		
		UserRelationship userRelation = userRelationshipRepository.findByKey(key);
		if(userRelation == null) {
			userRelation = new UserRelationship(key, type, b);
		} else {
			if(!FriendType.FRIEND.equals(userRelation.getType())) {
				userRelation.setType(type);
			}
			userRelation.setBlock(b);
		}
		userRelationshipRepository.save(userRelation);
		
		logger.info("userRelationship : " + userRelation.toString());
		return userRelation;
		
	}
	
	@Override
	public UserRelationship connect(Integer requestorId, Integer targetId) {
		UserRelationshipKey key1 = new UserRelationshipKey(requestorId, targetId);
		UserRelationship userRelation1 = create(key1, FriendType.FRIEND, false);
		
		UserRelationshipKey key2 = new UserRelationshipKey(targetId, requestorId);
		UserRelationship userRelation2 = create(key2, FriendType.FRIEND, false);
		
		return userRelation1;
	}
	
	
	
	@Override
	public UserRelationship subscribe(Integer requestorId, Integer targetId) {
		UserRelationshipKey key = new UserRelationshipKey(requestorId, targetId);
		UserRelationship userRelation = create(key, FriendType.SUBSCRIBE, false);
		return userRelation;
	}
	
	@Override
	public UserRelationship block(Integer requestorId, Integer targetId) {
		UserRelationshipKey key = new UserRelationshipKey(requestorId, targetId);
		UserRelationship userRelation = userRelationshipRepository.findByKey(key);
		
		//if they are connected as friends, then requestor will no longer receive notifications from target
		if (userRelation != null) {
			userRelation.setBlock(true);
			userRelationshipRepository.save(userRelation);
			return userRelation;
		}
		//if they are not connected as friends, then no new friends connection can be added
		else {
			UserRelationship userRelation1 = create(key, FriendType.STRANGER, true);
			return userRelation1;
		}
	}

	@Override
	public List<String> getEligibilityList(Integer senderId) {
		List<String> recipients = new ArrayList<String>();
		List<UserRelationship> users = userRelationshipRepository.findByKeyFriendId(senderId);
		if(users != null && users.size() > 0) {
			for (UserRelationship userRelationship : users) {
				if(!userRelationship.isBlock()) {
					recipients.add(userRelationship.getUser().getEmailAddress());
				}
			}
		}
		return recipients;
	}
	
	
}
