package com.jspiders.springcoreannotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcoreannotation.bean.PersonBean;
import com.jspiders.springcoreannotation.config.PersonConfig;

public class PersonMain {
		public static void main(String[] args) {
			
			ApplicationContext context=new AnnotationConfigApplicationContext(PersonConfig.class);
			
			PersonBean person1=(PersonBean)context.getBean("person1");
			
			System.out.println(person1);
			
			((AnnotationConfigApplicationContext)context).close();
		}
}
