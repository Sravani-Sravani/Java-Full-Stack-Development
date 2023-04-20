package Skilling1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class Question2 
{
	static Scanner s = new Scanner(System.in);
	public static Connection getConnection()
	  {
		Connection con=null;
	      try
	      { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd", "root","root");
			System.out.println("Connection Established");
	      }
	      catch(Exception e)
	      {
	          System.out.println(e);
	      }
		return con;
	  }
	public static String Update()
	{
		String msg = null;
		try
		{
			Connection con=null;
			con=getConnection();
			System.out.println("Enter Id");
			int sid=s.nextInt();
			System.out.println("Enter Updated CGPA");
			double ucgpa=s.nextDouble();
			System.out.println("Enter Updated Backlogs");
			int unob=s.nextInt();
			ResultSet rs1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("select id,name,gender,yearofstudy,dept,mailid,cgpa,noofbacklogs from student_crt where id="+sid+"");
			if(rs1.next())
			{
		    rs1.updateDouble("cgpa",ucgpa);
		    rs1.updateInt("noofbacklogs", unob);
		    rs1.updateRow();
		    msg="Success";
	        System.out.println("Record Updated");
			}
			else
			{
				System.out.println("Check your id carefully if you are not insert your details enter your details by selecting 1");
				System.out.println("If you have entered earlier but not present in the list then check in eligible list");
			}
	        
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return msg;
	}
	
	
	public static void main(String[] args) 
	{
		try {
			
	
		Connection con=null;
		con=getConnection();
		System.out.println("====== WELCOME TO KL CRT DEPARTMENT =======");
		while(true)
		{
			System.out.println("1. Insert Student Data");
			System.out.println("2. Update Student Details");
			System.out.println("3. Dividing Eligible students");
			System.out.println("4. Display the Students");
			System.out.println("5. Exit");
			System.out.println("Enter your choice: ");
			int choice = s.nextInt();
			switch(choice)
			{
			case 1: System.out.println("Inserting Data");
			System.out.println("Enter Id");
			int id=s.nextInt();
			System.out.println("Enter name");
			String name=s.next();
			System.out.println("Enter gender");
			String gender=s.next();
			System.out.println("Enter yearofstudy");
			String yos=s.next();
			System.out.println("Enter department");
			String dept=s.next();
			System.out.println("Enter Mail Id");
			String mail=s.next();
			System.out.println("Enter CGPA");
			double cgpa=s.nextDouble();
			System.out.println("Enter No Of Backlogs");
			int blgs=s.nextInt();
			ResultSet rs = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("select id,name,gender,yearofstudy,dept,mailid,cgpa,noofbacklogs from student_crt");
			rs.moveToInsertRow();
		    rs.updateInt("id",id);
		    rs.updateString("name",name);
		    rs.updateString("gender",gender);
		    rs.updateString("yearofstudy",yos);
		    rs.updateString("dept",dept);
		    rs.updateString("mailid",mail);
		    rs.updateDouble("cgpa", cgpa);
		    rs.updateInt("noofbacklogs",blgs);
		    rs.insertRow();
		    System.out.println("Record is Inserted successfully");
			break;
			case 2: System.out.println("Updating Student Details");
			Update();
			break;
			case 3: System.out.println("Dividing Eligible Students");
			ResultSet rs3 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("select id,name,gender,yearofstudy,dept,mailid,cgpa,noofbacklogs from student_crt");
			while(rs3.next())
			{
				double pcgpa=rs3.getDouble(7);
				if(pcgpa>7.5)
				{
					ResultSet rs2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("select id,name,yearofstudy,dept,mailid,cgpa,noofbacklogs from eligible_list");
					rs2.moveToInsertRow();
				    rs2.updateInt("id",rs3.getInt(1));
				    rs2.updateString("name",rs3.getString(2));
				    rs2.updateString("yearofstudy",rs3.getString(4));
				    rs2.updateString("dept",rs3.getString(5));
				    rs2.updateString("mailid",rs3.getString(6));
				    rs2.updateDouble("cgpa", rs3.getDouble(7));
				    rs2.updateInt("noofbacklogs",rs3.getInt(8));
				    rs2.insertRow();
				    System.out.println("Record inserted Successfully with Id: "+rs3.getInt(1)+" name: "+rs3.getString(2)+" with CGPA "+rs3.getDouble(7)+" in Eligible List");
				    rs3.deleteRow();
				    System.out.println("Records deleted in student table");
				    
				}
				else
				{
					System.out.println("");
					System.out.println("================================");
				    System.out.println("Ineligible list");
				    System.out.println("");
					System.out.println("The Student with Id: "+rs3.getInt(1)+" is not eligible to CRT training because of less CGPA:"+rs3.getDouble(7)+" which is less than 7.5");
				    System.out.println("");
				}
				
			}
			System.out.println("There are no more eligible students to divide");
			break;
			case 4: System.out.println("Eligible Students List");
			System.out.println("==========================================");
			ResultSet rs4=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("select id,name,yearofstudy,dept,mailid,cgpa,noofbacklogs from eligible_list");
			while(rs4.next())
			{
				System.out.println("");
				System.out.println(rs4.getString(2)+" with Id "+rs4.getInt(1)+"is Eligible for CRT Training with CGPA "+rs4.getDouble(6) );
				System.out.println("");
			}
			break;
			case 5: System.out.println("Exiting the application");
			System.exit(0);
			default: System.out.println("Incorrect input!!! Please re-enter choice from our menu");
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	
}
