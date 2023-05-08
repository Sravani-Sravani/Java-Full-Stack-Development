package com.klef.demo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQL_Demo_Select 
{
	public static void main(String args[])
	{
		//Select HQL
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();// Transient State
		Session session=sf.openSession(); 
		
		//select HQL - 1 st way
		
		/*
      Query qry1=session.createQuery("from Student");
      List<Student> list1=qry1.list();
      int n=1;
      System.out.println("Total Records"+list1.size());
      for(Student student : list1)
      {
    	  System.out.println("Student Record"+n1);
    	  System.out.println(student.getId());
    	  System.out.println(student.getName());
    	  System.out.println(student.getDepartment());
    	  System.out.println(student.getGender());
    	  System.out.println(student.getAge());  
    	  n1++;
      }
      */
		
      // Select HQL - 2 nd Way
     
		/*
      Query qry2=session.createQuery("from Student where id=30");
      List<Student> list2=qry2.list();
      System.out.println("Total Records"+list2.size());
      int n2=1;
      for(Student student : list2)
      {
    	  System.out.println("Student Record"+n2);
    	  System.out.println(student.getId());
    	  System.out.println(student.getName());
    	  System.out.println(student.getDepartment());
    	  System.out.println(student.getGender());
    	  System.out.println(student.getAge());  
    	  n2++;
      }
      */
      
      //Select HQL - 3 rd way
      
		/*
      Query qry3=session.createQuery("from Student where id=?");
      qry3.setInteger(0,490);
      List<Student> list3=qry3.list();
      System.out.println("Total Records"+list3.size());
      int n3=1;
      for(Student student : list3)
      {
    	  System.out.println("Student Record"+n3);
    	  System.out.println(student.getId());
    	  System.out.println(student.getName());
    	  System.out.println(student.getDepartment());
    	  System.out.println(student.getGender());
    	  System.out.println(student.getAge());  
    	  n3++;
      }
      */
      // Select HQL - 4 th way
      
      Query qry4=session.createQuery("from Student where id=:v");
      qry4.setParameter("v",30);
      List<Student> list4=qry4.list();
      System.out.println("Total Records"+list4.size());
      int n4=1;
      for(Student student : list4)
      {
    	  System.out.println("Student Record"+n4);
    	  System.out.println(student.getId());
    	  System.out.println(student.getName());
    	  System.out.println(student.getDepartment());
    	  System.out.println(student.getGender());
    	  System.out.println(student.getAge());  
    	  n4++;
      }
	}
}
