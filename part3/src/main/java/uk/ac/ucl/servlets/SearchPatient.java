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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getParameter("page")!=null && ModelFactory.getSearchResultCache() != null){
            ModelFactory.pageDivider(request,ModelFactory.getSearchResultCache());
            request.setAttribute("get", false);
        }else {
            request.setAttribute("get", true);
        }

        forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("get", false);
        Model model = ModelFactory.getModel();
        String para = request.getParameter("search_string");
        //if no search term is passed, terminate search
        if(para.equals("")){
            doGet(request,response);
            return;
        }
        List<Patient> searchResult = model.search(para);
        request.setAttribute("search_para", para);
        request.setAttribute("list", searchResult);


        ModelFactory.setSearchResultCache(searchResult);
        ModelFactory.pageDivider(request,searchResult);

        forward(request, response);
    }

    private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/search.jsp");
        dispatch.forward(request, response);
    }
}

