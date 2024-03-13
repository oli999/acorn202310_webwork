package com.example.boot11.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot11.dto.CafeDto;
import com.example.boot11.service.CafeService;

@RestController
public class CafeController {
	
	@Autowired 
	private CafeService service;
	
	@PostMapping("/cafes")
	public Map<String, Object> insert(@RequestBody CafeDto dto){
		//서비스 객체를 이용해서 DB 에 저장하기 
		service.saveContent(dto);
		
		return Map.of("isSuccess", true);
	}
	
	@GetMapping("/cafes")
	public Map<String, Object> list(CafeDto dto){
		
		return service.getList(dto);
	}
	
	@GetMapping("/cafes/{num}") 
	public CafeDto detail(@PathVariable("num") int num, CafeDto dto){
		//CafeDto 에 경로 변수 num 값을 담는다 ( 검색조건과 키워드도 담겨 있을수 있다)
		dto.setNum(num);
		
		return service.getDetail(dto);
	}
		
}












