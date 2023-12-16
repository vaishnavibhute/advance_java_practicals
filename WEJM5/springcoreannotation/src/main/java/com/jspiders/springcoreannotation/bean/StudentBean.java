package com.jspiders.springcoreannotation.bean;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBean {
//		int id;
//		String name;
//		String email;
	
//	using @value annotation---->
//	@Value("1")
//	int  id;
//	@Value("satish")
//	String name;
//	@Value("satish@gmail.com")
//	String email;
	
	//for AllArgsConstructor & NoArgsConstructor
	int id;
	String name;
	String email;
}
