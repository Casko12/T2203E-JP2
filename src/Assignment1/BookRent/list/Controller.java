package Assignment1.BookRent.list;

import Assignment1.Main;
import Assignment1.dao.impls.BookRentRepository;
import Assignment1.entities.BookRent;
import Assignment1.enums.RepositoryType;
import Assignment1.factory.RepositoryFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TableView <BookRent> tbRents;
    public TableColumn <BookRent, Integer> tdId;
    public TableColumn<BookRent, String> tdBook;
    public TableColumn<BookRent, String> tdStudent;
    public TableColumn <BookRent, Date> tdRentDate;
    public TableColumn <BookRent,Date> tdExpiredDate;
    public TableColumn<BookRent, Integer> tdStatus;
    public TableColumn tdAction;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tdBook.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        tdStudent.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        tdRentDate.setCellValueFactory(new PropertyValueFactory<>("rentDate"));
        tdExpiredDate.setCellValueFactory(new PropertyValueFactory<>("expiredDate"));
        tdStatus.setCellValueFactory(new PropertyValueFactory<>("statusLabel"));
        BookRentRepository brr = (BookRentRepository)RepositoryFactory.createRepository(RepositoryType.BOOKRENT);
        tbRents.getItems().addAll(brr.all());
    }

    public void backToHome(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("/Assignment1/Home.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(listScene);
    }

    public void addRent(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../form/BookRentForm.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("New Rent");
        Main.rootStage.setScene(listScene);
    }
}
