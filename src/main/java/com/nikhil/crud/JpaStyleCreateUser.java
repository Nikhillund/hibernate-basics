package com.nikhil.crud;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.nikhil.dto.User;

public class JpaStyleCreateUser {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test1");
		 EntityManager em = factory.createEntityManager();
		 
		 User user = new User("Nikhil L", "Random Address", new BigDecimal("900000000") , new Date());
		 em.getTransaction().begin();
		 em.persist(user);
		 em.getTransaction().commit();
		 System.out.println("Record added successfully");
	}

}
