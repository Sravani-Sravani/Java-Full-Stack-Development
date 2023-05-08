package com.klef.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientController 
{
	public static void main(String args[])
	{
		/*
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Student s=new Student();
	//Insert
		s.setId(677);
		s.setName("Sravani");
		s.setDepartment("CSE");
		s.setGender("Female");
		s.setAge(20.4);
		Transaction transaction=session.beginTransaction();
		session.save(s);
		System.out.println("Object Saved");
		transaction.commit();
		session.close();
		sf.close();
	*/	
		/*
		//Update
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Object obj=session.load(Student.class,677);
		Student s=(Student)obj;
		s.setName("Kadavakollu Sravani");
		Transaction transaction=session.beginTransaction();
		session.update(s);
		System.out.println("Object updated");
		transaction.commit();
		session.close();
		sf.close();
		*/
		
		/*
		// Delete Operation
	   Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Object obj=session.load(Student.class,677);
		Student s=(Student)obj;
		Transaction transaction=session.beginTransaction();
		session.delete(s);
		System.out.println("Object deleted");
		transaction.commit();
		session.close();
		sf.close();
		*/
		
		//View Operation
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Object obj=session.load(Student.class,new Integer(30)); //get instead of load()
		Student s=(Student)obj;
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println("Object Displayed");
		session.close();
		sf.close();
		
	}
}
