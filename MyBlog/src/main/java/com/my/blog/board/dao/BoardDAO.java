package com.my.blog.board.dao;

import java.util.List;

import com.my.blog.board.vo.BoardVO;

public interface BoardDAO {
	public List<BoardVO> selectBoardList();
	
	public BoardVO selectBoardInfo(BoardVO boardVO);
	
	public int insertBoard(BoardVO boardVO);
	
	public int updateBoard(BoardVO boardVO);
	
	public int deleteBoard(BoardVO boardVO);
}
