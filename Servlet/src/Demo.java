import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testdemo") //without .xml file
public class Demo extends HttpServlet
{
  public void init()
  {
    System.out.println("Servlet is Initialized");
  }
  public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
  {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    out.println("Serive Method");
    System.out.println("Service Method");
  }
  public void destroy()
  {
    System.out.println("Servlet is Destroyed");
  }
}