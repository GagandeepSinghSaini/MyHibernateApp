package com.frys.mapping.OneToMany.unidirectional;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		conf.addAnnotatedClass(Cart.class);
		conf.addAnnotatedClass(Item.class);
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(conf.getProperties());
		ServiceRegistry registry = builder.build();
		
		Item it1 = new Item();
		Item it2 = new Item();
		
		it1.setQty(44);
		it2.setQty(66);
		
		Cart c1 = new Cart();
		c1.setCost(600);
		it1.setCart(c1);
		it2.setCart(c1);
		
		SessionFactory factory = conf.buildSessionFactory(registry);
		Session session = null;
		
		try {
			session = factory.openSession();
			session.beginTransaction();
			//session.save(c1);
			session.save(it1);
			session.save(it2);
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Excetion: "+e);
		}finally {
			if(session != null && session.isConnected()) {
				session.close();
			}
			if(!factory.isClosed()){
				System.out.println("Closing SessionFactory");
				factory.close();
			}
		}
		
		
	}
	
}
