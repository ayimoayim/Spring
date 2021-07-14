package com.my.blog.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.blog.board.dao.CommentDAO;
import com.my.blog.board.vo.CommentVO;

@Service("CommentService")
public class CommentServiceImpl implements CommentService{

	@Resource(name = "CommentDAO")
	private CommentDAO commentDAO;

	@Override
	public List<CommentVO> selectCommentList() {
		return commentDAO.selectCommentList();
	}
	
	@Override
	public CommentVO selectComment(CommentVO commentVO) {
		return commentDAO.selectComment(commentVO);
	}

	@Override
	public int selectCommentSeq(CommentVO commentVO) {
		return commentDAO.selectCommentSeq(commentVO);
	}
	
	@Override
	public int insertComment(CommentVO commentVO) {
		return commentDAO.insertComment(commentVO);
	}
	
}
