<!DOCTYPE html>

<html>
    <head>
        <jsp:include page="/include/meta.jsp"/>
        <title>Patient CSV Upload</title>
    </head>

    <body>
        <jsp:include page="/include/header.jsp"/>
        <h3>CSV File Upload & Settings</h3>

        <div class="mdl-shadow--2dp content" style="margin-top:0">
            <h5>Upload new Patient CSV file</h5>
            <form action="file_upload" method="post" enctype="multipart/form-data">
                <input type="file" name="guru_file" size="50" style="padding: 30px" />
                <br>
                <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" value="Upload" />
            </form>
            <%--<p>Choose any action below to continue</p>--%>
            <%--<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" onclick="location.href='patients.html';" style="width:200px;" >Enter Dashboard</button>--%>
        </div>
        <jsp:include page="/include/footer.jsp"/>
    </body>
</html>