package services;

import models.Book;
import repositories.BookRepository;

import java.util.List;

public class BookService {

    private BookRepository bookRepository = BookRepository.getInstance();

    private static BookService bookService = new BookService();

    private BookService() {
    }

    public static BookService getInstance() {
        return bookService;
    }


    public List<Book> getAllBooks() {
        return bookRepository.getBooks();
    }

}
