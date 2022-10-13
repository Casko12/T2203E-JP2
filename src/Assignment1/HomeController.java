package Assignment1;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;




public class HomeController {
    public void goToBookList(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("Assignment1/BookManagement/list/BookList.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.rootStage.setTitle("Book List");
        Main.rootStage.setScene(listScene);
    }

    public void goToMemberList(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("Assignment1/MemberManagement/list/MemberList.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.rootStage.setTitle("Member List");
        Main.rootStage.setScene(listScene);
    }
    public void goToBorrowList(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("Assignment1/BookBorrow/list/BookBorrowList.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Book Borrow List");
        Main.rootStage.setScene(listScene);
    }
}
