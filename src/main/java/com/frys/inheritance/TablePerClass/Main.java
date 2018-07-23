package com.frys.inheritance.TablePerClass;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

public class Main {

	public static void main(String[] args) {
		
		Animal animal = new Animal();
		animal.setColor("red");
		
		LandAnimal landA = new LandAnimal();
		landA.setName("cow");
		
		SeaAnimal seaA = new SeaAnimal();
		seaA.setName("whale");
		
		Configuration conf = new Configuration();
		conf.addAnnotatedClass(Animal.class);
		conf.addAnnotatedClass(LandAnimal.class);
		conf.addAnnotatedClass(SeaAnimal.class);
		conf.configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder serviceBuilder = new StandardServiceRegistryBuilder();
		ServiceRegistry registry = serviceBuilder.applySettings(conf.getProperties()).build();
		SessionFactory factory = conf.buildSessionFactory(registry);
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(animal);
			session.save(landA);
			session.save(seaA);
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception : "+e);
		}finally {
			//factory.close();
		}
		
		// Lets fetch something
		try {
			session = factory.openSession();
			session.beginTransaction();
			Criteria mycriteria = session.createCriteria(LandAnimal.class).setProjection(Projections.property("name")).add(Restrictions.eq("name","cow"));
						
			List<Animal> result = mycriteria.list();
			session.getTransaction().commit();
			System.out.println("Check: "+result);
			
		}catch(Exception e) {
			System.out.println("Exception while fetching: "+e);
		}finally {
			factory.close();
		}
		
		
	}
}
