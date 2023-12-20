package com.example.boot03.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.boot03.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TestController {
	
	@GetMapping("/inc")
	public String inc() {
		return "sub/inc";
	}
	
	//가상의 로그인 
	@GetMapping("/user/login")
	public String login(HttpSession session) {
		
		session.setAttribute("id", "kimgura");
		return "sub/login";
	}
	//가상의 로그 아웃
	@GetMapping("/user/logout")
	public String logout(HttpSession session) {
		//세션 초기화 
		session.invalidate();
		//최상위 경로로 리다일렉트 이동 
		return "redirect:/";
	}
	
	
	@GetMapping("/members")
	public String members(HttpServletRequest request) {
		MemberDto dto1=new MemberDto(1, "김구라", "노량진");
		MemberDto dto2=new MemberDto(2, "해골", "행신동");
		MemberDto dto3=new MemberDto(3, "원숭이", "상도동");
		
		List<MemberDto> list=new ArrayList<>();
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		//Model 객체에 담으면 자동으로 HttpServletRequest 객체에 이런 식으로 담기는 것이다.
		//Spring 프레임워크가 담아준다 
		request.setAttribute("list", list);
		
		return "sub/members";
	}
	
	@GetMapping("/notice")
	public String notice(Model model) {
		//DB 에서 읽어온 공지사항이라고 가정
		List<String> list=new ArrayList<>();
		list.add("날씨가 추워요!");
		list.add("곧 크리스 마스 입니다");
		list.add("어쩌구 저쩌구...");
		
		model.addAttribute("list", list);
	
		
		return "sub/notice";
		
	}
	
	@GetMapping("/member")
	public String member(Model model) {
		//응답에 필요한 데이터
		MemberDto dto=new MemberDto(1, "김구라", "노량진");
		//응답에 필요한 데이터를 Model 객체에 담는다.
		model.addAttribute("dto", dto);
		
		// /templates/sub/member.html 
		return "sub/member";
	}
	
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





