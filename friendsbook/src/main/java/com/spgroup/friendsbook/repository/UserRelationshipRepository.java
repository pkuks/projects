package com.spgroup.friendsbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spgroup.friendsbook.model.UserRelationship;
import com.spgroup.friendsbook.model.UserRelationshipKey;

@Repository
public interface UserRelationshipRepository extends JpaRepository<UserRelationship, Integer>{
	UserRelationship findByKey(UserRelationshipKey key);

	List<UserRelationship> findByKeyFriendId(Integer senderId);
}
