package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.bean.CompanyBean;
import com.jspiders.springcorexml.bean.EmployeeBean;

public class CompanyMain {
	public static void main(String[] args) {
		
		//for one to many--->
		
		ApplicationContext context=new ClassPathXmlApplicationContext("CompanyConfig.xml");
		CompanyBean company1=context.getBean(CompanyBean.class);
		System.out.println(company1);
		
		((ClassPathXmlApplicationContext)context).close();
		
		//for many to one--->
		//ApplicationContext context=new ClassPathXmlApplicationContext("EmployeeConfig.xml");
		//EmployeeBean employee1=(EmployeeBean)context.getBean("employee1");
		//EmployeeBean employee2=(EmployeeBean)context.getBean("employee2");
		//System.out.println(employee1);
		//System.out.println(employee2);
		//((ClassPathXmlApplicationContext)context).close();
	}
}
