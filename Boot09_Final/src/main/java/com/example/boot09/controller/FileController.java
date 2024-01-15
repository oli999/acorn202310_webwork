package com.example.boot09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.boot09.dto.FileDto;
import com.example.boot09.service.FileService;

@Controller
public class FileController {
	@Autowired
	private FileService service;
	
	@GetMapping("/file/list")
	public String list(Model model, FileDto dto) {
		service.getList(model, dto);
		return "file/list";
	}
}




























