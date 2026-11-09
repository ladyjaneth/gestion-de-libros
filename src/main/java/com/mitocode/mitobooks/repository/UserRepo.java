package com.mitocode.mitobooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.mitobooks.model.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Integer> {
	UserInfo findByUsername(String username);
}
