package Action;

import DAO.QueryBooks;
import Table.TBookEntity;
import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.Map;

public class searchBooksByPriceAction {

    private double priceMin;
    private double priceMax;

    public String execute() {
        QueryBooks queryBooks = new QueryBooks();
        ArrayList<TBookEntity> books = null;
        books = queryBooks.queryBooksByPrice(priceMin,priceMax);
        Map session = ActionContext.getContext().getSession();
        session.put("books",books);
        return "success";
    }

    public double getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(double priceMin) {
        this.priceMin = priceMin;
    }

    public double getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(double priceMax) {
        this.priceMax = priceMax;
    }
}
