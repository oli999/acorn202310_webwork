package com.example.boot13.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.boot13.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{
	
	//사원 번호에 대해서 오름 차순 정렬된 목록을 반환하는 메소드 만들기
	public List<Emp> findAllByOrderByEmpnoAsc();
	
	//검색 키워드를 반영하는 메소드
	// ename 에 keyword 가 포함된 
	public Page<Emp> findByEnameContaining(String keyword, Pageable pageable);
	// ename 에 keyword 가 포함되거나 Or job 에 keyword2 가 포함된 
	public Page<Emp> findByEnameContainingOrJobContaining(String keyword, String keyword2, Pageable pageable);
}













