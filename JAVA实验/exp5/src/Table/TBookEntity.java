package Table;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T_BOOK", schema = "books")
public class TBookEntity {
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
        TBookEntity that = (TBookEntity) o;
        return Objects.equals(bookid, that.bookid) &&
                Objects.equals(bookname, that.bookname) &&
                Objects.equals(bookprice, that.bookprice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookid, bookname, bookprice);
    }
}
