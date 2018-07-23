package com.frys.mapping.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.addAnnotatedClass(Customer.class);
		conf.addAnnotatedClass(BillingAddress.class);
		conf.configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder serviceBuilder = new StandardServiceRegistryBuilder();
		ServiceRegistry registry = serviceBuilder.applySettings(conf.getProperties()).build();
		SessionFactory factory = conf.buildSessionFactory(registry);
		
		Customer cust1 = new Customer();
		Customer cust2 = new Customer();
		cust1.setCustName("Gagan");
		cust2.setCustName("Preeti");
		
		BillingAddress add1 = new BillingAddress();
		BillingAddress add2 = new BillingAddress();
		
		add1.setCity("chandigarh");
		add1.setState("Punjab");
		add1.setZip("160014");
		
		add2.setCity("San Jose");
		add2.setState("CA");
		add2.setZip("95112");
		
		List<BillingAddress> addList1 = new ArrayList<BillingAddress>();
		addList1.add(add1);
		
		List<BillingAddress> addList2 = new ArrayList<BillingAddress>();
		addList2.add(add2);
		
		cust1.setAddresses(addList1);
		cust2.setAddresses(addList2);
		
		Session session = factory.getCurrentSession();
		session.getTransaction().begin();
		session.save(cust1);
		session.save(cust2);
		session.getTransaction().commit();
		factory.close();
		
		
		
	}
	
}
