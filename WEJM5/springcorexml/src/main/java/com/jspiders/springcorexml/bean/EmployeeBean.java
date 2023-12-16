package com.jspiders.springcorexml.bean;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeBean {
		
	int id;
	String name;
	double salary;
	//for many to one--->
	//CompanyBean company;
	
	//for many to many--->
	List<CompanyBean> companies;
}
