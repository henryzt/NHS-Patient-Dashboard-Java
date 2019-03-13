<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient List</title>
</head>
<body>
<jsp:include page="/header.jsp"/>

  <div class="main">
    <h1>Search</h1>
    <form method="POST" action="/search.html">
      <input type="text" name="search_string"
             placeholder="Search for anything..."/>
      <input type="submit" value="Search"/>
    </form>
  </div>

  <div class="main">

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
  <jsp:include page="/footer.jsp"/>
</body>
</html>
