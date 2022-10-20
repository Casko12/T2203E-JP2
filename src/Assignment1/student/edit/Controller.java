package Assignment1.student.edit;

import Assignment1.Main;
import Assignment1.entities.Book;
import Assignment1.entities.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField txtStName;
    public TextField txtStEmail;
    public TextField txtStPhone;
    public static Student editedStudent;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(editedStudent != null){
            txtStName.setText(editedStudent.getName());
            txtStEmail.setText(editedStudent.getEmail());
            txtStPhone.setText(editedStudent.getPhone());
        }
    }

    public void submit(ActionEvent actionEvent) {

    }

    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../list/StudentList.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.rootStage.setTitle("Book List");
        Main.rootStage.setScene(listScene);
    }

    public void delete(ActionEvent actionEvent) {
    }
}
