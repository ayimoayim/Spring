package com.my.blog.board.dao;

import java.util.List;

import com.my.blog.board.vo.BoardVO;

public interface BoardDAO {
	public List<BoardVO> selectBoardList();
}
