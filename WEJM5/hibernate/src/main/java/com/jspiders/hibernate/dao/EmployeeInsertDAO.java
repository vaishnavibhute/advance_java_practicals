package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.EmployeeDTO;

public class EmployeeInsertDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("hibernate");
		manager= factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	
	private static void closeConnection() {
		if(factory!=null) {
			factory.close();
		}
		if(manager!=null) {
			manager.close();
		}
		if(transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		try {
			openConnection();
			transaction.begin();
			
			EmployeeDTO employee1=new EmployeeDTO();
			employee1.setId(1);
			employee1.setName("Sara");
			employee1.setDesignation("Manager");
			employee1.setSalary(15000);
			
			EmployeeDTO employee2=new EmployeeDTO();
			employee2.setId(2);
			employee2.setName("xyz");
			employee2.setDesignation("Cricketer");
			employee2.setSalary(45000);
			
			manager.persist(employee1);
			manager.persist(employee2);
			
			transaction.commit();
			
		}finally {
			closeConnection();
		}
	}
}
