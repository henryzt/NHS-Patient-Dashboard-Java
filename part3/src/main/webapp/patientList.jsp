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
    <h2>Patients:</h2>
      <ul>
      <%

        List<Patient> patients = (List<Patient>) request.getAttribute("patients");
        for (Patient patient : patients)
      {
        String href = "patient-detail.html?id=" + patient.get("ID"); %>
      <li><a href="<%=href%>"><%=patient.get("FIRST")%></a></li>
      <% } %>
    </ul>
  </div>
  <jsp:include page="/include/footer.jsp"/>
</body>
</html>
