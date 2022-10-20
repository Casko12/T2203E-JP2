package Assignment1.entities;

import Assignment1.student.edit.Controller;
import Assignment1.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Student {
    public Integer id;
    public String name;
    public String email;
    public String phone;
    public Button edit;


    public Student() {
    }

    public Student(Integer id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event) -> {
            try{
                Controller.editedStudent = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../student/edit/FormStudentEdit.fxml"));
                Main.rootStage.setScene( new Scene(edit,800,600));
            }catch (Exception e){

            }
        });
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Button getEdit() {
        return edit;
    }

    @Override
    public String toString() {
        return getName();
    }
}
