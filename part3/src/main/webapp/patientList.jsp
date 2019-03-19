<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/include/meta.jsp"/>
  <title>Patient List</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>

  <div class="main">

      <h3>All Patients</h3>
      <p><%=request.getAttribute("numberIndicator")%></p>

      <jsp:include page="/include/pagination.jsp"/>
      <jsp:include page="/patient-list.jsp"/>
      <jsp:include page="/include/pagination.jsp"/>

    <jsp:include page="/search-bar.jsp"/>
  <jsp:include page="/include/footer.jsp"/>
</body>
</html>
