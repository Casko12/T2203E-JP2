package Exam.dao.impls;

import Exam.dao.interfaces.StudentInterface;
import Exam.entities.Student;

import java.util.ArrayList;

public class StudentRepository implements StudentInterface<Student> {
    @Override
    public ArrayList<Student> all() {
        return null;
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
