package com.example.boot09.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class CustomWebSocketHandler extends TextWebSocketHandler{
	
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	class Member{
		private int num;
		private String name;
		private String addr;
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionEstablished(session);
		System.out.println("웹소켓 연결됨");
		System.out.println(session.getId());
		
	
		
		Member m=new Member(1, "김구라", "노량진");
		//객체에 저장된 내용을 json 문자열로 변환해주는 객체 
		ObjectMapper mapper=new ObjectMapper();
		
		List<Member> list=new ArrayList<CustomWebSocketHandler.Member>();
		list.add(m);
		//객체에 저장된 내용를 json 문자열로 변환
		String json = mapper.writeValueAsString(list);
		TextMessage message=new TextMessage(json);
		
		session.sendMessage(message);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
			
		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
		System.out.println("웹소켓 끈김");
		System.out.println(session.getId());
	}
}









