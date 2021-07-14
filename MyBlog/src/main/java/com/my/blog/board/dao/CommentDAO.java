package com.my.blog.board.dao;

import java.util.List;

import com.my.blog.board.vo.CommentVO;

public interface CommentDAO {
	public List<CommentVO> selectCommentList();
	
	public CommentVO selectComment(CommentVO commentVO);
	
	public int selectCommentSeq(CommentVO commentVO);
	
	public int insertComment(CommentVO commentVO);
	
}
