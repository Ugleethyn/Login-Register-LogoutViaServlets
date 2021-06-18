package services;

import models.Book;
import repositories.BookRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BookService {

    private BookRepository bookRepository = BookRepository.getInstance();

    private static BookService bookService = new BookService();

    private BookService() {
    }

    public static BookService getInstance() {
        return bookService;
    }


    public void getAllBooks(HttpServletRequest req) {
        List<Book> books = bookRepository.getBooks();
        req.setAttribute("books",books);
    }

}
