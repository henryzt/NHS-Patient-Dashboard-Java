package uk.ac.ucl.servlets;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadService extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if(ServletFileUpload.isMultipartContent(request)){
      try {
        List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
        for(FileItem item : multiparts){
          if(!item.isFormField()){
            String name = new File(item.getName()).getName();
            item.write( new File("c:/guru/upload" + File.separator + name));
          }
        }
        //File uploaded successfully
        request.setAttribute("message", "File Uploaded Successfully");
      } catch (Exception ex) {
        request.setAttribute("message", "File Upload Failed due to " + ex);
      }
    }else{
      request.setAttribute("message","No File found");
    }
    request.getRequestDispatcher("/result.jsp").forward(request, response);

  }

}