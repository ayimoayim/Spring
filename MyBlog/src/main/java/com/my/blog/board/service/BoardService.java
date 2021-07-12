package com.my.blog.board.service;

import java.util.List;

import com.my.blog.board.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> selectBoardList();
	
	public BoardVO selectBoardInfo(BoardVO boardVO);
	
	public int insertBoard(BoardVO boardVO);
	
	public int updateBoard(BoardVO boardVO);
	
	public int deleteBoard(BoardVO boardVO);
}
