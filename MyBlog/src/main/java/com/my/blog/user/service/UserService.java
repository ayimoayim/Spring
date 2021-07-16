package com.my.blog.user.service;

import java.util.List;

import com.my.blog.post.vo.PostVO;
import com.my.blog.security.CustomUserDetails;

public interface UserService {
	public CustomUserDetails selectLoginUser(String id);
}
