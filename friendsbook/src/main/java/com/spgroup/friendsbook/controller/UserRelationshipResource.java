package com.spgroup.friendsbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.spgroup.friendsbook.model.User;
import com.spgroup.friendsbook.model.UserRelationship;
import com.spgroup.friendsbook.repository.UserRelationshipRepository;
import com.spgroup.friendsbook.repository.UserRepository;


public class UserRelationshipResource {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRelationshipRepository userRelationshipRepository;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	} 
	
	@GetMapping("/userRelationships")
	public List<UserRelationship> retrieveAllUserRelationships(){
		return userRelationshipRepository.findAll();
	}
	

}
