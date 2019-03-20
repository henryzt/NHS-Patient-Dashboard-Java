package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/advanced-search.html")
public class SearchPatientAdvanced extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();
        String para = request.getParameter("search_string");
        String ageMin = request.getParameter("min");
        String ageMax = request.getParameter("max");
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");
        String initial = request.getParameter("initial");

        List<Patient> patients = model.getPatients();



        List<Patient> searchResult = model.search(para);
        request.setAttribute("search_para", para);
        request.setAttribute("list", searchResult);

        forward(request, response);
    }

    private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/search.jsp");
        dispatch.forward(request, response);
    }
}

