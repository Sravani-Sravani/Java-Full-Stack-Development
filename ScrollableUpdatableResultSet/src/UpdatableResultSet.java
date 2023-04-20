import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class UpdatableResultSet {
	 public static void main(String args[])
	  {
	      try
	      {
	    	  Connection con=null;
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		System.out.println("Driver Class Loaded");
	    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jfsd", "root","root");
	    		System.out.println("Connection Established");
	    //ResultSet rs = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("select empid,empname,empgender,empsalary from employee");
	 // Insert Method
	    
	    /*   rs.moveToInsertRow();
	    rs.updateInt("empid",6);
	    rs.updateString("empname", "Sai");
	    rs.updateString("empgender", "Male");
	    rs.updateDouble("empsalary", 75678.090);
	    rs.insertRow();
	    System.out.println("Record is Inserted successfully");
	    
	*/
	    //Update Operation
	    
	 /*   rs.absolute(6);
	    rs.updateString("empname","Gayathri Lakshmi");
	    rs.updateRow();
        System.out.println("Record Updated");
        
        */
	    
	    // Delete Operation
	    
	   // rs.absolute(7);
	   // rs.deleteRow();
	    //System.out.println("Record Deleted");
	    
	    
	    ResultSet rs1 = con.prepareStatement("select empid,empname,empgender,empsalary from employee",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery();
	    rs1.moveToInsertRow();
	    rs1.updateInt("empid",7);
	    rs1.updateString("empname", "Gayathri");
	    rs1.updateString("empgender", "Male");
	    rs1.updateDouble("empsalary", 75678.090);
	    rs1.insertRow();
	    System.out.println("Record is Inserted successfully");
	      }
	      catch(Exception e)
	      {
	          System.out.println(e);
	      }
	  }
}
