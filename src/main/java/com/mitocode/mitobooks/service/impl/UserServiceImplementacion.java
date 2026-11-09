package com.mitocode.mitobooks.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mitocode.mitobooks.model.UserInfo;
import com.mitocode.mitobooks.repository.UserRepo;

import lombok.RequiredArgsConstructor;
 
	@RequiredArgsConstructor
	@Service
public class UserServiceImplementacion implements UserDetailsService {


		//inyección de dependencias
		private final UserRepo repositorio;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user = repositorio.findByUsername(username);
		
		return User.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole())
				.build();
	}

}
