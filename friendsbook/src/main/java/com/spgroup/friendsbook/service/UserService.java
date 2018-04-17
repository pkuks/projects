package com.spgroup.friendsbook.service;

import com.spgroup.friendsbook.model.User;

public interface UserService {

	User create(String email1);

	User findByEmail(String email);

}