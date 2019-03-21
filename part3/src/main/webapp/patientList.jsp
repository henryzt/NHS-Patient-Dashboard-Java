<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
      <jsp:include page="/include/meta.jsp"/>
      <title>Patient List</title>
    </head>
    <body>
        <jsp:include page="/include/header.jsp"/>

              <h3>All Patients</h3>

              <jsp:include page="/component/patient-list.jsp"/>
              <jsp:include page="/component/search-bar.jsp"/>

         <jsp:include page="/include/footer.jsp"/>
    </body>
</html>
