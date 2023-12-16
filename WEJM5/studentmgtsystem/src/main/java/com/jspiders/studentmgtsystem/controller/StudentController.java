package com.jspiders.studentmgtsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jspiders.studentmgtsystem.pojo.StudentPojo;
import com.jspiders.studentmgtsystem.response.StudentResponse;
import com.jspiders.studentmgtsystem.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping("/add")
	public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentPojo pojo) {
		StudentPojo student = service.addStudent(pojo);
		if (student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student data inserted.", student, null),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not inserted.", null, null),
				HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("/search/{id}")
	public ResponseEntity<StudentResponse> searchStudent(@PathVariable int id) {
		StudentPojo student = service.searchStudent(id);
		if (student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student data found. ", student, null),
					HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not found. ", null, null),
				HttpStatus.NOT_FOUND);
	}

	@GetMapping("/searchAll")
	public ResponseEntity<StudentResponse> searchAllStudents() {
		List<StudentPojo> students = service.searchAllStudents();

		if (students != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student details found. ", null, students),
					HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("No student data exists. ", null, null),
				HttpStatus.NOT_FOUND);
	}

	@GetMapping("/searchByName/{name}")
	public ResponseEntity<StudentResponse> searchStudentByName(@PathVariable String name) {
		StudentPojo student = service.searchStudent(name);
		if (student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student data found. ", student, null),
					HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not found. ", null, null),
				HttpStatus.NOT_FOUND);
	}

	@GetMapping("/searchByAddress/{address}")
	public ResponseEntity<StudentResponse> searchStudentByAddress(@PathVariable String address) {
		StudentPojo student = service.searchStudentByAddress(address);
		if (student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student data found. ", student, null),
					HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not found. ", null, null),
				HttpStatus.NOT_FOUND);
	}
}
