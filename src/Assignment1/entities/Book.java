package Assignment1.entities;

import Assignment1.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import Assignment1.BookManagement.edit.Controller;



public class Book {
    public Integer id;
    public String name;
    public String author;
    public Integer qty;
    public Button edit;

    public Book() {
    }

    public Book(Integer id, String name, String author, Integer qty) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.qty = qty;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event) -> {
            try{
                Controller.editedBook = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../BookManagement/edit/FormBookEdit.fxml"));
                Main.rootStage.setScene( new Scene(edit,800,600));
                Main.rootStage.setTitle("Edit Book");
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Button getEdit() {
        return edit;
    }

    @Override
    public String toString() {
        return getName();
    }
}
