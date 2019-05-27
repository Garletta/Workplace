package Action;

import DAO.BookDao;
import Table.TBook;
import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.Map;

public class deleteBookAction {

    private String bookID = "";
    private BookDao bookDao;

    public String execute() {
        ArrayList<TBook> list = bookDao.deleteBookByID(bookID);
        Map session = ActionContext.getContext().getSession();
        session.put("list",list);
        return "success";
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
