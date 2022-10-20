package Assignment1.student.list;

import Assignment1.Main;
import Assignment1.dao.impls.StudentRepository;
import Assignment1.entities.Student;
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
    public TableColumn<Student, Integer> stID;
    public TableColumn<Student, String> stName;
    public TableColumn<Student, String> stEmail;
    public TableColumn<Student, String> stPhone;
    public TableColumn<Student, Button> stEdit;

    public static ObservableList<Student> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stID.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        stName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        stEmail.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        stPhone.setCellValueFactory(new PropertyValueFactory<Student, String>("phone"));
        stEdit.setCellValueFactory(new PropertyValueFactory<Student,Button>("edit"));
        ObservableList<Student> ls = FXCollections.observableArrayList();
        StudentRepository rp = new StudentRepository();
        ls.addAll(rp.all());
        tbStudents.setItems(ls);
    }

    public void backToHome(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("/Assignment1/Home.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(listScene);
    }
    public void addStudent(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../form/FormStudent.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Add Student");
        Main.rootStage.setScene(listScene);
    }
}

