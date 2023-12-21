package com.example.boot03;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.boot03.controller.HomeController;

@SpringBootTest
class Boot03ThymeleafApplicationTests {
	
	@Autowired
	HomeController homeController;
	
	@DisplayName("home 엔트 포인트 테스트")
	@Test
	void homeTest() {
		assert homeController != null;
	}
	
	@Test
	void contextLoads() {
	}

}
