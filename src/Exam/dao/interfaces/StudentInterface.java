package Exam.dao.interfaces;
import java.util.ArrayList;

public interface StudentInterface <S> {
    ArrayList<S> all();
    boolean create(S s);
    boolean update(S s);
    boolean delete(S s);
}
