package com.klef.hcql;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.klef.demo.Student;
public class HCQLOperations
{
	public static void main(String args[])
	  {
	    Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory sf=cfg.buildSessionFactory();
	    Session s=sf.openSession();
	    Criteria c=s.createCriteria(Student.class);
	    
	     //  equal(eq)
	      // c.add(Restrictions.eq("id",31559));
	        
	      //2.lessthan(lt)
	   //  c.add(Restrictions.lt("age",21.0));
	        
	      //3.greaterthan(gt)
	        c.add(Restrictions.gt("age",19.0));
	        
	      /*// 4.lessthan or equal to(le)
	        c.add(Restrictions.le("age",19.0));*/
	              
	      /*// 5.greaterthan or equal to(ge)
	        c.add(Restrictions.ge("age",20.0));*/
	        
	      /*// 6.between
	        c.add(Restrictions.between("age",19.0,20.0));*/
	        
	      // 7.not
	        c.add(Restrictions.not(Restrictions.eq("id",877)));
	        
	        
	     /*// 8.like
	        c.add(Restrictions.like("name", "G%"));
	        
	        //c.add(Restrictions.like("name", "Ga%"));
	        
	        //c.add(Restrictions.like("name", "%"));
	        
	       // c.add(Restrictions.like("name", "%a"));
	        
	        //c.add(Restrictions.like("name", "Di___"));
	        
	        //c.add(Restrictions.like("name", "______"));
	        
	       // c.add(Restrictions.not(Restrictions.like("name", "G%")));*/
	        
	     /* // 9.idEq
	        c.add(Restrictions.idEq(490));*/
	        
	      /*// 10.isNotNull
	       // c.add(Restrictions.isNotNull("name"));
	        //update emp set name=null where id=2022;
	        c.add(Restrictions.isNotNull("name"));*/
	        
	     /* // 11.isNull
	        c.add(Restrictions.isNull("name"));*/
	        
	     /* // 12.Pagination
	        c.setFirstResult(0);
	        c.setMaxResults(2);*/
	        
	        /*c.setFirstResult(2);
	        c.setMaxResults(2);*/
	    
	       /* c.setFirstResult(2);*/
	        
	      /*// 13.and
	        c.add(Restrictions.and(Restrictions.le("age",20.0),Restrictions.like("name", "G%")));*/
	        
	     /* // 14.or
	        c.add(Restrictions.or(Restrictions.le("age",19.00),Restrictions.like("name", "D%")));*/
	        
	      /*  // 15.in
	       // c.add(Restrictions.in("id",new Integer[] {490,2021,2022}));
	        
	        c.add(Restrictions.in("name",new String[] {"Gayathri Lakshmi Jetti","Keerthi"}));*/
	        
	   /*     
	       List <Student> list=c.list();
	        for(Student stu:list)
	        {
	          System.out.println(stu.getId()+","+stu.getName()+","+stu.getAge()+","+stu.getDepartment()+","+stu.getGender());
	        }
	        s.close();
	        sf.close();
	  */    
	        
	        
	      // Projections
	        c.setProjection(Projections.property("name"));
	        List list=c.list();
	        System.out.println("Total records :"+list.size());
	        for(int i=0;i<list.size();i++)
	        {
	          System.out.println(list.get(i));
	        }
	        
	      // Projections with asc/dsc
	        /*c.setProjection(Projections.property("id"));
	          c.addOrder(Order.desc("id"));
	        List list=c.list();
	        System.out.println("Total records :"+list.size());
	        for(int i=0;i<list.size();i++)
	        {
	          System.out.println(list.get(i));
	        }*/
	        
	      
	        
	      // Aggregate functions/Multi Row Functions
	      /* // c.setProjection(Projections.rowCount());
	        
	        //c.setProjection(Projections.sum("age"));
	        
	        //c.setProjection(Projections.min("age"));
	        
	        //c.setProjection(Projections.max("age"));
	        
	        //c.setProjection(Projections.count("age"));
	        
	        c.setProjection(Projections.avg("age"));
	        
	        List list=c.list();
	        System.out.println(list.get(0));*/
	    
	  }

}
