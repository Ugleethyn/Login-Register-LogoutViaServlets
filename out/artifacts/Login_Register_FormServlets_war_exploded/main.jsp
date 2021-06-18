<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <% if (session.getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
    }
%>
</head>
<body>
<div style="text-align: center">
    <h1>Hello from the other side</h1>
    <b> ${sessionScope.user.username}</b>
    <br><br>
    <a href="logout">Logout</a>

    <c:set var = "books" value = "${books}" />
    ${fn:length(books)}

    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.bookName}</td>
            <td>${book.bookIdentifier}</td>
            <td>${book.description}</td>
        </tr>
    </c:forEach>
</div>
</body>
</html>
