package uk.ac.ucl.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/upload.html")
public class Upload extends HttpServlet
{
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
  {
    // Just forward
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/upload.jsp");
    dispatch.forward(request, response);
  }
}