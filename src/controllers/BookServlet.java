package controllers;

import repositories.BookRepository;
import services.BookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private BookService bookService = BookService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        bookService.getAllBooks(req);
        RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
        rd.forward(req, resp);

    }
}
