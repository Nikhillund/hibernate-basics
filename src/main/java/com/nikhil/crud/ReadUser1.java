package com.nikhil.crud;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

import com.nikhil.dto.User;

public class ReadUser1 {
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
	
	CriteriaBuilder cBuilder= session.getCriteriaBuilder();
	CriteriaQuery<User> cQuery=cBuilder.createQuery(User.class);
	Root<User> root = cQuery.from(User.class);
	cQuery.select(root).where(cBuilder.equal(root.get("name"), "Nikhil L"));
	
	Query q =session.createQuery(cQuery);
	List<User> ls =q.getResultList();
	for(User u :ls) {
		System.out.println(u.getUid()+" "+u.getName()+" "+u.getAddress()+" "+u.getPhone()+" "+u.getDob());
	}
	
}
}
