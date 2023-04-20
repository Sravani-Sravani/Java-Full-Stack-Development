import java.sql.*;
public class ScrollableResultSet 
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
		
		ResultSet rs = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("select * from employee");
		//ResultSet rs = con.prepareStatement("select * from employee",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery();
		
		System.out.println("Current Row Location:"+rs.getRow());
		
		rs.first();
		
		System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getDouble(4));

		
		System.out.println("Current Row Location:"+rs.getRow());
		
//		rs.previous();
//		
//		System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getDouble(4));

		rs.last();
		
System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getDouble(4));

		
		System.out.println("Current Row Location:"+rs.getRow());
		
//		rs.next();
//		
//System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getDouble(4));

		rs.absolute(3);
		
System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getDouble(4));

		
		System.out.println("Current Row Location:"+rs.getRow());
		
		rs.previous();
		
System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getDouble(4));

		
		System.out.println("Current Row Location:"+rs.getRow());
		
		rs.relative(-1);
		
System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getDouble(4));

		
		System.out.println("Current Row Location:"+rs.getRow());
		
		rs.relative(3);
		
System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getDouble(4));

		
		System.out.println("Current Row Location:"+rs.getRow());
		
		
		
		
		
		
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
	  }
}
