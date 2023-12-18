package com.example.boot03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	//GET 방식 /shop/buy?id=xxx&amount=xxx 요청을 처리할 컨트롤러 메소드
	@GetMapping("/shop/buy")
	public String buy(String id, int amount) { //매개 변수명을 파라미터명과 동일하게 작성하면 파라미터가 자동추출되어서 전달된다. 
		System.out.println(id+"|"+amount);
		// /templates/shop/buy.html 
		return "shop/buy";
	}
	
	//GET 방식 /sub/play 요청을 처리할 컨트롤러 메소드
	@GetMapping("/sub/play")
	public String play() {
		
		// /templates/sub/play.html 템플릿을 해석해서 응답하기 
		return "sub/play";
	}
}





