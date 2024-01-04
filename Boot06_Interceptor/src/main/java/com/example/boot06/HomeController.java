package com.example.boot06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model m) {
		//응답에 필요한 데이터는 
		String fortuneToday="동쪽으로 가면 귀인을 만나요";
		//Model 객체에 담아주면된다.
		m.addAttribute("fortuneToday", fortuneToday);
		
		// templates/home.html 로 forward 이동해서 응답 ( 응답에 필요한 데이터는 request 영역에 담겨 있다)
		// templates/home.html 을 타임리프 뷰 엔진이 해석해서 응답 
		return "home";
	}
}









