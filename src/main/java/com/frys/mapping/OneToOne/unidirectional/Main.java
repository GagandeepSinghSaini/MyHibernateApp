package com.frys.mapping.OneToOne.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder service = new StandardServiceRegistryBuilder();
		service.applySettings(conf.getProperties());
		ServiceRegistry registry = service.build();
		
		Student st1 = new Student();
		st1.setStudentName("Gagan");
		
		Student st2 = new Student();
		st2.setStudentName("Preetissss");
		
		Address ad1 = new Address();
		Address ad2 =  new Address();
		
		ad1.setCity("Delhi");
		ad1.setState("Delhi");
		
		ad2.setCity("Chandigarh");
		ad2.setState("Chandigarh");
		
		st1.setAddress(ad2);
		st2.setAddress(ad1);
		
		SessionFactory factory = null;
		Session session = null;	
		try {
			factory = conf.buildSessionFactory(registry);
			session = factory.openSession();
			session.beginTransaction();
			session.save(st1);
			session.save(st2);
			session.getTransaction().commit();
			
		}catch(Exception e) {
			System.out.println("Exception :"+e);
		}finally {
			System.out.println("Done Now finally");
			session.close();
			if(!factory.isClosed()){
				System.out.println("Closing SessionFactory");
				factory.close();
			}
		}
		
		
		System.out.println("Donemy sir");
		
	}
	
}
