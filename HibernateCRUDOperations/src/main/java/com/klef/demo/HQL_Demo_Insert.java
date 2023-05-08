package com.klef.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class HQL_Demo_Insert 
{
	public static void main(String args[])
	{
		//Insert Code
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession(); 
		Student student=new Student();
		student.setId(877);
		student.setName("Santhi");
		student.setDepartment("CSE");
		student.setGender("MALE");
		student.setAge(20);
		Transaction transaction=session.beginTransaction();
		session.save(student);
		transaction.commit();
		System.out.println("Object Saved");
		session.close();
		sf.close();
		
	}
}
