package com.my.blog.board.service;

import java.util.List;

import com.my.blog.board.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> selectBoardList();
}
