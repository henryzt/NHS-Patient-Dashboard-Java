<%@ page import="java.io.File" %>
<%@ page import="uk.ac.ucl.model.ModelFactory" %><%--reference: https://www.guru99.com/jsp-file-upload-download.html--%>

<!DOCTYPE html>

<html>
    <head>
        <jsp:include page="/include/meta.jsp"/>
        <title>Patient CSV Upload</title>
    </head>

    <body>
        <jsp:include page="/include/header.jsp"/>
        <h3>CSV File Upload & Settings</h3>

        <%--upload message block--%>
        <%if(request.getAttribute("message")!=null){%>
            <div class="mdl-shadow--2dp upload-block">
                <div style="color:deeppink"><b><%=request.getAttribute("message")%></b></div>
            </div>
        <%}%>

        <%--upload function block--%>
        <div class="mdl-shadow--2dp upload-block">
            <h5>Upload new Patient CSV file</h5>
            <%--reference: https://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet--%>
            <form action="upload" method="post" enctype="multipart/form-data">
                <input type="file" name="file" size="50" style="padding: 30px;text-align: center;" /><br>
                <input style="margin-bottom:20px;width:100px;"  class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" value="Upload" />
            </form>
        </div>

        <%--select patient csv block--%>
        <div class="mdl-shadow--2dp upload-block">
            <h5>Select CSV Patient file to display</h5>
            <form action="setcsv" method="post" enctype="multipart/form-data">
                <%
                    File folder = new File("patients");
                    File[] fileList = folder.listFiles();
                    String currentFileName = ModelFactory.getCurrentFile();
                    if(fileList != null){
                        for(File file : fileList){
                            String name = file.getName();
                        %>
                            <div style="text-align: left; width: 35%; margin-right: auto; margin-left: auto; padding:10px;">
                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="<%=name%>">
                                    <input type="radio" id="<%=name%>" class="mdl-radio__button" name="file_select" value="<%=name%>" <%=(name.equals(currentFileName)?"checked":"")%>>
                                    <span class="mdl-radio__label"><%=name%></span>
                                </label>
                            </div>
                        <%
                        }
                    }
                %>
                <input style="margin:20px;width:100px;" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" value="Save" />
            </form>
        </div>


        <jsp:include page="/include/footer.jsp"/>
    </body>
</html>