package com.my.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailService;
	
	@SuppressWarnings("null")
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String id = (String)authentication.getPrincipal();
		String password = (String)authentication.getCredentials();
		CustomUserDetails userDetails  = (CustomUserDetails) userDetailService.loadUserByUsername(id);
		if(userDetails == null || !passwordCheck(password,userDetails.getPassword()) || !userDetails.isEnabled()) {
			throw new BadCredentialsException("아이디 또는 비밀번호를 확인해주세요.");
		}
		return new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
	public boolean passwordCheck(String password,String userPassword) {
		return password.equals(userPassword);
	}

}
