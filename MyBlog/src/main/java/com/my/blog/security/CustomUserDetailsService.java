package com.my.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.my.blog.user.dao.UserDAO;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		try {
			userDetails = userDAO.selectLoginUser(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return userDetails;
	}

}
