import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class logicclass 
{
public static String insertrecord() throws SQLException
{
	String msg=null;
	Connection con=null;
	try 
	{
		System.out.println("Driver Class Loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsdskillexam", "root","root");
		System.out.println("Connection Established");
		Scanner s=new Scanner(System.in);
		System.out.println("Enter id");
		int id=s.nextInt();
		System.out.println("Enter Name");
		String name=s.next();
		System.out.println("Enter Gender");
		String gender=s.next();
		System.out.println("Enter Mobile");
		String mobile=s.next();
		PreparedStatement pstmt=con.prepareStatement("insert into crt values(?,?,?,?)");
		pstmt.setInt(1,id);
		pstmt.setString(2,name);
		pstmt.setString(3,gender);
		pstmt.setString(4,mobile);
		int i=pstmt.executeUpdate();
		if(i>0)
		{
		msg="SUCCESS";	
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return msg;
}
}
