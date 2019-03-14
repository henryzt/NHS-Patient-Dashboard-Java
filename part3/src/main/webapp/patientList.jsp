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
    <div>
      <h3>Patients</h3>
      <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp center">
        <thead>
        <tr>
          <th class="mdl-data-table__cell--non-numeric">Prefix</th>
          <th class="mdl-data-table__cell--non-numeric" style="width: 50%">First Name</th>
          <th class="mdl-data-table__cell--non-numeric" style="width: 50%">Last Name</th>
          <th class="mdl-data-table__cell--non-numeric">Gender</th>
          <th class="mdl-data-table__cell--non-numeric">Birthday</th>
          <th class="mdl-data-table__cell--non-numeric">Race</th>
          <th class="mdl-data-table__cell--non-numeric">Detail</th>
        </tr>
        </thead>
        <tbody>

        <%
          List<Patient> patients = (List<Patient>) request.getAttribute("patients");
          for (Patient patient : patients)
        {
          String href = "patient-detail.html?id=" + patient.get("ID"); %>
        <tr onclick="window.location='<%=href%>';">
          <td class="mdl-data-table__cell--non-numeric"><%=patient.get("PREFIX")%></td>
          <td class="mdl-data-table__cell--non-numeric"><%=patient.get("FIRST")%></td>
          <td class="mdl-data-table__cell--non-numeric"><%=patient.get("LAST")%></td>
          <td class="mdl-data-table__cell--non-numeric"><%=patient.get("GENDER")%></td>
          <td class="mdl-data-table__cell--non-numeric"><%=patient.get("BIRTHDATE")%></td>
          <td class="mdl-data-table__cell--non-numeric"><%=patient.get("RACE")%></td>
          <td class="mdl-data-table__cell--non-numeric"><a href="<%=href%>">Details</a></td>
        </tr>
        <% } %>
        </tbody>
      </table>
    </div>
  </div>
  <jsp:include page="/include/footer.jsp"/>
</body>
</html>
