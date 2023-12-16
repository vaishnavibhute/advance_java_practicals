package com.jspiders.springcoreannotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component

public class PersonBean {
	
	@Value("1")
	int id;
	@Value("Manish")
	String name;
	@Value("manish@gmail.com")
	String email;
	
	@Autowired
	AadharBean aadhar;
}
