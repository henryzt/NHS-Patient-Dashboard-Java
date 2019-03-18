package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Patient;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/patients.html")
public class PatientList extends HttpServlet
{
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
  {
    // Code to use the model to process something would go here.
    Model model = ModelFactory.getModel();
    List<Patient> patients = model.getPatients();
    request.setAttribute("list", patients);

    // Then forward to JSP.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/patientList.jsp");
    dispatch.forward(request, response);
  }
}