package com.jspiders.springcoreannotation.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcoreannotation.bean.StudentBean;

public class StudentConfig {
		@Bean("Student1")
//		public StudentBean getStudent() {
//			StudentBean student = new StudentBean();
//			student.setId(1);
//			student.setName("satish");
//			student.setEmail("satish@gmail.com");
//			return student;
//			
//		}
		
//		for value annotation--->
//		public StudentBean getStudent() {
//			return new StudentBean();
//		}
		
		//for AllargsConstructor annotation--->
		public StudentBean getStudent() {
			return new StudentBean(1,"satish","satish@gmail.com");
		}
}
