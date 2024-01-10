package com.example.boot09.service;

import org.springframework.ui.Model;

import com.example.boot09.dto.CafeDto;

public interface CafeService {
	public void getList(Model model, int pageNum);
	public void saveContent(CafeDto dto);
	public void getDetail(Model model, int num);
	public void deleteContent(int num);
}
