package controllers;

import models.User;
import repositories.UserRepository;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doRegister")
public class RegisterServlet extends HttpServlet {
    private UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        userService.register(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("username"), request.getParameter("pass1"), request.getParameter("pass2"), request);

        RequestDispatcher rd = request.getRequestDispatcher(userService.handleRegisterPage(request));
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
