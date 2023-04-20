package Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;
import oracle.jdbc.driver.OracleDriver;
public class ClientController2 
{
	public static void main(String args[])
	{
	try
	{
	Connection con = null;

	//Loading Driver Class

	OracleDriver d = new oracle.jdbc.driver.OracleDriver();
	DriverManager.registerDriver(d);
	System.out.println("Driver Class Loaded");

	//Establishing a Connection

	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jfsd","jfsd");
	System.out.println("Connection Established");
	con.close();
	}
	catch(Exception e)
	{
	System.out.println(e);
	}
	}
}
