package com.klef.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQL_Demo_Delete 
{
	public static void main(String args[])
	{
		//Delete Code
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();// Transient State
		Session session=sf.openSession(); 
		
		//Delete HQL - 1 st way
      // Query qry1=session.createQuery("delete from Student where id=877");
		//int n1=qry1.executeUpdate();
		//System.out.println(n1+"Object deleted");
		
		//Delete HQL - 2 nd way
	/*	 Query qry2=session.createQuery("delete from Student where id=?");
		 qry2.setInteger(0,30677);
			int n1=qry2.executeUpdate();
			System.out.println(n1+"Object deleted"); */
			
		//Delete HQL - 3 rd Way
			Query qry3=session.createQuery("delete from Student where id=:v");
			qry3.setParameter("v",31559);
			int n1=qry3.executeUpdate();
			System.out.println(n1+"Object deleted");
			
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close(); // Detached State
		sf.close();
		
	}
}
