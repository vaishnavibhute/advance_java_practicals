package com.jspiders.studentmgtsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.studentmgtsystem.pojo.StudentPojo;

public interface StudentRepository extends JpaRepository<StudentPojo, Integer>{
	StudentPojo findByName(String name);
	StudentPojo findByAddress(String address);
}
