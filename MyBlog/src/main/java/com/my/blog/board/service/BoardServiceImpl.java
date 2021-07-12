package com.my.blog.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.blog.board.dao.BoardDAO;
import com.my.blog.board.vo.BoardVO;

@Service("BoardService")
public class BoardServiceImpl implements BoardService{

	@Resource(name = "BoardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> selectBoardList() {
		return boardDAO.selectBoardList();
	}
	
	@Override
	public BoardVO selectBoardInfo(BoardVO boardVO) {
		return boardDAO.selectBoardInfo(boardVO);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		return boardDAO.insertBoard(boardVO);
	}
	
	@Override
	public int updateBoard(BoardVO boardVO) {
		return boardDAO.updateBoard(boardVO);
	}
	
	@Override
	public int deleteBoard(BoardVO boardVO) {
		return boardDAO.deleteBoard(boardVO);
	}
}
