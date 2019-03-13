package ucl.ac.uk.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/hello.html")
public class HelloWorldServlet extends HttpServlet
{
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
  {
    response.setContentType("text/html");
    try (PrintWriter out = response.getWriter())
    {
      out.println("<html>");
      out.println("<head><title>Hello, World</title></head>");
      out.println("<body>");
      out.println("<h1>Hello, from the Servlet World!</h1>");  // says Hello
      out.println("</body></html>");
    }
  }
}