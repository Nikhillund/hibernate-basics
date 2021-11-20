package com.nikhil.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.nikhil.dto.User;



public class ReadUser {
public static void main(String[] args) {
	StandardServiceRegistry registry;
	SessionFactory factory;
	Session session;
	
	registry = new StandardServiceRegistryBuilder().configure().build();
	MetadataSources sources = new MetadataSources(registry);
	Metadata  data = sources.getMetadataBuilder().build();
	factory = data.getSessionFactoryBuilder().build();

	session = factory.openSession();
	Transaction t = session.beginTransaction();
	
	javax.persistence.Query q = session.createQuery("FROM com.nikhil.dto.User");
	List<User> ls =q.getResultList();
	for(User u :ls) {
		System.out.println(u.getUid()+" "+u.getName()+" "+u.getAddress()+" "+u.getPhone()+" "+u.getDob());
	}
}
}
