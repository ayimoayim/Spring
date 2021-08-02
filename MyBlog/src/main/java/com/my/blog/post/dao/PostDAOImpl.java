package com.my.blog.post.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.my.blog.post.vo.PostVO;

@Repository("PostDAO")
public class PostDAOImpl implements PostDAO{
	
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	@Override
	public List<PostVO> selectPostList() {
		return sqlSession.selectList("com.my.blog.post.dao.PostDAO.selectPostList");
	}

	@Override
	public PostVO selectPostInfo(int id) {
		return sqlSession.selectOne("com.my.blog.post.dao.PostDAO.selectPostInfo",id);
	}
	
	@Override
	public int insertPost(PostVO postVO) {
		return sqlSession.insert("com.my.blog.post.dao.PostDAO.insertPost",postVO);
	}
	
	@Override
	public int updatePost(PostVO postVO) {
		return sqlSession.update("com.my.blog.post.dao.PostDAO.updatePost",postVO);
	}
	
	@Override
	public int deletePost(int id) {
		return sqlSession.update("com.my.blog.post.dao.PostDAO.deletePost",id);
	}
}
