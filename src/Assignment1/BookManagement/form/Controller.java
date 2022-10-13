package Assignment1.BookManagement.form;

import Assignment1.Main;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Controller {
    public TextField txtBookID;
    public TextField txtBookName;

    public void backToList(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("Assignment1/BookManagement/list/BookList.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.rootStage.setTitle("Book List");
        Main.rootStage.setScene(listScene);
    }

//    public void submit(ActionEvent actionEvent) {
//        try{
//            int bookID = Integer.parseInt(txtBookID.getText());
//            if (txtBookName.getText().isEmpty() || bookID <=0 ){
//                throw new Exception("Please input data!");
//            }
//        }
//    }
}
