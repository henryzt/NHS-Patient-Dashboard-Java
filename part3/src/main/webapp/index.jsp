<!DOCTYPE html>

<html>
    <head>
        <jsp:include page="/include/meta.jsp"/>
        <title>Patient Dashboard</title>
        <style>
            .mdl-button{
                margin-top:20px;
            }
        </style>
    </head>

    <body>
        <br><br>
        <div class="mdl-shadow--2dp center_div content" >
            <h3>Welcome to Patient Manager!</h3>
            <p>Choose any action below to continue</p>
            <br><button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" onclick="location.href='patients.html';" style="width:200px;" >Enter Dashboard</button>
            <br><button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--accent" onclick="location.href='search.html';" style="width:200px;" >Quick search</button>
        </div>
        <jsp:include page="/include/footer.jsp"/>
    </body>
</html>