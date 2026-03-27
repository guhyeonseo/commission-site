package com.boot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.UserEntity;
import com.boot.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
	
	private final UserService userService;

    // 회원가입
    @PostMapping("/register")
    public String register(@RequestParam("nickname") String nickname,
    		     	 	   @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email) {

        userService.register(username, nickname, password, email);
        return "회원가입 성공";
    }

    // 로그인
    @PostMapping("/login")
    public UserEntity login(@RequestParam String username,
                            @RequestParam String password) {

        return userService.login(username, password);
    }
}
