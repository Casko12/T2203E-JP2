package Assignment1.dao.interfaces;

import Assignment1.entities.Book;
import Assignment1.entities.Student;

import java.util.ArrayList;

public interface StudentInterface {
    ArrayList<Student> all();
    boolean create(Student student);
    boolean update(Student student);
    boolean delete(Student student);
}
