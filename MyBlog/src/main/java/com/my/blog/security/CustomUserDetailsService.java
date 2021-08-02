package com.my.blog.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.my.blog.user.dao.UserDAO;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		try {
			userDetails = createUser(id,userDAO.selectLoginUser(id));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return userDetails;
	}
	
	private User createUser(String id, UserDetails userDetails) {
		 if(!userDetails.isEnabled()) {
			 throw new RuntimeException(id + " -> 활성화되어 있지 않습니다.");
		 }
		return new User(userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities());
	}

}
