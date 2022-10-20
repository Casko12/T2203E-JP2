package Assignment1.BookManagement.edit;

import Assignment1.entities.Book;
import Assignment1.Main;
import Assignment1.dao.impls.BookRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField txtBookName;
    public TextField txtBookAuthor;
    public TextField txtBookQty;

    public static Book editedBook;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(editedBook != null){
            txtBookName.setText(editedBook.getName());
            txtBookAuthor.setText(editedBook.getAuthor());
            txtBookQty.setText(editedBook.getQty().toString());
        }
    }
    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtBookName.getText();
            String author = txtBookAuthor.getText();
            Integer qty = Integer.parseInt(txtBookQty.getText());
            editedBook.setName(name);
            editedBook.setAuthor(author);
            editedBook.setQty(qty);
            BookRepository rp = new BookRepository();
            if(rp.update(editedBook)){
                backToList(null);
            }else {
                System.out.println("Error!");
            }
        }catch (Exception e){
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
