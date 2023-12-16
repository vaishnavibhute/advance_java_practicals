package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentDTO;

public class StudentDAO {
		public static void main(String[] args) {
			
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			
			entityTransaction.begin();
			
			StudentDTO student1=new StudentDTO();
			student1.setSid(1);
			student1.setSname("vaishu");
			student1.setSemail("vaishu93@gamil.com");
			student1.setSmarks(85);
			student1.setSadd("pune");
			
			entityManager.persist(student1);
			entityTransaction.commit();
			
			if(entityManagerFactory!=null) {
				entityManagerFactory.close();
			}
			if(entityManager!=null) {
				entityManager.close();
			}
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
}
			