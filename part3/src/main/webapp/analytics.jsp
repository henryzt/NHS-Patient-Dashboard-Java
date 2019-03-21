<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page import="uk.ac.ucl.model.ModelFactory" %>
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
        <div>
            <h3>Patient Analytics</h3>
        </div>
        <%
            List<String> info = (List<String>) request.getAttribute("statistics"); %>

            <%
                for (String field : info)
                {%>
                    <div class="mdl-shadow--2dp stats" >
                        <b><%=field%></b>
                    </div>

            <% } %>


    </div>



    </div>
    <jsp:include page="/include/footer.jsp"/>
</body>
</html>
