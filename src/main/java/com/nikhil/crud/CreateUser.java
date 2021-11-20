package com.nikhil.crud;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.nikhil.dto.User;

public class CreateUser {
public static void main(String[] args) {
	StandardServiceRegistry registry;
	SessionFactory factory;
	Session session;
	
	
	User user = new User("Nikhil L", "Random Address", new BigDecimal("900000000") , new Date());
	

	registry = new StandardServiceRegistryBuilder().configure().build();
	MetadataSources sources = new MetadataSources(registry);
	Metadata  data = sources.getMetadataBuilder().build();
	factory = data.getSessionFactoryBuilder().build();

	session = factory.openSession();
	Transaction t = session.beginTransaction();
	session.save(user);
	t.commit();
	
	System.out.println("record added successfully .");
}
	


}
