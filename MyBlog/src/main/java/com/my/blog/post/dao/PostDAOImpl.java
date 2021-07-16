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
		return sqlSession.selectList("com.my.blog.Post.dao.PostDAO.selectPostList");
	}

	@Override
	public PostVO selectPostInfo(PostVO postVO) {
		return sqlSession.selectOne("com.my.blog.Post.dao.PostDAO.selectPostInfo",postVO);
	}
	
	@Override
	public int insertPost(PostVO postVO) {
		return sqlSession.insert("com.my.blog.Post.dao.PostDAO.insertPost",postVO);
	}
	
	@Override
	public int updatePost(PostVO postVO) {
		return sqlSession.update("com.my.blog.Post.dao.PostDAO.updatePost",postVO);
	}
	
	@Override
	public int deletePost(PostVO postVO) {
		return sqlSession.update("com.my.blog.Post.dao.PostDAO.deletePost",postVO);
	}
}
