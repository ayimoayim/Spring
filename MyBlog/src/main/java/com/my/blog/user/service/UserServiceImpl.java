package com.my.blog.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.blog.board.dao.BoardDAO;
import com.my.blog.board.vo.BoardVO;
import com.my.blog.security.CustomUserDetails;
import com.my.blog.user.dao.UserDAO;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Resource(name = "UserDAO")
	private UserDAO userDAO;

	@Override
	public CustomUserDetails selectLoginUser(String id) {
		return userDAO.selectLoginUser(id);
	}

}
