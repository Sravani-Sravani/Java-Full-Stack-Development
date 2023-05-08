package com.klef.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLDemo_Update 
{
	public static void main(String args[])
	{
		//Update Code
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();// Transient State
		Session session=sf.openSession(); 
		
		//Update HQL - 1 st way
//		Query qry1=session.createQuery("update Student set name='Gayathri Lakshmi' where id=490 ");
//		int n1=qry1.executeUpdate();
//		System.out.println(n1+"Record Updated");
		
		//Update HQL - 2 nd way
	/*    Query qry2=session.createQuery("update Student set name=?,department=? where id=? ");
		qry2.setString(0,"Kumari sirivarshitha");
		qry2.setString(1,"FEMALE");
		qry2.setInteger(2,30);
		int n1=qry2.executeUpdate();
		System.out.println(n1+"Record Updated"); */
		
		//Update HQL - 3 rd way
		Query qry3=session.createQuery("update Student set name=:v1,department=:v2 where id=:v3 ");
		qry3.setParameter("v1","Asifa Khathun");
		qry3.setParameter("v2","CSE");
		qry3.setParameter("v3",31559);
		int n1=qry3.executeUpdate();
		System.out.println(n1+"Record Updated"); 
		
		Transaction transaction=session.beginTransaction();
		transaction.commit();
		session.close(); // Detached State
		sf.close();
		
	}
}
