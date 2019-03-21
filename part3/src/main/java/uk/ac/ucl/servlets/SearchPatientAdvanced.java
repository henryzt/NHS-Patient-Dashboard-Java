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
import java.util.ArrayList;
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
        String initialFirst = request.getParameter("first");
        String initialLast = request.getParameter("last");

        List<Patient> patients = model.getPatients();
        List<Patient> results = new ArrayList<>();
        for(Patient p : patients) {
            boolean match = true;
            if(ageMin != null && !ageMin.equals("")){
                match = (ModelFactory.getPatientAge(p)>=Integer.parseInt(ageMin)) && match;
            }
            if(ageMax != null && !ageMax.equals("")){
                match = (ModelFactory.getPatientAge(p)<=Integer.parseInt(ageMax)) && match;
            }
            if(gender != null && !gender.equals("")){
                if(gender.equals("male")){
                    match = p.get("GENDER").equals("M") && match;
                }
                if(gender.equals("female")){
                    match = p.get("GENDER").equals("F") && match;
                }
            }
            if(city != null && !city.equals("")){
                match = p.findRecord(city) && match;
            }
            if(para != null && !para.equals("")){
                match = p.findRecord(para) && match;
            }
            if(initialFirst != null && !initialFirst.equals("")){
                match = (p.get("FIRST").toLowerCase().startsWith(initialFirst.toLowerCase())) && match;
            }
            if(initialLast != null && !initialLast.equals("")){
                match = (p.get("LAST").toLowerCase().startsWith(initialLast.toLowerCase()) ) && match;
            }



            if(match){
                results.add(p);
            }

        }


        request.setAttribute("search_para", para);
        request.setAttribute("get", false);
        request.setAttribute("list", results);

        forward(request, response);
    }



    private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/search.jsp");
        dispatch.forward(request, response);
    }
}

