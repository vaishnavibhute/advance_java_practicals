package com.jspiders.studentmanagementsystem.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.studentmanagementsystem.pojo.StudentPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse {

	public StudentResponse(String string, StudentPojo student, Object object) {
		// TODO Auto-generated constructor stub
	}
	private String msg;
	private StudentPojo data;
	private List<StudentPojo> list;
}
