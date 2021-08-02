package com.my.blog.user.controller;


import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.blog.security.CustomUserDetails;
import com.my.blog.user.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {
	
	@Resource(name = "UserService")
    private UserService userService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

//    @GetMapping("/user")
//    @PreAuthorize("hasAnyRole('ADMIN')")
//    public ResponseEntity<UserVO> getMyUserInfo() {
//        return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
//    }

    @GetMapping("/user/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<CustomUserDetails> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(userService.selectLoginUser(username));
    }
}