package com.example.boot13;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.boot13.entity.Member;
import com.example.boot13.repository.MemberRepository;

import jakarta.annotation.PostConstruct;

//스프링 boot 필수 설정 어노테이션
@SpringBootApplication
public class Boot13JpaApplication {
	// JPA 기반 Repository 객체 (Dao 객체) 
	@Autowired 
	private MemberRepository repo;
	
	//이 클래스로 객체가 생성된 이후에 메소드가 자동으로 호출되도록 하는 어노테이션 
	@PostConstruct
	public void initMembers() {
		/*
			Member m1=Member.builder().name("김구라").addr("노량진").build();
			repo.save(m1);
		*/
		Member m1=Member.builder().name("김구라").addr("노량진").build();
		Member m2=Member.builder().name("해골").addr("행신동").build();
		Member m3=Member.builder().name("원숭이").addr("동물원").build();
		
		//Arrays 클래스의 asList() 라는 static 메소드를 이용해서 List 만들기
		List<Member> list=Arrays.asList(m1, m2, m3);
		//JpaRepository 객체의 saveAll() 메소드를 이용해서 회원 목록 저장하기  
		repo.saveAll(list);
	}
	
	// run as spring boot app 를 실행하면 여기부터 시작이 된다.
	public static void main(String[] args) {
		SpringApplication.run(Boot13JpaApplication.class, args);
	}

}











