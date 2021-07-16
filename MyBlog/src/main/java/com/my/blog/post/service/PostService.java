package com.my.blog.post.service;

import java.util.List;

import com.my.blog.post.vo.PostVO;

public interface PostService {
	public List<PostVO> selectPostList();
	
	public PostVO selectPostInfo(PostVO postVO);
	
	public int insertPost(PostVO postVO);
	
	public int updatePost(PostVO postVO);
	
	public int deletePost(PostVO postVO);
}
