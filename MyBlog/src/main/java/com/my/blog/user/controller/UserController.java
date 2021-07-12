package com.my.blog.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
	
	@RequestMapping("/admin")
	private String post(Model model) {
		return "admin/index";
	}
}
