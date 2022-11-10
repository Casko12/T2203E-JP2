package Exam.student.list;

import Assignment1.entities.Book;
import Exam.dao.impls.StudentRepository;
import Exam.entities.Student;
import Exam.enums.RepositoryType;
import Exam.factory.RepositoryFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<Student> tbstudents;
    public TableColumn <Student,String> tdId;
    public TableColumn <Student,String> tdName;
    public TableColumn <Student,String> tdAddress;
    public TableColumn <Student,String> tdPhone;
    public TableColumn <Student, Button> tdEdit;
    public static ObservableList<Student> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        tdAddress.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));
        tdPhone.setCellValueFactory(new PropertyValueFactory<Student, String>("phone"));
        tdEdit.setCellValueFactory(new PropertyValueFactory<Student, Button>("edit"));
        ObservableList<Student> = (StudentRepository) RepositoryFactory.createRepository(RepositoryType.STUDENT);
    }

    public void addStudent(ActionEvent actionEvent) {
    }
}
