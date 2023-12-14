package com.example.boot02.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  클라이언트의 요청을 처리한 컨트롤러를 정의하고 bean 으로 만들기
 */

@Controller // 1. bean 으로 만들기 + 2. 요청을 처리하는 컨트롤러 역활하기 
public class HelloController {
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		
		return "Nice to meet you!";
	}
	
	@ResponseBody
	@GetMapping("/fortune")
	public String fortune() {
		
		return "동쪽으로 가면 귀인을 만나요";
	}
	
	@ResponseBody
	@GetMapping("/member")
	public Map<String, Object> member(){
		Map<String, Object> map=new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		return map;
	}
	
	@ResponseBody
	@GetMapping("/friends")
	public List<String> friends(){
		List<String> names=new ArrayList<String>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		return names;
	}
	@ResponseBody
	@GetMapping("/members")
	public List<Map<String, Object>> members(){
		Map<String, Object> map1=new HashMap<>();
		map1.put("num", 1);
		map1.put("name", "김구라");
		map1.put("isMan", true);
		Map<String, Object> map2=new HashMap<>();
		map2.put("num", 2);
		map2.put("name", "해골");
		map2.put("isMan", false);
		Map<String, Object> map3=new HashMap<>();
		map3.put("num", 3);
		map3.put("name", "원숭이");
		map3.put("isMan", true);
		
		List<Map<String, Object>> members=new ArrayList<>();
		members.add(map1);
		members.add(map2);
		members.add(map3);
		
		return members;
		
	}
}










