package Exam.entities;

import Assignment1.BookManagement.edit.Controller;
import Assignment1.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Student {
    public String id;
    public String name;
    public String address;
    public String phone;
    public Button edit;

    public Student() {
    }

    public Student(String id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event) -> {
            try{
                Controller.editedStudent = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../student/edit/EditStudent.fxml"));
                Main.rootStage.setScene( new Scene(edit,800,600));
                Main.rootStage.setTitle("Edit Book");
            }catch (Exception e){

            }
        });
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public void setEdit(Button edit) {
        this.edit = edit;
    }
}
