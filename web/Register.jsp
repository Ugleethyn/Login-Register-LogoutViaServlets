<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Simple Login Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet"/>
    <% if (session.getAttribute("user") != null) {
        response.sendRedirect("main.jsp");
    }%>
</head>
<body>
<div class="login-form">
    <form action="doRegister" method="POST">
        <h2 class="text-center">Log in</h2>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Username" name="username">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" placeholder="Password" name="pass1">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" placeholder="Repeat Password" name="pass2">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="First Name" name="firstname">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Last Name" name="lastname">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Register</button>
        </div>
        <%if (request.getAttribute("errormessage") != null) {%>
        <p>${errormessage}</p>
        <%}%>
    </form>
</div>
</body>
</html>             	