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

    <jsp:include page="/search-bar.jsp"/>

      <h3>Patients</h3>
      <jsp:include page="/patient-list.jsp"/>

  <jsp:include page="/include/footer.jsp"/>
</body>
</html>
