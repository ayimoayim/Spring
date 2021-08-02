package com.my.blog.post.dao;

import java.util.List;

import com.my.blog.post.vo.CommentVO;

public interface CommentDAO {
	public List<CommentVO> selectCommentList(int id);
	
	public CommentVO selectComment(CommentVO commentVO);
	
	public int selectCommentSeq(CommentVO commentVO);
	
	public int insertComment(CommentVO commentVO);
	
}
