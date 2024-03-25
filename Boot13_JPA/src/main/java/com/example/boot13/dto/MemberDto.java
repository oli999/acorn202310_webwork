package com.example.boot13.dto;

import com.example.boot13.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto {
	private Long num;
	private String name;
	private String addr;
	
	// entity 를 dto 로 변환하는 static 메소드
	public static MemberDto toDto(Member entity) {
		
		return MemberDto.builder()
				.num(entity.getNum())
				.name(entity.getName())
				.addr(entity.getAddr())
				.build();
	}
}




















