package com.example.boot09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	//회원가입폼 요청처리
	@GetMapping("/user/signup_form")
	public String signupForm() {
		
		return "user/signup_form";
	}
}
