package com.my.blog.user.dao;

import com.my.blog.security.CustomUserDetails;

public interface UserDAO {
	public CustomUserDetails selectLoginUser(String id);
}
