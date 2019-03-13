
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Patient List</title>
</head>
<body>
  <h1></h1>
  <h1>More JSP</h1> <ul>
    <li>Current time: <%= new java.util.Date() %></li> <li>Server: <%= application.getServerInfo() %></li> <li>Session ID: <%= session.getId() %></li> <li>Path: <%= request.getPathInfo() %></li>
  </ul>

</body>
</html>
