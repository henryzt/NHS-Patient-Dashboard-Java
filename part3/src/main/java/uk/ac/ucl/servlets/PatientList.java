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
    String pagePara = request.getParameter("page");
    if(pagePara == null || pagePara.equals("")){
        pagePara = "1";
    }
    int page = Integer.parseInt(pagePara);
    int patientPerPage = 30;

    Model model = ModelFactory.getModel();
    List<Patient> patients = model.getPatients();
    List<Patient> currentPagePatients = patients.subList((page-1)*patientPerPage, (page)*patientPerPage);
    request.setAttribute("list", currentPagePatients);
    request.setAttribute("pageCurrent", page);
    request.setAttribute("pageTotal", patients.size()/patientPerPage);


    // Then forward to JSP.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/patientList.jsp");
    dispatch.forward(request, response);
  }
}