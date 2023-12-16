package com.jspiders.hibernatemanytomanybidirectional.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatemanytomanybidirectional.dto.StudDTO;
import com.jspiders.hibernatemanytomanybidirectional.dto.SubDTO;

public class StudSubDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("ManyToMany");
		manager=factory.createEntityManager();
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
			
			SubDTO subj1=new SubDTO();
			subj1.setId(1);
			subj1.setName("Core Java");
			subj1.setDuration(3);
			manager.persist(subj1);
			
			SubDTO subj2=new SubDTO();
			subj2.setId(2);
			subj2.setName("Advance Java");
			subj2.setDuration(3);
			manager.persist(subj2);
			
			List<SubDTO> subjects=Arrays.asList(subj1,subj2);
			
			StudDTO stud1= new StudDTO();
			stud1.setId(1);
			stud1.setName("Amar");
			stud1.setEmail("amar@gmail.com");
			stud1.setAddress("Pune");
			stud1.setSubj(subjects);
			manager.persist(stud1);
			
			StudDTO stud2= new StudDTO();
			stud2.setId(2);
			stud2.setName("Akbar");
			stud2.setEmail("akbar@gmail.com");
			stud2.setAddress("Mumbai");
			stud2.setSubj(subjects);
			manager.persist(stud2);
			
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
}
