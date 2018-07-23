package com.frys.mapping.OneToMany.bidirectional;

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
		
		SessionFactory factory = conf.buildSessionFactory(registry);
		
		Item it1 = new Item();
		Item it2 = new Item();
		
		it1.setQty(2);
		it2.setQty(3);
		Set<Item> itemSet = new HashSet<Item>(); 
		itemSet.add(it1);
		itemSet.add(it2);
		
		Cart c1 = new Cart();
		c1.setCartItems(itemSet);
		c1.setCost(200);
		it1.setCart(c1);
		it2.setCart(c1);
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(c1);
			session.save(it1);
			session.save(it2);
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception: "+e);
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
