package uk.ac.ucl.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;


@WebServlet("/upload")
@MultipartConfig
public class UploadService extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //reference: https://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        String message;

        if(fileName != null && !fileName.equals("")){
            try {
                FileOutputStream outputStream = new FileOutputStream("patients/" + fileName);
                outputStream.write(fileContent.readAllBytes());
                outputStream.close();
                message = "File '" + fileName + "' loaded successfully! <br>You can now select and use this file in the bottom section.";
            } catch (Exception e) {
                message = "File Upload Failed due to " + e;
            }
        }else{
            message = "No file was selected";
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("/upload.jsp").forward(request, response);

  }

}