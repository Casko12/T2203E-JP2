package Exam.student.add;

import Exam.Main;
import Exam.entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtPhone;
    public Text error;
    public static ObservableList <Student> listStudent = FXCollections.observableArrayList();
    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../list/StudentList.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Student List");
        Main.rootStage.setScene(listScene);
    }

    public void submit(ActionEvent actionEvent) {
        try{
            error.setVisible(false);
            if(txtId.getText().isEmpty()||txtName.getText().isEmpty()||txtAddress.getText().isEmpty()||txtPhone.getText().isEmpty()){
                throw new Exception("Please fill all the field!");
            }
            Student st = new Student(txtId.getText(),txtName.getText(),txtAddress.getText(),txtPhone.getText());
            listStudent.add(st);
            backToList(null);

        }catch (Exception e){
            error.setVisible(true);
            error.setText(e.getMessage());
        }
        
    }
}
