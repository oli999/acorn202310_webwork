package com.example.boot13.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.boot13.dto.DeptDto;
import com.example.boot13.dto.EmpListDto;
import com.example.boot13.entity.Dept;
import com.example.boot13.entity.Emp;
import com.example.boot13.repository.DeptRepository;
import com.example.boot13.repository.EmpRepository;

@Controller
public class EmployController {
	
	@Autowired
	private EmpRepository repo;
	@Autowired 
	private DeptRepository deptRepo;
	
	@GetMapping("/employ/dept")
	public String deptDetail(int deptno, Model model) {
		//deptno 에 해당하는 부서 정보를 얻어와서 
		Dept d=deptRepo.findById(deptno).get();
		//DeptDto 로 변경한다음 
		DeptDto dto=DeptDto.toDto(d);
		//view page 에서 사용할수 있도록 Model 객체에 담아준다
		model.addAttribute("dto", dto);
		return "employ/dept";
	}
	
	
	@GetMapping("/employ/list")
	public String list(Model model) {
		//모든 사원의 목록을 얻어온다.
		//List<Emp> list=repo.findAll();
		List<Emp> list=repo.findAllByOrderByEmpnoAsc();
		// .stream() 을 이용해서 Entity 목록을 Dto 목록으로 변경한다.
		List<EmpListDto> list2=list.stream().map(EmpListDto::toDto).toList(); 
		// view page 에 전달 할수 있도록 Model 객체에 담는다.
		model.addAttribute("list", list2);
		return "employ/list";
	}
	
	@ResponseBody
	@GetMapping("/employ/list2")
	public List<EmpListDto> list2(int pageNum) {
		//한페이지에 몇개씩 표시할것인지
		final int PAGE_ROW_COUNT=5;
		//정렬을 먼저 결정을 해야 한다.
		Sort sort=Sort.by(Sort.Direction.ASC, "empno"); // 사원번호에 대해서 오름차순 정렬
		/*
		 *  .of(페이지 인덱스, 한페이지에 나타낼 갯수 , 정렬객체 )
		 *  
		 *  PageRequest 객체가 리턴되는데 PageRequest 는 Pageable 인터페이스를 구현한 객체 이다.
		 */
		Pageable pagable=PageRequest.of(pageNum-1, PAGE_ROW_COUNT, sort);
		// Pageable 객체를 이용해서 해당 페이지에 맞는 정보를 얻어낸다.
		Page<Emp> page=repo.findAll(pagable);
		//Page<Emp> 를 List<EmpListDto> 로 변경하기 
		List<EmpListDto> list= page.stream().map(EmpListDto::toDto).toList();
		return list;
	}
	
	@GetMapping("/employ/list3")
	public String list(Model model, @RequestParam(defaultValue = "1") int pageNum) {
		//한페이지에 나타낼 row 의 갯수
		final int PAGE_ROW_COUNT=5;
		//하단 페이지 표시 갯수 
		final int PAGE_DISPLAY_COUNT=5;
		
		//empno 에 대해서 오름차순 정렬하겠다는 정보를 담고 있는 Sort 객체 만들기
		Sort sort=Sort.by(Sort.Direction.ASC, "empno"); 
		//원하는 페이지정보를 담고 있는 Pageable 객체를 얻어내서 
		Pageable pagable=PageRequest.of(pageNum-1, PAGE_ROW_COUNT, sort);
		//JpaRepository 객체에 전달해서 원하는 페이지 정보를 얻어낸다 
		Page<Emp> page=repo.findAll(pagable);
		// Emp 목록을 EmpListDto 목록으로 변환 
		List<EmpListDto> list= page.stream().map(EmpListDto::toDto).toList();
		
		//하단 시작 페이지 번호 
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//하단 끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		//전체 페이지의 갯수 구하기
		int totalPageCount=page.getTotalPages();
		//끝 페이지 번호가 이미 전체 페이지 갯수보다 크게 계산되었다면 잘못된 값이다.
		if(endPageNum > totalPageCount){
			endPageNum=totalPageCount; //보정해 준다. 
		}
		
		//pageNum 에 해당하는 사원 목록을 Model 에 담는다 
		model.addAttribute("list", list);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("pageNum", pageNum);
		
		return "employ/list3";
	}
}
























