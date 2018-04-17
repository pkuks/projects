package com.spgroup.friendsbook.service;

import java.util.List;
import java.util.Set;

import com.spgroup.friendsbook.model.UserRelationship;

public interface ManageFriendService {
	 UserRelationship connect(String email1, String email2);
	 
	 Set<String> retrieveFriends(String email);

	 List<String> retrieveCommon(String email1, String email2);
	 
	 UserRelationship subscribe(String requestorEmail, String targetEmail);

	UserRelationship block(String requestorEmail, String targetEmail);

	List<String> getEligibilityList(String senderEmail);

}
