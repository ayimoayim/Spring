package com.my.blog.board.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.blog.board.service.BoardService;
import com.my.blog.board.vo.BoardVO;
import com.my.blog.security.CustomUserDetails;

@Controller
public class BoardController {

	@Resource(name = "BoardService")
	private BoardService boardService;
	
	
	@RequestMapping("/post")
	private String post(Model model) {
		try {
			List<BoardVO> boardList = boardService.selectBoardList();
			model.addAttribute("boardList",boardList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "board/index";
	}
	
	@RequestMapping("/post/info")
	private String postInfo(HttpServletRequest request, HttpServletResponse response, Model model, BoardVO boardVO) {
		
		try {
			BoardVO board = boardService.selectBoardInfo(boardVO);
			model.addAttribute("boardInfo",board);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "board/post-info";
	}
	
	@RequestMapping(value = "/admin/post/editor", method = {RequestMethod.GET})
	private String adminPostEditor(HttpServletRequest request, HttpServletResponse response, Model model, BoardVO boardVO) {
		
		String regNo = request.getParameter("reg_no");
		
		try {
			CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userNo = customUserDetails.getReg_no();
			if(regNo != null && !regNo.equals("")) {
				boardVO.setReg_no(regNo);
				BoardVO board = boardService.selectBoardInfo(boardVO);
				if(board.getUser_no().equals(userNo)) {
					model.addAttribute("boardInfo",board);
					model.addAttribute("viewType","postUpdate");
				}else {
					return "redirect:/post";
				}
			}else {
				model.addAttribute("viewType","postInsert");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "board/post-editor";
	}
	
	@RequestMapping(value = "/admin/post/insert", method = {RequestMethod.POST})
	private String adminPostInsert(Model model, BoardVO boardVO) {
		
		boardService.insertBoard(boardVO);
		model.addAttribute("msg","글을 등록 했습니다.");
		model.addAttribute("url","/post");
		
		return "action";
	}
	
	@RequestMapping(value = "/admin/post/update", method = {RequestMethod.POST})
	private String adminPostUpdate(Model model, BoardVO boardVO) {
		
		boardService.updateBoard(boardVO);
		model.addAttribute("msg","글을 수정 했습니다.");
		model.addAttribute("url","/post");
		
		return "action";
	}
	
	@RequestMapping(value = "/admin/post/delete", method = {RequestMethod.POST})
	private String adminPostDelte(HttpServletRequest request, HttpServletResponse response, Model model, BoardVO boardVO) {
		String regNo = request.getParameter("reg_no");
		
		try {
			CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String userNo = customUserDetails.getReg_no();
			
			if(regNo != null && !regNo.equals("")) {
				boardVO.setReg_no(regNo);
				BoardVO board = boardService.selectBoardInfo(boardVO);
				if(board.getUser_no().equals(userNo)) {
					boardService.deleteBoard(boardVO);
					model.addAttribute("msg","글을 삭제 했습니다.");
					model.addAttribute("url","/post");
				}else {
					return "redirect:/post";
				}
			}else {
				return "redirect:/post";
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "action";
	}
	
	@RequestMapping("/admin/test")
	private String test2(Model model) {
		try {
			List<BoardVO> boardList = boardService.selectBoardList();
			model.addAttribute("boardList",boardList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index";
	}
}
