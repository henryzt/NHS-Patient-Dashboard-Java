<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 2019-03-13
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>

<div class="main">

    <h1>Search Result</h1>
    <%
        List<Patient> patients = (List<Patient>) request.getAttribute("result");

        if (patients != null && patients.size() !=0)
        {
    %>
    <ul>
        <%
            for (Patient patient : patients){
        %>
        <li><%=patient.get("FIRST")%></li>
        <% }
        } else
        {%>
        <p>Nothing found</p>
        <%}%>
    </ul>
</div>

<jsp:include page="/footer.jsp"/>
</body>
</html>
