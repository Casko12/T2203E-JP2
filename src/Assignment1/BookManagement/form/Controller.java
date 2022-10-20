package Assignment1.BookManagement.form;

import Assignment1.entities.Book;
import Assignment1.dao.impls.BookRepository;
import Assignment1.Main;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Controller {
    public TextField txtBookName;
    public TextField txtBookAuthor;
    public TextField txtBookQty;

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtBookName.getText();
            String author = txtBookAuthor.getText();
            Integer qty = Integer.parseInt(txtBookQty.getText());
            Book book = new Book( null, name, author, qty);
            BookRepository rp = new BookRepository();
            if (rp.create(book)){
                backToList(null);
            } else {
                System.out.println("Error!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void backToList(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("../list/BookList.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.rootStage.setTitle("Book List");
        Main.rootStage.setScene(listScene);
    }
}

