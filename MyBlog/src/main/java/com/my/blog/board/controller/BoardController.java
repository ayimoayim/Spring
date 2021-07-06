package com.my.blog.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.blog.board.service.BoardService;
import com.my.blog.board.vo.BoardVO;

@Controller
public class BoardController {

	@Resource(name = "BoardService")
	private BoardService boardService;
	
	
	@RequestMapping("/test")
	private String test(Model model) {
		try {
			List<BoardVO> boardList = boardService.selectBoardList();
			model.addAttribute("boardList",boardList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index.tiles";
	}
	
	@RequestMapping("/admin/test")
	private String test2(Model model) {
		try {
			List<BoardVO> boardList = boardService.selectBoardList();
			model.addAttribute("boardList",boardList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index.tiles";
	}
}
