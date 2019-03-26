package uk.ac.ucl.servlets;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.List;

@WebServlet("/upload")
@MultipartConfig
public class UploadService extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();

        if(fileName != null && !fileName.equals("")){
            try {
                FileOutputStream outputStream = new FileOutputStream("patients/" + fileName);
                outputStream.write(fileContent.readAllBytes());
                outputStream.close();
                request.setAttribute("message", "File '" + fileName + "' Uploaded Successfully!");
            } catch (Exception e) {
                request.setAttribute("message", "File Upload Failed due to " + e);
            }
        }else{
            request.setAttribute("message","No file was selected");
        }
        request.getRequestDispatcher("/upload.jsp").forward(request, response);

  }

}