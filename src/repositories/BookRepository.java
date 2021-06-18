package repositories;

import models.Book;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private static BookRepository bookRepository = new BookRepository();

    private BookRepository() {
    }

    public static BookRepository getInstance() {
        return bookRepository;
    }


    public List<Book> getBooks() {
        String query = "SELECT * FROM book";
        List<Book> allBooks = new ArrayList();
        ResultSet rs = null;

        try (Connection con = DBUtils.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book(rs.getInt("id"), rs.getString("bookName"), rs.getString("bookIdentifier"), rs.getString("description"));
                allBooks.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return allBooks;
    }

}
