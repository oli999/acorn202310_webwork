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
		List<MemberDto> list=
				repo.findAllByOrderByNumDesc().stream().map(item -> MemberDto.toDto(item)).toList();
		/*
		 *    - 메소드 참조 표현식
		 *    
		 *    클래스명 :: 메소드명 
		 */
		//List<MemberDto> list2=
		//		repo.findAllByOrderByNumDesc().stream().map(MemberDto::toDto).toList();
		//회원목록을 모델에 담는다.
		model.addAttribute("list", list);
	}

	@Override
	public void insert(MemberDto dto) {
		//Dto 를 Entity 로 변경해서 JpaRepository 객체를 이용해서 저장한다
		repo.save(Member.toEntity(dto));
	}

	@Override
	public void delete(Long num) {
		repo.deleteById(num);
	}

	@Override
	public void getData(Long num, Model model) {
		//회원의 번호를 이용해서 Member Entity 객체를 얻어온다.
		Member m=repo.findById(num).get();
		//Model 에 담는다
		model.addAttribute("dto", MemberDto.toDto(m));
	}

	@Override
	public void update(MemberDto dto) {
		// save() 메소드는 insert 와 update 겸용이다 
		repo.save(Member.toEntity(dto));
	}

}









