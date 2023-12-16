package com.jspiders.studentmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.studentmanagementsystem.pojo.StudentPojo;
import com.jspiders.studentmanagementsystem.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public StudentPojo addStudent(StudentPojo pojo) {
		StudentPojo student = repository.save(pojo);
		return student;
	}

	public StudentPojo searchStudent(int id) {
		StudentPojo student = repository.findById(id).orElse(null);
		return student;
	}

	public List<StudentPojo> searchAllStudents() {
		List<StudentPojo> students = repository.findAll();
		return students;
	}

	public StudentPojo searchStudent(String name) {
		StudentPojo student = repository.findByName(name);
		return student;
	}

	public StudentPojo searchStudentByAddress(String address) {
		StudentPojo student = repository.findByAddress(address);
		return student;
	}
	
	
}
