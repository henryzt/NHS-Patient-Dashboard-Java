<%--reference: https://www.guru99.com/jsp-file-upload-download.html--%>

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
                <div style="color:deeppink"><%=request.getAttribute("message")%></div>
            </div>
        <%}%>

        <%--upload function block--%>
        <div class="mdl-shadow--2dp upload-block">
            <h5>Upload new Patient CSV file</h5>
            <form action="upload" method="post" enctype="multipart/form-data">
                <input type="file" name="file" size="50" style="padding: 30px;text-align: center;" /><br>
                <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" value="Upload" />
            </form>
        </div>



        <jsp:include page="/include/footer.jsp"/>
    </body>
</html>