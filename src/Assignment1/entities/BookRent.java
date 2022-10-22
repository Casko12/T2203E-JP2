package Assignment1.entities;
import java.sql.Date;
import java.time.LocalDate;

public class BookRent {
    public Integer bookID;
    public String bookName;
    public Integer stID;
    public String stName;
    public Date dateRent;
    public Date dateReturn;

    public BookRent() {
    }

    public BookRent(Integer bookID, String bookName, Integer stID, String stName, Date dateRent, Date dateReturn) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.stID = stID;
        this.stName = stName;
        this.dateRent = dateRent;
        this.dateReturn = dateReturn;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getStID() {
        return stID;
    }

    public void setStID(Integer stID) {
        this.stID = stID;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public Date getDateRent() {
        return dateRent;
    }

    public void setDateRent(Date dateRent) {
        this.dateRent = dateRent;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }
}
