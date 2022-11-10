package Assignment1.BookRent.form;

import Assignment1.Main;
import Assignment1.dao.impls.BookRepository;
import Assignment1.dao.impls.StudentRepository;
import Assignment1.dao.impls.BookRentRepository;
import Assignment1.entities.Book;
import Assignment1.entities.BookRent;
import Assignment1.entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public ComboBox <Book> cbBook;
    public ComboBox <Student> cbStudent;
    public DatePicker dpExpire;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookRepository rp = new BookRepository();
        ObservableList <Book> ls= FXCollections.observableArrayList();
        ls.addAll(rp.all());
        cbBook.setItems(ls);
        StudentRepository srp = new StudentRepository();
        ObservableList <Student> sls = FXCollections.observableArrayList();
        sls.addAll(srp.all());
        cbStudent.setItems(sls);
    }

    public void Submit(ActionEvent actionEvent) {
//        try{
//            Book selectedBook = cbBook.getSelectionModel().getSelectedItem();
//            Student selectedStudent = cbStudent.getSelectionModel().getSelectedItem();
//            LocalDate dp = dpExpire.getValue();
//            BookRent bookRent = new BookRent(null, selectedBook.id, selectedStudent.id,dp ,null,null);
//            BookRentRepository brp = new BookRentRepository();
//            if (brp.create(bookRent)){
//                backToList(null);
//            } else {
//                System.out.println("Error!");
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
    }

    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../list/BookRentList.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Rent List");
        Main.rootStage.setScene(listScene);
    }
}
