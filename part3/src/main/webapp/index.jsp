<!DOCTYPE html>

<html lang="en">

    <head>
        <jsp:include page="/include/meta.jsp"/>
        <title>Patient Manager</title>

        <style>
            .mdl-button{
                margin-top:20px;
            }

            @media only screen and (max-width: 800px) {
                .content{
                    width:85%;
                    padding:20px;
                    padding-bottom:70px;
                    margin-top:70px;
                }
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