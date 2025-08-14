package com.hotel.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hotel.entity.User;
import com.hotel.repo.UserRepo;

@Service
public class UserEntityService implements UserDetailsService {

	private final UserRepo userRepo;

	public UserEntityService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByUsername(username).orElseThrow(()->new RuntimeException("User Not Found"));
		
		return org.springframework.security.core.userdetails.User
															.withUsername(user.getUsername())
															.password(user.getPassword())
															.roles(user.getRole())
															.build();
	}

}
