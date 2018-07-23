package com.frys.mapping.OneToOne.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.addAnnotatedClass(Address.class);
		conf.addAnnotatedClass(Student.class);
		conf.configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder serviceBuilder = new StandardServiceRegistryBuilder();
		ServiceRegistry registry = serviceBuilder.applySettings(conf.getProperties()).build();
		SessionFactory factory = conf.buildSessionFactory(registry);
		
		Student st1 = new Student();
		Address ad1 = new Address();
		
		st1.setStudentName("Gagandeep Singh Saini");
		ad1.setCity("Chandigarh");
		ad1.setState("Chandigarh");
		
		st1.setAddress(ad1);
		ad1.setStudent(st1);
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(ad1);
			session.save(st1);
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception :" +e);
		}finally {
			if(session != null ) {
				session.close();
			}
			if(!factory.isClosed()){
				System.out.println("Closing SessionFactory");
				factory.close();
			}
		}
		System.out.println("Process ends");
	}
	
}
