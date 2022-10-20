package Assignment1.student.edit;

import Assignment1.Main;
import Assignment1.dao.impls.StudentRepository;
import Assignment1.entities.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Optional;
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

    public void submit(ActionEvent actionEvent) {try {
        String name = txtStName.getText();
        String email = txtStEmail.getText();
        String phone = txtStPhone.getText();
        editedStudent.setName(name);
        editedStudent.setEmail(email);
        editedStudent.setPhone(phone);
        StudentRepository rp = new StudentRepository();
        if(rp.update(editedStudent)){
            backToList(null);
        }else {
            System.out.println("Error!");
        }
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
    }

    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../list/StudentList.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.rootStage.setTitle("Student List");
        Main.rootStage.setScene(listScene);
    }

    public void delete(ActionEvent actionEvent) {
        try{
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Student?");
            alert.setHeaderText("Are you sure to delete student: "+editedStudent.getName());
            Optional<ButtonType> option = alert.showAndWait();

            if(option.get() == ButtonType.OK){
                StudentRepository rp = new StudentRepository();
                if(rp.delete(editedStudent)){
                    backToList(null);
                }else {
                    System.out.println("Error");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
