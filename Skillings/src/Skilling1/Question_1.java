package Skilling1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class Question_1 
{
	public static void main(String args[])
	  {
	      try
	      {
	    	    Connection con=null;
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		System.out.println("Driver Class Loaded");
	    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd", "root","root");
	    		System.out.println("Connection Established");
	    		Scanner s=new Scanner(System.in);
	    		System.out.println("Enter id");
	    		int id=s.nextInt();
	    		System.out.println("Enter name");
	    		String name=s.next();
	    		System.out.println("Enter Gender");
	    		String gen=s.next();
	    		System.out.println("Enter your Specialization");
	    		String cou=s.next();
ResultSet rs = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("select sid,sname,actual,allocated from specialization where sname='"+cou+"'");
ResultSet rs1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("select id,name,gender,sname from student");
ResultSet rs2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("select id,name,sid,sname from allocation");
	    		rs.next();
	    		rs1.next();
	    		rs2.next();
	    		rs1.moveToInsertRow();
    		    rs1.updateInt("id",id);
    		    rs1.updateString("name",name);
    		    rs1.updateString("gender",gen);
    		    rs1.updateString("sname",cou);
    		    rs1.insertRow();
    		    System.out.println("Record is Inserted in to student table successfully");
    		    int sid=rs.getInt(1);
	    		String spe=rs.getString(2);
	    	    int act=rs.getInt(3);
	    	    int all=rs.getInt(4);
	    	    System.out.println(spe);
	    	    System.out.println(sid);
	    		if(act>0)
	    		{
	    			rs2.moveToInsertRow();
	    		    rs2.updateInt("id",id);
	    		    rs2.updateString("name",name);
	    		    rs2.updateInt("sid",sid);
	    		    rs2.updateString("sname",cou);
	    		    rs2.insertRow();
	    		    System.out.println("Record is Inserted successfully");
	    		    System.out.println("Student Details");
	    		    System.out.println("===================================================");
	    		    System.out.println("Student Id: "+id);
	    		    System.out.println("Student Name: "+name);
	    		    System.out.println("Specialization Id: "+sid);
	    		    System.out.println("Specialization: "+cou);
	    		    rs.updateInt("actual",act-1);
		    	    rs.updateInt("allocated",all+1);
		    	    rs.updateRow();
		            System.out.println("Seats Updated");
	    		}
	    		else
	    		{
	    			System.out.println("No sufficient Seats");
	    		}
	      }
	      catch(Exception e)
	      {
	          System.out.println(e);
	      }
	  }
}
