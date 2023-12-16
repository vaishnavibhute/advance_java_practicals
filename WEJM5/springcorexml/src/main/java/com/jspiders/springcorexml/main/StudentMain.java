package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.bean.StudentBean;

public class StudentMain {
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("StudentConfig.xml");
		
		//for only one bean class
		StudentBean student1=context.getBean(StudentBean.class);
		System.out.println(student1);
		
	   //for multiple bean class(downcasting)
		//StudentBean student1=(StudentBean)context.getBean("Student1");
	    //StudentBean student2=(StudentBean)context.getBean("Student2");
		
	    //System.out.println(student1);
	    //System.out.println(student2);
		
		//for allargsconstructor & noargsconstructor
		//StudentBean student3=(StudentBean)context.getBean("Student3");
		//System.out.println(student3);
		
	((ClassPathXmlApplicationContext)context).close();
	}
}
