package models;

import java.util.Objects;

public class Book {

    private Integer id;
    private String bookName;
    private String bookIdentifier;
    private String description;

    public Book(String bookName, String bookIdentifier, String description) {
        this.bookName = bookName;
        this.bookIdentifier = bookIdentifier;
        this.description = description;
    }

    public Book(Integer id, String bookName, String bookIdentifier, String description) {
        this.id = id;
        this.bookName = bookName;
        this.bookIdentifier = bookIdentifier;
        this.description = description;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookIdentifier() {
        return bookIdentifier;
    }

    public void setBookIdentifier(String bookIdentifier) {
        this.bookIdentifier = bookIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(bookName, book.bookName) &&
                Objects.equals(bookIdentifier, book.bookIdentifier) &&
                Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, bookIdentifier, description);
    }
}
