package Action;

import DAO.QueryBooks;
import Table.TBookEntity;
import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.Map;

public class searchBooksByNameAction {

    private String bookName;
    private Double maxPrice;

    public String execute() {
        QueryBooks queryBooks = new QueryBooks();
        ArrayList<TBookEntity> books = null;
        books = queryBooks.queryBooksByNameAndPrice(bookName,maxPrice);
        Map session = ActionContext.getContext().getSession();
        session.put("books",books);
        return "success";
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }
}
