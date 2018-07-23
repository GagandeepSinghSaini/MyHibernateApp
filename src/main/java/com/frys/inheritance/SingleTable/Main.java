package com.frys.inheritance.SingleTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Offive Vehicle");

		TwoWheeler twheeler = new TwoWheeler();
		twheeler.setVehicleName("Bike");
		twheeler.setSteeringHandle("BikeSteeringHandle");
		
		FourWheeler fwheeler = new FourWheeler();
		fwheeler.setSteeringWheel("RoundSteeringHandle");
		fwheeler.setVehicleName("Car");
		
		Configuration conf = new Configuration();
		conf.addAnnotatedClass(Vehicle.class);
		conf.addAnnotatedClass(TwoWheeler.class);
		conf.addAnnotatedClass(FourWheeler.class);
		conf.configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder serviceBuilder = new StandardServiceRegistryBuilder();
		ServiceRegistry registry = serviceBuilder.applySettings(conf.getProperties()).build();
		SessionFactory factory = conf.buildSessionFactory(registry);
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(vehicle);
			session.save(twheeler);
			session.save(fwheeler);
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Exception : "+e);
		}finally {
			factory.close();
		}
		
	}
	
}
