package com.example.boot13.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.boot13.dto.MemberDto;
import com.example.boot13.entity.Member;
import com.example.boot13.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired 
	private MemberRepository repo;
	
	@Override
	public void getList(Model model) {
		// Entity 목록 
		/*
		List<Member> entityList=repo.findAll();
		
		List<MemberDto> list=new ArrayList<>();
		for(Member tmp:entityList) {
			MemberDto dto=new MemberDto();
			dto.setNum(tmp.getNum());
			dto.setName(tmp.getName());
			dto.setAddr(tmp.getAddr());
			list.add(dto);
		}
		*/
		
		// List<Member> 를 Stream 으로 변경해서 map() 메소드를 사용하고 다시 List<MemberDto> 로 변경하기 
		List<MemberDto> list=repo.findAllByOrderByNumDesc().stream().map(item -> {
			return MemberDto.toDto(item);
		}).toList();
		
		//회원목록을 모델에 담는다.
		model.addAttribute("list", list);
	}

}









