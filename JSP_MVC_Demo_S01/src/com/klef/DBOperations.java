package com.klef;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbconnection.DBConnection;

public class DBOperations 
{
	public static int registration(Employee emp)
	{
		int i=0;
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("insert into employee(name,gender,username,email,password,location) values(?,?,?,?,?,?)");
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getGender());
			pstmt.setString(3, emp.getUsername());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPassword());
			pstmt.setString(6, emp.getLocation());
			i=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}
	public static boolean Login(Employee emp)
	{
		boolean flag=false;
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from employee where username=? and password=?");
			pstmt.setString(1, emp.getUsername());
			pstmt.setString(2, emp.getPassword());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
}
