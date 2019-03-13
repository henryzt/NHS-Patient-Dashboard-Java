<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Patient List</title>
</head>
<body>
<div class="main">
  <h2>Patients:</h2> <ul>
  <%

    List<Patient> patients = (List<Patient>) request.getAttribute("patients");
    for (Patient patient : patients)
  {
    String href = "viewPatientInfo.html?id=" + patient.get("ID"); %>
  <li><a href="<%=href%>"><%=patient%></a></li>
  <% } %>
</ul>
</div>

</body>
</html>
