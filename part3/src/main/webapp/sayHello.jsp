
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Hello from the JSP</title>
</head>
<body>
  <h1>Hello from the Java Server Page!</h1>
  <%
    String message = "This is a message in a Java String";
  %>
  <p><%=message%></p>
</body>
</html>
