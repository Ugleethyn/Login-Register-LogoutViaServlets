<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% if (session.getAttribute("user") != null) {response.sendRedirect("main.jsp");}%>
    </head>
    <body>
        <p><a href="Login.jsp"> Login </a></p>
         <a href="Register.jsp"> Register </a>
    </body>
</html>
