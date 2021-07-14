package com.my.blog.board.service;

import java.util.List;

import com.my.blog.board.vo.CommentVO;

public interface CommentService {
	public List<CommentVO> selectCommentList();
	
	public CommentVO selectComment(CommentVO commentVO);
	
	public int selectCommentSeq(CommentVO commentVO);
	
	public int insertComment(CommentVO commentVO);
}
