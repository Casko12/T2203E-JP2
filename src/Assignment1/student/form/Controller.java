package Assignment1.student.form;

import Assignment1.Main;
import Assignment1.entities.Student;
import Assignment1.dao.impls.StudentRepository;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Controller {
    public TextField txtStName;
    public TextField txtStEmail;
    public TextField txtStPhone;

    public void submit(ActionEvent actionEvent) {
        try{
            String name = txtStName.getText();
            String email = txtStEmail.getText();
            String phone = txtStPhone.getText();
            Student student = new Student(null, name, email, phone);
            StudentRepository rp = new StudentRepository();
            if (rp.create(student)) {
                backToList(null);
            } else {
                System.out.println("Error!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../list/StudentList.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Student List");
        Main.rootStage.setScene(listScene);
    }
}
