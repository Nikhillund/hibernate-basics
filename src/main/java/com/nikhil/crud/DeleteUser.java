package com.nikhil.crud;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.nikhil.dto.User;

public class DeleteUser {
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
	User user = new User("Nikhil S L", "Random Address", new BigDecimal("980000000") , new Date());
	user.setUid(1);
	session.delete(user);
	t.commit();
	session.close();
	System.out.println("record deleted..");
}
}
