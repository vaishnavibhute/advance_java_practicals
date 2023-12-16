package com.jspiders.springcoreannotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.jspiders.springcoreannotation.bean.AadharBean;
import com.jspiders.springcoreannotation.bean.PersonBean;

@ComponentScan(basePackages = "com.jspiders.springcoreannotation")
public class PersonConfig {
		
	@Bean("person1")
	public PersonBean getPerson() {
		return new PersonBean();
		
	}
		
	}

