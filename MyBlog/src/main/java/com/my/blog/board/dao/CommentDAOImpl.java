package com.my.blog.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.my.blog.board.vo.CommentVO;

@Repository("CommentDAO")
public class CommentDAOImpl implements CommentDAO{
	
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	@Override
	public List<CommentVO> selectCommentList() {
		return sqlSession.selectList("com.my.blog.board.dao.CommentDAO.selectCommentList");
	}
	
	@Override
	public CommentVO selectComment(CommentVO commentVO) {
		return sqlSession.selectOne("com.my.blog.board.dao.CommentDAO.selectComment",commentVO);
	}

	@Override
	public int selectCommentSeq(CommentVO commentVO) {
		return sqlSession.selectOne("com.my.blog.board.dao.CommentDAO.selectCommentSeq",commentVO);
	}
	
	@Override
	public int insertComment(CommentVO commentVO) {
		return sqlSession.insert("com.my.blog.board.dao.CommentDAO.insertComment",commentVO);
	}
}
