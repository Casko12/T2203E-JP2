package Assignment1.BookManagement.list;

import Assignment1.dao.impls.BookRepository;
import Assignment1.Main;
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
import Assignment1.entities.Book;
import java.net.URL;
import java.util.ResourceBundle;
public class Controller implements Initializable {
    public TableView<Book> tbBooks;
    public TableColumn<Book, Integer> tdId;
    public TableColumn<Book, String> tdName;
    public TableColumn<Book, String> tdAuthor;
    public TableColumn<Book, Integer> tdQty;
    public TableColumn<Book, Button> tdEdit;
    public static ObservableList<Book> list = FXCollections.observableArrayList();

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        tdAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        tdQty.setCellValueFactory(new PropertyValueFactory<Book, Integer>("qty"));
        tdEdit.setCellValueFactory(new PropertyValueFactory<Book,Button>("edit"));
        ObservableList<Book> ls = FXCollections.observableArrayList();
        // lay data tu database
        BookRepository rp = new BookRepository();
        ls.addAll(rp.all());
        tbBooks.setItems(ls);
    }
    public void backToHome(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("/Assignment1/Home.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(listScene);
    }

    public void addBook(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../form/FormBook.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Add Book");
        Main.rootStage.setScene(listScene);
    }

}
