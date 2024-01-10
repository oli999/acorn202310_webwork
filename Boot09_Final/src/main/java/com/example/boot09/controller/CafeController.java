package com.example.boot09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.boot09.dto.CafeDto;
import com.example.boot09.service.CafeService;



@Controller // bean 도 되고 controller 역활도 하고 
public class CafeController {
	
	@Autowired 
	private CafeService service;
	
	@PostMapping("/cafe/insert")
	public String insert(CafeDto dto) {
		//서비스를 이용해서 새글을 저장한다
		service.saveContent(dto);
		return "cafe/insert";
	}
	
	@GetMapping("/cafe/insertform")
	public String insertForm() {
		return "cafe/insertform";
	}
	
	@GetMapping("/cafe/list")
	public String list(Model model, @RequestParam(defaultValue = "1") int pageNum) {
		
		service.getList(model, pageNum);
		
		return "cafe/list";
	}
}





