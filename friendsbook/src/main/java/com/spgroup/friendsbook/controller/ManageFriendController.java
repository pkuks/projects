package com.spgroup.friendsbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spgroup.friendsbook.exception.CustomException;
import com.spgroup.friendsbook.model.UserRelationship;
import com.spgroup.friendsbook.request.EligibleForUpdateRequest;
import com.spgroup.friendsbook.request.Request;
import com.spgroup.friendsbook.request.RetrieveFriendsRequest;
import com.spgroup.friendsbook.request.SubscribeRequest;
import com.spgroup.friendsbook.response.EligibleForUpdateResponse;
import com.spgroup.friendsbook.response.Response;
import com.spgroup.friendsbook.response.RetrieveFriendsResponse;
import com.spgroup.friendsbook.service.ManageFriendService;


@RestController
public class ManageFriendController {

	private static final Logger logger = LoggerFactory.getLogger(ManageFriendController.class);

	@Autowired
	public ManageFriendService manageFriendService;
	
	@PostMapping(value="/connect")
	public Response connect(@Valid @RequestBody Request request) throws CustomException {
		request.checkEmails();
		
		logger.info(" FriendManageController - connect : " + request.toString());		
		
		UserRelationship userRelationship = manageFriendService.connect(
				request.getFriends().get(0), request.getFriends().get(1));

		//Integer userId=userRelationship.getKey().getUserId();
		
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().
		//		path("/{id}").buildAndExpand(userId).toUri();

		//return ResponseEntity.created(location).build();
		boolean success = true;
		logger.info("FriendManageController Connect" + success);
		return new Response(success);
	}
	

	//retrieve friends with request parameter
	@GetMapping(value="/retrieve")
	public RetrieveFriendsResponse retrieveFriend(@RequestParam("email") String email) {
		
		logger.info(" FriendManageController - retrieveFriends : " + email);
		
		List<String> friends = new ArrayList<String>(manageFriendService.retrieveFriends(email));
		
		return new RetrieveFriendsResponse(true, friends, friends.size());
	}

	//retrieve friends with request body
	@PostMapping(value="/retrieve")
	public RetrieveFriendsResponse retrieveFriend(@Valid @RequestBody RetrieveFriendsRequest request) {
		
		logger.info(" FriendManageController - retrieveFriends : " + request.toString());
		
		List<String> friends = new ArrayList<String>(manageFriendService.retrieveFriends(request.getEmail()));
		
		return new RetrieveFriendsResponse(true, friends, friends.size());
	}
	
	//retrieve common friends with request body
	@PostMapping(value="/retrieveCommon")
	public RetrieveFriendsResponse retrieveCommon(@Valid @RequestBody Request request) throws CustomException{
		
		logger.info(" FriendManageController - retrieveCommon : " + request.toString());		
		request.checkEmails();
		List<String> friends = new ArrayList<String>(manageFriendService.retrieveCommon(
				request.getFriends().get(0), request.getFriends().get(1)));
		
		return new RetrieveFriendsResponse(true, friends, friends.size());
	}

	
	//subscribe
	@PostMapping(value="/subscribe")
	public Response subscribe(@Valid @RequestBody SubscribeRequest request) throws CustomException{
		
		logger.info(" FriendManageController - subscribe : " + request.toString());		
		UserRelationship userRelationship = manageFriendService.subscribe(request.getRequestor(), request.getTarget());
		
		boolean success = true;
		logger.info("FriendManageController subscribe" + success);
		return new Response(success);
	}
	
	//block
	@PostMapping(value="/block")
	public Response block(@Valid @RequestBody SubscribeRequest request) throws CustomException{
		
		logger.info(" FriendManageController - block : " + request.toString());		
		UserRelationship userRelationship = manageFriendService.block(
				request.getRequestor(), request.getTarget());
		
		boolean success = true;
		logger.info("FriendManageController block" + success);
		return new Response(success);
	}
	
	//get Eligibility List for updates
	@PostMapping(value="/eligible")
	public EligibleForUpdateResponse getEligibilityList(@Valid @RequestBody EligibleForUpdateRequest request) throws CustomException{
		
		logger.info(" FriendManageController - get Eligibility List : " + request.toString());
		
		List<String> recipients = manageFriendService.getEligibilityList(request.getSender());
		
		logger.info("FriendManageController - get Eligibility List" + recipients);
		return new EligibleForUpdateResponse(true, recipients, recipients.size());
	}
	
	
}



