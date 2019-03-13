<%@ page import="uk.ac.ucl.model.Patient" %><%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 2019-03-13
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient Detail</title>
</head>
<body>
    <jsp:include page="/header.jsp"/>

    <div class="main">

        <h2>View Patient Detail:</h2>
        <ul>
            <%

                Patient patient = (Patient) request.getAttribute("patient");
                for (String field : patient.getFields())
                {%>
                    <li><b><%=field%>:  </b> <%=patient.get(field)%></li>
            <% } %>
        </ul>
    </div>
    <jsp:include page="/footer.jsp"/>
</body>
</html>
