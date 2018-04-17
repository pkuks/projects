package com.spgroup.friendsbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spgroup.friendsbook.model.User;
import com.spgroup.friendsbook.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;

	@Override
	public User create(String email) {
		User user = userRepository.findByEmailAddress(email);
		if(user == null) {
			user = new User(email);
			userRepository.save(user);
		}
		return user;
	}

	@Override
	public User findByEmail(String email) {
		User user = userRepository.findByEmailAddress(email);
		return user;
	}
	
}
