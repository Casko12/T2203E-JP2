package Assignment1.BookManagement.list;

import Assignment1.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Assignment1.BookManagement.Book;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
public class Controller implements Initializable {
    public TableView<Book> tbBooks;
    public TableColumn<Book, Integer> tdId;
    public TableColumn<Book, String> tdName;
    public TableColumn<Book, String> tdAuthor;
    public TableColumn<Book, Integer> tdQty;
    public final static String connectionString ="jdbc:mysql://localhost:3306/t2203e";
    public final static String user ="root";
    public final static String pwd =""; //voi xampp password de trong, mampp thi de pwd = "root"
    public static ObservableList<Book> list = FXCollections.observableArrayList();

    @Override
    public void initialize (URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        tdAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        tdQty.setCellValueFactory(new PropertyValueFactory<Book, Integer>("qty"));

        ObservableList<Book> ls = FXCollections.observableArrayList();
        // lay data tu database
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString, user, pwd);
            Statement statement = conn.createStatement();
            String sql_txt = "select * from books";
            ResultSet rs = statement.executeQuery(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int qty = rs.getInt("qty");
                Book b = new Book(id, name, author, qty);
                ls.add(b);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbBooks.setItems(ls);
        }
    }
    public void backToHome(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("/Assignment1/Home.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setScene(listScene);
    }

}
