package com.spgroup.friendsbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spgroup.friendsbook.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmailAddress(String email);

}
