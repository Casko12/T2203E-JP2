package Assignment1.BookManagement.form;

import Assignment1.helper.Connector;
import Assignment1.Main;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.ArrayList;


public class Controller {
    public TextField txtBookName;
    public TextField txtBookAuthor;
    public TextField txtBookQty;

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtBookName.getText();
            String author = txtBookAuthor.getText();
            Integer qty = Integer.parseInt(txtBookQty.getText());
            String sql_txt = "insert into books(name,author,qty) " +
                    "values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(name);
            arr.add(author);
            arr.add(qty);

            if (conn.execute(sql_txt, arr)) {
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

