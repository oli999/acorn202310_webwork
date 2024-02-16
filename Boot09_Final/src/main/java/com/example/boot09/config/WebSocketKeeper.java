package com.example.boot09.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Component
public class WebSocketKeeper {
	Map<String, WebSocketSession> sessionList=new HashMap<String, WebSocketSession>();
	
	public void add(String id, WebSocketSession session) {
		sessionList.put(id, session);
	}
	public WebSocketSession find(String id) {
		return sessionList.get(id);
	}
	public void remove(String id) {
		sessionList.remove(id);
	}
}









