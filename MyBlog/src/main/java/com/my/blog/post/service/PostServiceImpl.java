package com.my.blog.post.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.blog.post.dao.PostDAO;
import com.my.blog.post.vo.PostVO;

@Service("PostService")
public class PostServiceImpl implements PostService{

	@Resource(name = "PostDAO")
	private PostDAO postDAO;
	
	@Override
	public List<PostVO> selectPostList() {
		return postDAO.selectPostList();
	}
	
	@Override
	public PostVO selectPostInfo(int id) {
		return postDAO.selectPostInfo(id);
	}

	@Override
	public int insertPost(PostVO postVO) {
		return postDAO.insertPost(postVO);
	}
	
	@Override
	public int updatePost(PostVO postVO) {
		return postDAO.updatePost(postVO);
	}
	
	@Override
	public int deletePost(int id) {
		return postDAO.deletePost(id);
	}
}
