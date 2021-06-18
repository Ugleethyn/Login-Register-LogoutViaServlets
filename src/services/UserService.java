package services;

import models.User;
import repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserService {

    private UserRepository userRepository = UserRepository.getInstance();

    private static UserService userService = new UserService();

    private UserService() {
    }

    public static UserService getInstance() {
        return userService;
    }

    public User login(String username, String password, HttpServletRequest request) {
        User user = userRepository.login(username, password);
        if (user == null) {
            request.setAttribute("errormessage", "Invalid Password or username");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }

        return user;
    }

    public void register(String firstName, String lastName, String username,
                         String password, String confirmPassword, HttpServletRequest request) {
        if(userRepository.findByUsername(username) != null){
            request.setAttribute("errormessage", "This username already exists");
        }
        if (firstName.length() < 1 || lastName.length() < 1) {
            request.setAttribute("errormessage", "Please enter your names");
        } else if (username.length() < 1) {
            request.setAttribute("errormessage", "Please enter your Username");
        } else if (password.length() <= 3) {
            request.setAttribute("errormessage", "Your password have to be more than 3 letters");
        } else {
            if (password.equals(confirmPassword)) {
                userRepository.registerUser(new User(firstName, lastName, password, username));
            } else {
                request.setAttribute("errormessage", "Password don't match");
            }
        }
    }

    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
        } else {
            request.setAttribute("errormessage", "You are already logged out");
        }
    }


    public String handleRegisterPage(HttpServletRequest request) {
        if (request.getAttribute("errormessage") == null) {
            return "Login.jsp";
        } else {
            return "Register.jsp";
        }
    }

    public String handleLoginPage(HttpServletRequest request) {
        if (request.getAttribute("errormessage") == null) {
            return "BookServlet";
        } else {
            return "Login.jsp";
        }
    }

}
