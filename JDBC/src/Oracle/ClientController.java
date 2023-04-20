package Oracle;

import java.sql.Connection;
import java.sql.DriverManager;

public class ClientController 
{
public static void main(String args[])
{
	try
	{
		Connection con=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver class loaded");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jfsd","jfsd");
		System.out.println("Connection Established");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}
