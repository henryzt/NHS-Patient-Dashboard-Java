<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <jsp:include page="/include/meta.jsp"/>
    <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/include/header.jsp"/>

<div class="main">
    <jsp:include page="/search-bar.jsp"/>
    <% if(!(boolean)request.getAttribute("get")){%>

    <h3>Search Result<%=!request.getAttribute("search_para").equals("")?" for '"+request.getAttribute("search_para")+"'":""%></h3>
    <%
        List<Patient> patients = (List<Patient>) request.getAttribute("list");
        int size = patients.size();
        boolean showAll = request.getParameter("showall")!=null && request.getParameter("showall").equals("true");
        boolean displayPartialResult = !showAll && size > 1000;
        if(displayPartialResult){
            request.setAttribute("list",patients.subList(0,1000));
        }

        if (patients != null && size !=0)
        {
    %>
        <p>Found <%=size%> matching results</p>
        <jsp:include page="/patient-list.jsp"/>
    <%
            if(displayPartialResult){%>
            <p style="padding: 30px">Showing first 1000 results, as showing all results might crash the browser. Try to narrow the search query.</p>
            <%}

        } else {%>
        <p>Nothing is found matching your criteria</p>
    <%}%>



</div>

<%}%>

<jsp:include page="/include/footer.jsp"/>
</body>
</html>
