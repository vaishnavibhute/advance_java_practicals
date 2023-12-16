package com.jspiders.springcorexml.bean;

import java.util.List;

import lombok.Data;

@Data
public class CompanyBean {
		int id;
		String name;
		String location;
		
	//	List<EmployeeBean> employees;//for one to many
		
		//for many to many--->
		List<EmployeeBean> employees;
}
