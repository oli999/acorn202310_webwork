package com.example.boot09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.boot09.dto.UserDto;
import com.example.boot09.repository.UserDao;
import com.example.boot09.service.UserService;

@Controller
public class UserController {
	// util 역활을 하는 서비스 객체를 인터페이스 type 으로 DI 받아서 사용한다 
	@Autowired
	private UserService service;
	
	//회원 가입 요청처리
	@PostMapping("/user/signup")
	public String signup(UserDto dto) {
		//서비스(util) 객체를 이용해서 가입정보를 등록한다.
		service.addUser(dto);
		
		return "user/signup";
	}
	
	//회원가입폼 요청처리
	@GetMapping("/user/signup_form")
	public String signupForm() {
		
		return "user/signup_form";
	}
}









