package Assignment1.dao.impls;

import Assignment1.dao.interfaces.StudentInterface;
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
        try{
            String sql_txt = "insert into students(name,email,phone) " +
                    "values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList<>();
            arr.add(student.getName());
            arr.add(student.getEmail());
            arr.add(student.getPhone());

            if (conn.execute(sql_txt, arr)) {
            }    return true;
        }catch (Exception e){
        }
            return false;
    }

    @Override
    public boolean update(Student student) {
        try {
            String sql_txt = "update students set name=?, email=?,phone=? where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getName());
            arr.add(student.getEmail());
            arr.add(student.getPhone());
            arr.add(student.getId());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        try {
            String sql_txt = "delete from students where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getId());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
        }
        return false;
    }
}
