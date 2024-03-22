package com.example.boot13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.boot13.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired 
	private MemberService service;
	
	@GetMapping("/member/list")
	public String list(Model model) {
		service.getList(model);
		return "member/list";
	}
}











