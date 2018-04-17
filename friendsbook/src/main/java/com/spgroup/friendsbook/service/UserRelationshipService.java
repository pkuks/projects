package com.spgroup.friendsbook.service;

import java.util.List;

import com.spgroup.friendsbook.model.FriendType;
import com.spgroup.friendsbook.model.UserRelationship;
import com.spgroup.friendsbook.model.UserRelationshipKey;

public interface UserRelationshipService {

	UserRelationship create(UserRelationshipKey key, FriendType friend, boolean b);

	UserRelationship connect(Integer requestorId, Integer targetId);

	UserRelationship subscribe(Integer requestorId, Integer targetId);

	UserRelationship block(Integer requestorId, Integer targetId);

	List<String> getEligibilityList(Integer senderId);



}