package Assignment1.dao.interfaces;

import Assignment1.entities.Book;

import java.util.ArrayList;

public interface IBookRepository {
    ArrayList<Book> all();
    boolean create(Book book);
    boolean update(Book book);
    boolean delete(Book book);
    Book findOne (Integer id);
}
