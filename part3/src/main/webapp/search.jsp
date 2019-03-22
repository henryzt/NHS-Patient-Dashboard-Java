<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.ModelFactory" %>

<html>
    <head>
        <jsp:include page="/include/meta.jsp"/>
        <title>Patient Search</title>
    </head>
    <body>
        <jsp:include page="/include/header.jsp"/>

        <div class="main">
            <jsp:include page="/component/search-bar.jsp"/>
            <% if(!(boolean)request.getAttribute("get")){
                //check whether this page is called using post instead of get, thus contain search results
                if(request.getParameter("page") == null){
                    //user searched instead of using pagination, update session info
                    session.setAttribute("list", request.getAttribute("list"));
                    session.setAttribute("para",request.getAttribute("search_para"));
                }
                List<Patient> patients = (List<Patient>) session.getAttribute("list");
                if (patients != null) {
                    String para = (String) session.getAttribute("para");
                    ModelFactory.pageDivider(request, patients);
                    //divide pages according to page parameter
            %>
                    <h3>Search Result<%=(para != null && !para.equals("")) ? " for '" + para + "'" : ""%></h3>
                    <jsp:include page="/component/patient-list.jsp"/>

            <%
                } else {
            %>
                    <h4>Sorry, nothing is found matching your criteria.</h4>
            <%
                }
            }%>
        </div>

        <jsp:include page="/include/footer.jsp"/>
    </body>
</html>
