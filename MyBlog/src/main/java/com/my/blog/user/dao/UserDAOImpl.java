package com.my.blog.user.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.my.blog.security.CustomUserDetails;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@Override
	public CustomUserDetails selectLoginUser(String id) {
		return sqlSession.selectOne("com.my.blog.user.dao.UserDAO.selectLoginUser",id);
	}
	
}
