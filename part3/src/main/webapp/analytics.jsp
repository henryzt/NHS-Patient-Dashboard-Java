<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <jsp:include page="/include/meta.jsp"/>
        <title>Patient Analytics</title>
    </head>
    <body>
        <jsp:include page="/include/header.jsp"/>
        <div class="center">
            <h3>Patient Analytics</h3>
            <p style="color: gray">Hover to zoom in</p>
            <%List<String> info = (List<String>) request.getAttribute("statistics"); %>

                <%if(info != null){
                    for (String field : info) {%>
                        <div class="mdl-shadow--2dp stats" >
                            <b><%=field%></b>
                        </div>
                <% }
                }%>

        </div>
        <jsp:include page="/include/footer.jsp"/>
    </body>
</html>
