package com.my.blog.post.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.blog.post.service.PostService;
import com.my.blog.post.service.CommentService;
import com.my.blog.post.vo.PostVO;
import com.my.blog.security.CustomUserDetails;

@RestController
@RequestMapping("/api/post")
public class PostApiController {

	@Resource(name = "PostService")
	private PostService postService;
	
	@Resource(name = "CommentService")
	private CommentService commentService;
	
	@GetMapping("")
	private ResponseEntity<List<PostVO>> post() {

		List<PostVO> postList = postService.selectPostList();

		return ResponseEntity.status(HttpStatus.CREATED).body(postList);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<PostVO> postInfo(@PathVariable int id) {
		
		PostVO post = postService.selectPostInfo(id);
			
		return ResponseEntity.status(HttpStatus.CREATED).body(post);
	}
	
	@PostMapping("")
	private ResponseEntity adminPostInsert(@PathVariable int id, @RequestBody PostVO postVO) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try {
			CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userNo = customUserDetails.getReg_no();
			
			if(userNo != null && !userNo.equals("")) {
				postVO.setReg_no(String.valueOf(id));
				postService.insertPost(postVO);
				
				map.put("status", "200");
				map.put("result", "OK");
			}
		}catch (Exception e) {
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(map);
	}
	
	@PutMapping("/{id}")
	private ResponseEntity adminPostUpdate(@PathVariable int id, @RequestBody PostVO postVO) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try {
			CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userNo = customUserDetails.getReg_no();
			
			if(userNo != null && !userNo.equals("")) {
				postVO.setReg_no(String.valueOf(id));
				postService.updatePost(postVO);
				
				map.put("status", "200");
				map.put("result", "OK");
			}
		}catch (Exception e) {
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(map);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity adminPostDelte(@PathVariable int id) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try {
			CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userNo = customUserDetails.getReg_no();
			
			if(userNo != null && !userNo.equals("")) {
				postService.deletePost(id);
				
				map.put("status", "200");
				map.put("result", "OK");
			}
		}catch (Exception e) {
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(map);
	}
}
