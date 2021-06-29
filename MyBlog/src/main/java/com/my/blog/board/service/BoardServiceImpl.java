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

}
