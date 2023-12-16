package com.jspiders.hibernateonetoone.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetoone.dto.AadharDTO;
import com.jspiders.hibernateonetoone.dto.PersonDTO;

public class PersonAadharDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("OneToOne");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	
	private static void closeConnection() {
		if(factory!=null){
			factory.close();
		}
		if(manager!=null){
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
			AadharDTO aadhar1=new AadharDTO();
			aadhar1.setId(1);
			aadhar1.setAadhar_no(123456870);
			aadhar1.setDoj("01-05-2015");
			
			manager.persist(aadhar1);
			
			PersonDTO person1=new PersonDTO();
			person1.setId(1);
			person1.setName("Avinash");
			person1.setContact(234567587);
			person1.setDOB("20-08-2000");
			person1.setAddress("pune");
			person1.setAadhar(aadhar1);
			
			manager.persist(person1);
			transaction.commit();
		}finally {
			closeConnection();
		}
	}
}
