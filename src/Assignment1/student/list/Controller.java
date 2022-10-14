package Assignment1.student.list;

import Assignment1.BookManagement.Book;
import Assignment1.student.Student;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controller implements Initializable {
    public TableView <Student> tbStudents;
    public TableColumn <Student, Integer> stID;
    public TableColumn<Student, String> stName;
    public TableColumn<Student, String> stEmail;
    public TableColumn<Student, String> stPhone;

}
