package Skilling2;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Question1 
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
	System.out.println("Enter Id");
	int id=s.nextInt();
	System.out.println("Enter First Name");
	String fname=s.next();
	System.out.println("Enter Last Name");
	String lname=s.next();
	System.out.println("Enter Year Of Study");
	int yos=s.nextInt();
	System.out.println("Enter Gender");
	String gen=s.next();
	System.out.println("Enter Department");
	String dept=s.next();
	System.out.println("Enter Mobile Number");
	long mob=s.nextLong();
	System.out.println("Enter Date Of Birth");
	String date=s.next();
	System.out.println("Enter Parent Name");
	String pname=s.next();
	System.out.println("Enter Parent Mobile Number");
	long pmob=s.nextLong();
	System.out.println("Enter Address");
	String add=s.next();
	System.out.println("Upload Id");
	File idcard = new File(s.next());
    byte[] ic = new byte[(int)idcard.length()];
	System.out.println("Upload Payment Receipt");
	File payment = new File(s.next());
    byte[] pr = new byte[(int)payment.length()];
    PreparedStatement pstmt = (PreparedStatement)con.prepareStatement("insert into hdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
    pstmt.setInt(1,id);
    pstmt.setString(2,fname);
    pstmt.setString(3,lname);
    pstmt.setInt(4,yos);
    pstmt.setString(5,gen);
    pstmt.setString(6,dept);
    pstmt.setLong(7,mob);
    pstmt.setString(8,date);
    pstmt.setString(9,pname);
    pstmt.setLong(10,pmob);
    pstmt.setString(11, add);
    pstmt.setBytes(12,ic);
    pstmt.setBytes(13,pr);
    pstmt.executeUpdate();
    System.out.println("Record Inserted!!!");
	}
	catch(Exception e)
	{
	System.out.println(e);
	}
	}
}