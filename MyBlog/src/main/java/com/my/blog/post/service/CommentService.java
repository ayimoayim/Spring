package com.my.blog.post.service;

import java.util.List;

import com.my.blog.post.vo.CommentVO;

public interface CommentService {
	public List<CommentVO> selectCommentList(int id);
	
	public CommentVO selectComment(CommentVO commentVO);
	
	public int selectCommentSeq(CommentVO commentVO);
	
	public int insertComment(CommentVO commentVO);
}
