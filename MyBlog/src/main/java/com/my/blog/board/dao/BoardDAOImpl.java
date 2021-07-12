package com.my.blog.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.my.blog.board.vo.BoardVO;

@Repository("BoardDAO")
public class BoardDAOImpl implements BoardDAO{
	
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVO> selectBoardList() {
		return sqlSession.selectList("com.my.blog.board.dao.BoardDAO.selectBoardList");
	}

	@Override
	public BoardVO selectBoardInfo(BoardVO boardVO) {
		return sqlSession.selectOne("com.my.blog.board.dao.BoardDAO.selectBoardInfo",boardVO);
	}
	
	@Override
	public int insertBoard(BoardVO boardVO) {
		return sqlSession.insert("com.my.blog.board.dao.BoardDAO.insertBoard",boardVO);
	}
	
	@Override
	public int updateBoard(BoardVO boardVO) {
		return sqlSession.update("com.my.blog.board.dao.BoardDAO.updateBoard",boardVO);
	}
	
	@Override
	public int deleteBoard(BoardVO boardVO) {
		return sqlSession.update("com.my.blog.board.dao.BoardDAO.deleteBoard",boardVO);
	}
}
