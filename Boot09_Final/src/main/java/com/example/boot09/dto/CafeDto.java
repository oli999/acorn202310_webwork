package com.example.boot09.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("cafeDto") // mapper xml 문서에서 CafeDto type 을 별칭을 이용해서 사용할수 있다. 
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CafeDto {
	private int num;
	private String writer;
	private String title;
	private String content;
	private int viewCount;
	private String regdate;
	//페이징 처리를 위한 추가 필드 
	private int startRowNum;
	private int endRowNum;
}
