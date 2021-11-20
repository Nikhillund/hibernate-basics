package com.nikhil.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.nikhil.dto.User;

public class UpdateUser {
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
		User user= session.get(User.class, 1);
		user.setAddress("Permanent Address");
		user.setName("Nikhil S L");
		t.commit();
		session.close();
		
		System.out.println("record updated successfully .");
	}

}
