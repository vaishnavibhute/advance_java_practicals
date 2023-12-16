package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.bean.CompanyBean;
import com.jspiders.springcorexml.bean.EmployeeBean;

public class CompanyAadharMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("CompanyEmployeeConfig.xml");
		
		//CompanyBean company1=(CompanyBean)context.getBean("company1");
		CompanyBean company2=(CompanyBean)context.getBean("company2");
		
		//EmployeeBean employee1=(EmployeeBean)context.getBean("employee1");
		//EmployeeBean employee2=(EmployeeBean)context.getBean("employee2");
		
		System.out.println(company2);
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
