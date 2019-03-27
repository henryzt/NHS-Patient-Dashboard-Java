package uk.ac.ucl.servlets;


import uk.ac.ucl.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/setcsv")
@MultipartConfig
public class SetCSVService extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fileName = request.getParameter("file_select");
        String message;

        if(fileName != null && !fileName.equals("")){
            if(ModelFactory.setCurrentFile(fileName)){
                message = "Patient CSV changed successfully!";
            }else {
                message = "Fail to change Patient CSV, please check whether the file is in valid Patient format!";
            }

        }else {
            message = "No file was selected";
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("/upload.jsp").forward(request, response);

  }

}