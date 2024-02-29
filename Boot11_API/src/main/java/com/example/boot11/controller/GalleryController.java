package com.example.boot11.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot11.dto.GalleryDto;
import com.example.boot11.service.GalleryService;

@RestController
public class GalleryController {
	
	@Autowired GalleryService service;
	
	//겔러리 사진 추가 요청 처리 
	@PostMapping("/gallery")
	public Map<String, Object> insert(GalleryDto dto){
		//업로드된 갤러리 정보를 서비스를 이용해서 저장 
		service.addToGallery(dto);
		
		return Map.of("isSuccess", true);
	}
	//갤러리 목록 요청 처리 
	@GetMapping("/gallery")
	public List<GalleryDto> getList(@RequestParam int pageNum){
		
		List<GalleryDto> list=service.selectPage(pageNum);
		
		return list;
	}
}












