<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.ModelFactory" %>
<%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 2019-03-14
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>

<div>
    <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp center">
        <thead>
        <tr>
            <th class="mdl-data-table__cell--non-numeric">Prefix</th>
            <th class="mdl-data-table__cell--non-numeric" style="width: 50%">First Name</th>
            <th class="mdl-data-table__cell--non-numeric" style="width: 50%">Last Name</th>
            <th class="mdl-data-table__cell--non-numeric">Gender</th>
            <th class="mdl-data-table__cell--non-numeric">Age</th>
            <th class="mdl-data-table__cell--non-numeric">City</th>
            <th class="mdl-data-table__cell--non-numeric">Birthday</th>
            <th class="mdl-data-table__cell--non-numeric" style="text-align: center">Detail</th>
        </tr>
        </thead>
        <tbody>

        <%
            List<Patient> patients = (List<Patient>) request.getAttribute("list");
            for (Patient patient : patients)
            {
                String href = "patient-detail.html?id=" + patient.get("ID"); %>
        <tr onclick="window.location='<%=href%>';">
            <td class="mdl-data-table__cell--non-numeric"><%=patient.get("PREFIX")%></td>
            <td class="mdl-data-table__cell--non-numeric"><%=patient.get("FIRST")%></td>
            <td class="mdl-data-table__cell--non-numeric"><%=patient.get("LAST")%></td>
            <td class="mdl-data-table__cell--non-numeric"><%=patient.get("GENDER")%></td>
            <td class="mdl-data-table__cell--non-numeric"><%=ModelFactory.getPatientAge(patient)%></td>
            <td class="mdl-data-table__cell--non-numeric"><%=patient.get("CITY")%></td>
            <td class="mdl-data-table__cell--non-numeric"><%=patient.get("BIRTHDATE")%></td>
            <td class="mdl-data-table__cell--non-numeric"><a class="mdl-button mdl-js-button mdl-button--accent" style="padding: 0;" href="<%=href%>">View</a></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</div>