package com.example.boot09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

	@GetMapping("/chat/home")
	public String home() {
		
		return "chat/home";
	}
}
