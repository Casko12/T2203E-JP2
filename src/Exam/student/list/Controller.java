package Exam.student.list;

import Exam.Main;
import Exam.dao.impls.StudentRepository;
import Exam.entities.Student;
import Exam.enums.RepositoryType;
import Exam.factory.RepositoryFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<Student> tbStudents;
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
        tbStudents.setItems(Controller.list);

    }

    public void addStudent(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../add/AddStudent.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Add Student");
        Main.rootStage.setScene(listScene);
    }
}
