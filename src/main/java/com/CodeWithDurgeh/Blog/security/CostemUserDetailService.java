package com.CodeWithDurgeh.Blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.CodeWithDurgeh.Blog.entities.User;
import com.CodeWithDurgeh.Blog.exceptions.ResourceNotFoundException;
import com.CodeWithDurgeh.Blog.repositorys.UserRepo;

@Service
public class CostemUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user from database by username

		User user = this.userRepo.findByEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("User", "email :" + username, 0));

		return user;
	}

}
