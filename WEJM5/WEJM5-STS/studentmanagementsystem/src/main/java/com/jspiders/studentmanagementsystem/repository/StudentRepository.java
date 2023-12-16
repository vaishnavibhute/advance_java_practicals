package com.jspiders.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.studentmanagementsystem.pojo.StudentPojo;

public interface StudentRepository extends JpaRepository<StudentPojo, Integer>{

	StudentPojo findByName(String name);
	StudentPojo findByAddress(String address);
}
