package Assignment1.dao.impls;

import Assignment1.dao.interfaces.StudentInterface;
import Assignment1.entities.Book;
import Assignment1.entities.Student;
import Assignment1.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentRepository implements StudentInterface {
    @Override
    public ArrayList<Student> all() {
        ArrayList <Student> ls = new ArrayList<>();
        try{
            String sql_txt = "select * from students";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Student s = new Student(id, name, email, phone);
                ls.add(s);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ls;
    }

    @Override
    public boolean create(Student student) {
        return false;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(Student student) {
        return false;
    }
}
