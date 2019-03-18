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
    <jsp:include page="/include/meta.jsp"/>
    <title>Patient Detail</title>
</head>
<body>
    <jsp:include page="/include/header.jsp"/>

    <div class="main">

        <h3>Patient Detail</h3>
    <div class="center">
        <%
            Patient patient = (Patient) request.getAttribute("patient");
            if(patient == null){%>
                <p>Patient not found</p>
            <%
            }else{
            %>


        <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp " style="width: 100%">
            <tbody style="width: 100%;">
            <%
                for (String field : patient.getFields())
                {%>
                    <tr>
                        <td class="mdl-data-table__cell--non-numeric" style="width: 50%"><b><%=field%></b></td>
                        <td class="mdl-data-table__cell--non-numeric"><%=patient.get(field)%></td>
                    </tr>
            <% } %>

            </tbody>
        </table>
        <% } %>
    </div>



    </div>
    <jsp:include page="/include/footer.jsp"/>
</body>
</html>
