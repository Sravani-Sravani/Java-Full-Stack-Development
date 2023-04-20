package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EndUser 
{
public static int findeven(int n)
{
	int flag=0;
	if(n%2==0)
	{
		flag=1;
	}
	else
	{
		flag=0;
	}
	return flag;
}
public static boolean findodd(int n)
{
	boolean flag=false;
	if(n%2!=0)
	{
		flag=true;
	}
	else
	{
		flag=false;
	}
	return flag;
}
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
public static boolean getDBConnection()
{
	Connection con=null;
	boolean flag = false;
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Class Loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd", "root","root");
		System.out.println("Connection Established");
		if(con!=null)
		{
			flag=true;
		}
		else 
		{
			flag=false;
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return flag;
}

public static String insertrecord()
{
	String msg = null;
	try
	{
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Class Loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd", "root","root");
		System.out.println("Connection Established");
ResultSet rs = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("select empid,empname,empgender,empsalary from employee");
// Insert Method

rs.moveToInsertRow();
rs.updateInt("empid",10);
rs.updateString("empname", "Ankitha");
rs.updateString("empgender", "FeMale");
rs.updateDouble("empsalary", 75678.090);
rs.insertRow();
msg="Success";
System.out.println("Record is Inserted successfully");
rs.moveToCurrentRow();

	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	return msg;
}

public static int insertrow()
{
	int n=0;
	try
	{
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Class Loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd", "root","root");
		System.out.println("Connection Established");
PreparedStatement pstmt=con.prepareStatement("insert into employee values(?,?,?,?)");
pstmt.setInt(1,9);
pstmt.setString(2,"Lakshmi");
pstmt.setString(3,"Female");
pstmt.setDouble(4, 35059.44);
n=pstmt.executeUpdate();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	return n;
}

}
