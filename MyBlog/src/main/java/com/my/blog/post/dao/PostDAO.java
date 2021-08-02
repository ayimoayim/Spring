package com.my.blog.post.dao;

import java.util.List;

import com.my.blog.post.vo.PostVO;

public interface PostDAO {
	public List<PostVO> selectPostList();
	
	public PostVO selectPostInfo(int id);
	
	public int insertPost(PostVO postVO);
	
	public int updatePost(PostVO postVO);
	
	public int deletePost(int id);
}
