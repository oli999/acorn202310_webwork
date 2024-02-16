package com.example.boot09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import com.example.boot09.config.WebSocketKeeper;

@Service
public class BuyService {
	
	@Autowired
	WebSocketKeeper keeper;
	
	public void addCart() {
		//무언가 처리를 함
		WebSocketSession socketSession=keeper.find("aaa");
		
	}
}
