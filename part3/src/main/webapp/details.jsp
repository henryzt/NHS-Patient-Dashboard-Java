<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page import="uk.ac.ucl.model.ModelFactory" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/include/meta.jsp"/>
    <title>Patient Detail</title>
</head>
<body>
    <jsp:include page="/include/header.jsp"/>


    <div class="center">
        <div>
            <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
                    type="submit" onClick="javascript:history.go(-1)" style="float:left;width: 10%">Back</button>
            <h3 style="width: 90%" >Patient Detail</h3>

        </div>
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
