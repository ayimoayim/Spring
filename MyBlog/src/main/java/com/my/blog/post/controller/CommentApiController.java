package com.my.blog.post.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.blog.post.service.CommentService;
import com.my.blog.post.vo.CommentVO;
import com.my.blog.util.MakeHtmlUtil;

@RestController
@RequestMapping("/api/comment")
public class CommentApiController {
	
	@Resource(name = "CommentService")
	private CommentService commentService;
	
	
	@GetMapping("/{id}")
	private ResponseEntity comment(@PathVariable int id) {
		
		List<CommentVO> commentList = commentService.selectCommentList(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(commentList);
	}
	
	@PostMapping("")
	private ResponseEntity addComment(@RequestBody CommentVO commentVO) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			
			if("1".equals(commentVO.getDepth())) {
				commentVO.setSeq("1");
			}else {
				int seq = commentService.selectCommentSeq(commentVO) + 1;
				commentVO.setSeq(String.valueOf(seq));
			}
			
			commentService.insertComment(commentVO);
			List<CommentVO> comentList = commentService.selectCommentList(Integer.valueOf(commentVO.getPost_no()));
			String html = MakeHtmlUtil.makeCommentHtml(comentList);
			map.put("status", "200");
			map.put("result", "OK");
			map.put("commentBlock", html);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(map);
	}
	
	@PutMapping("")
	private ResponseEntity modifyComment(@RequestBody CommentVO commentVO) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body("");
	}
	
	@DeleteMapping("")
	private ResponseEntity delteComment(@RequestBody CommentVO commentVO) {
		
		
		
		return ResponseEntity.status(HttpStatus.OK).body("");
	}
}
