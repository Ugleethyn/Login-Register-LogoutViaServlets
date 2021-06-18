package controllers;

import models.User;
import services.BookService;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doLogin")
public class LoginServlet extends HttpServlet {

    private UserService userService = UserService.getInstance();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User loggedInUser = userService.login(request.getParameter("username"), request.getParameter("password"), request);
        RequestDispatcher rd = request.getRequestDispatcher(userService.handleLoginPage(request));
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
