package Assignment1.factory;

import Assignment1.dao.impls.BookRentRepository;
import Assignment1.dao.impls.BookRepository;
import Assignment1.dao.impls.StudentRepository;
import Assignment1.dao.interfaces.IRepository;
import Assignment1.enums.RepositoryType;

public class RepositoryFactory {
    private RepositoryFactory(){
    }
    public static IRepository createRepository(RepositoryType type){
        switch (type){
            case BOOK: return new BookRepository();
            case BOOKRENT: return new BookRentRepository();
            case STUDENT: return new StudentRepository();
            default: throw new IllegalArgumentException("Thiếu tham số!");
        }
    }
}
