package Exam.factory;

import Assignment1.enums.RepositoryType;
import Exam.dao.impls.StudentRepository;

public class RepositoryFactory {
    private RepositoryFactory(){
    }
    public static StudentRepository createRepository(RepositoryType type){
        switch (type){
            case STUDENT: return new StudentRepository();
            default: throw new IllegalArgumentException("Invalid!");
        }
    }
}
