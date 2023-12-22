package com.example.boot04.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.boot04.member.dao.MemberDao;
import com.example.boot04.member.dto.MemberDto;

@Controller
public class MemberController {
	//의존객체 주입 받기 (Dependency Injection)
	@Autowired MemberDao dao;
	
	@GetMapping("/member/list")
	public String list(Model model) {
		//출력해줄 회원목록을 얻어와서 모델에 담고 
		List<MemberDto> list=dao.getList();
		//Model 객체에 "list" 라는 키값으로 회원 목록을 담는다. 
		model.addAttribute("list", list);
		// templates/member/list.html  Thymeleaf 뷰엔진에서 회원목록 출력하기 
		return "member/list";
	}
}














