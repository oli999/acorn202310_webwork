package com.example.boot13.service;

import org.springframework.ui.Model;

import com.example.boot13.dto.MemberDto;

public interface MemberService {
	public void getList(Model model);
	public void insert(MemberDto dto);
}
