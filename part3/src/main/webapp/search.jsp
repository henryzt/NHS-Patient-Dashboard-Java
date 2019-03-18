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
    <jsp:include page="/include/meta.jsp"/>
    <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>

<div class="main">
    <jsp:include page="/search-bar.jsp"/>
    <h3>Search Result for '<%=request.getAttribute("search_para")%>'</h3>
    <%
        List<Patient> patients = (List<Patient>) request.getAttribute("list");

        if (patients != null && patients.size() !=0)
        {
    %>
        <jsp:include page="/patient-list.jsp"/>
    <%
        } else
        {%>
        <p>Nothing found</p>
        <%}%>

</div>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>
