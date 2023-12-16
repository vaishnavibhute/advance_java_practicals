package com.jspiders.jpql.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.jpql.dto.TrainerDTO;

public class TrainerDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpql;
	
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("jpql");
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
			
//			TrainerDTO trainer1=new TrainerDTO();
//			trainer1.setName("abc");
//			trainer1.setSubject("Core Java");
//			trainer1.setEmail("abc@gmail.com");
//			manager.persist(trainer1);
//			
//			TrainerDTO trainer2=new TrainerDTO();
//			trainer2.setName("pqr");
//			trainer2.setSubject("SQL");
//			trainer2.setEmail("pqr@gmail.com");
//			manager.persist(trainer2);
//			
//			TrainerDTO trainer3=new TrainerDTO();
//			trainer3.setName("xyz");
//			trainer3.setSubject("Advance Java");
//			trainer3.setEmail("xyz@gmail.com");
//			manager.persist(trainer3);
			
			jpql="from TrainerDTO";
			query=manager.createQuery(jpql);
			
			List<TrainerDTO> trainers=query.getResultList();
			
			for(TrainerDTO trainer:trainers) {
				System.out.println(trainer);
			}
			
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
}
