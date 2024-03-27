package com.example.boot13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}



















