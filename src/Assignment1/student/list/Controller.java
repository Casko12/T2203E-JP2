package Assignment1.student.list;

import Assignment1.Main;
import Assignment1.student.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Assignment1.student.Student;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TableView<Student> tbStudents;
    public TableColumn<Student, Integer> stID;
    public TableColumn<Student, String> stName;
    public TableColumn<Student, String> stEmail;
    public TableColumn<Student, String> stPhone;
    public final static String connectionString = "jdbc:mysql://localhost:3306/t2203e";
    public final static String user = "root";
    public final static String pwd = "";
    public static ObservableList<Student> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stID.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        stName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        stEmail.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        stPhone.setCellValueFactory(new PropertyValueFactory<Student, String>("phone"));

        ObservableList<Student> ls = FXCollections.observableArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString, user, pwd);
            Statement statement = conn.createStatement();
            String sql_txt = "select * from students";
            ResultSet rs = statement.executeQuery(sql_txt);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Student s = new Student(id, name, email, phone);
                ls.add(s);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            tbStudents.setItems(ls);
        }
    }

    public void backToHome(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("/Assignment1/Home.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Home");
        Main.rootStage.setScene(listScene);
    }
    public void addStudent(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../form/FormStudent.fxml"));
        Scene listScene = new Scene(listPage, 800, 600);
        Main.rootStage.setTitle("Add Student");
        Main.rootStage.setScene(listScene);
    }
}

