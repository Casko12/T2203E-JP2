package Assignment1.dao.interfaces;

import Assignment1.BookManagement.Book;

import java.util.ArrayList;

public interface IBookRepository {
    ArrayList<Book> all();
    boolean create(Book book);
    boolean update(Book book);
    boolean delete(Book book);

}
