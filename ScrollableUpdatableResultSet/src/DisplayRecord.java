import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DisplayRecord 
{
  public static void main(String args[])
  {
      try
      { Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Class Loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd", "root","root");
		System.out.println("Connection Established");
    
    ResultSet rs = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY).executeQuery("select * from employee");
    
    System.out.println("Current Row Location Before While Loop:"+rs.getRow());
    
    System.out.println("****Employee Details***");
    
    while(rs.next())
    {
        System.out.println("Current Row Location:"+rs.getRow());
        System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getDouble(4));
    }
    
    
    
    
    
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
  }
}
 

