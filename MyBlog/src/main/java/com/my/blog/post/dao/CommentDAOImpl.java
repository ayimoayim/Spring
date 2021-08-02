package com.my.blog.post.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.my.blog.post.vo.CommentVO;

@Repository("CommentDAO")
public class CommentDAOImpl implements CommentDAO{
	
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	@Override
	public List<CommentVO> selectCommentList(int id) {
		return sqlSession.selectList("com.my.blog.post.dao.CommentDAO.selectCommentList",id);
	}
	
	@Override
	public CommentVO selectComment(CommentVO commentVO) {
		return sqlSession.selectOne("com.my.blog.post.dao.CommentDAO.selectComment",commentVO);
	}

	@Override
	public int selectCommentSeq(CommentVO commentVO) {
		return sqlSession.selectOne("com.my.blog.post.dao.CommentDAO.selectCommentSeq",commentVO);
	}
	
	@Override
	public int insertComment(CommentVO commentVO) {
		return sqlSession.insert("com.my.blog.post.dao.CommentDAO.insertComment",commentVO);
	}
}
