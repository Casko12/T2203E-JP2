package Assignment1;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;




public class HomeController {
    public void goToBookList(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("BookManagement/list/BookList.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.rootStage.setTitle("Book List");
        Main.rootStage.setScene(listScene);
    }

    public void goToMemberList(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("student/list/StudentList.fxml"));
        Scene listScene = new Scene(listPage,800,600);
        Main.rootStage.setTitle("Student List");
        Main.rootStage.setScene(listScene);
    }
    public void goToRentList(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("BookRent/list/BookRentList.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Book Borrow List");
        Main.rootStage.setScene(listScene);
    }
}
