package Table;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T_BOOK", schema = "books")
public class TBook {
    private String bookid;
    private String bookname;
    private Double bookprice;

    @Id
    @Column(name = "BOOKID")
    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    @Basic
    @Column(name = "BOOKNAME")
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Basic
    @Column(name = "BOOKPRICE")
    public Double getBookprice() {
        return bookprice;
    }

    public void setBookprice(Double bookprice) {
        this.bookprice = bookprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TBook tBook = (TBook) o;
        return Objects.equals(bookid, tBook.bookid) &&
                Objects.equals(bookname, tBook.bookname) &&
                Objects.equals(bookprice, tBook.bookprice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookid, bookname, bookprice);
    }
}
