package Assignment1.BookManagement.list;
import javafx.collections.FXCollections;
import Assignment1.BookManagement.Book;
import Assignment1.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import static Assignment1.Main.rootStage;

public class Controller implements Initializable {
    public TableView <Book> tv1;
    public static ObservableList<Book> list = FXCollections.observableArrayList();
    public static Book editItem;

    public void initialize (URL location, ResourceBundle resources) {
        tv1.setItems(list);
    }
    public void backtoHome(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("/Assignment1/Home.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.rootStage.setScene(listScene);
    }
    public void gotoForm(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("/Assignment1/BookManagement/form/FormBook.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.rootStage.setTitle("Add Book");
        Main.rootStage.setScene(listScene);
    }
    public void edit(ActionEvent actionEvent) throws Exception{
        editItem = tv1.getSelectionModel().getSelectedItem();
        if(editItem == null) return;
        Parent listPage = FXMLLoader.load(getClass().getResource("/Assignment1/BookManagement/edit/FormBookEdit.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.rootStage.setTitle("Edit Book");
        Main.rootStage.setScene(listScene);
    }
}
