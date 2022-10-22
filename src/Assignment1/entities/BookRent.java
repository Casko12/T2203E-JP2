package Assignment1.entities;

import Assignment1.dao.impls.BookRepository;
import Assignment1.dao.impls.StudentRepository;
import Assignment1.enums.RepositoryType;
import Assignment1.factory.RepositoryFactory;

import java.util.Date;

public class BookRent {
    private Integer id;
    private Integer bookId;
    private Integer studentId;
    private Date rentDate;
    private Date expireDate;
    private Integer status;

    public BookRent(Integer id, Integer bookId, Integer studentId, Date rentDate, Date expireDate, Integer status) {
        this.id = id;
        this.bookId = bookId;
        this.studentId = studentId;
        this.rentDate = rentDate;
        this.expireDate = expireDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Book book(){
        return ((BookRepository) RepositoryFactory.createRepository(RepositoryType.BOOK)).findOne(this.getBookId());
    }
    public Student student(){
        return ((StudentRepository) RepositoryFactory.createRepository(RepositoryType.STUDENT)).findOne(this.getStudentId());
    }
}
