package uk.ac.ucl.servlets;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Patient;

import java.io.*;

import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet("/search.html")
public class SearchPatient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        List<Patient> searchResult = model.search(request.getParameter("searchstring"));
        request.setAttribute("result", searchResult);
        ServletContext context = getServletContext(); RequestDispatcher dispatch =
                context.getRequestDispatcher("/search.jsp"); dispatch.forward(request, response);
    }
}

