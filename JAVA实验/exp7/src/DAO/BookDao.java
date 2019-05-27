package DAO;

import Table.TBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class BookDao {

    private SessionFactory sessionFactory;

    public ArrayList queryBookByKeyWord(String bookName) {
        Session session = sessionFactory.openSession();
        String hql = "from TBook where bookname like :name";
        Query query = session.createQuery(hql);
        query.setParameter("name","%" + bookName + "%");
        ArrayList<TBook> books = (ArrayList<TBook>) query.list();
        session.close();
        return books;
    }

    public ArrayList deleteBookByID(String bookID) {
        Session session = sessionFactory.openSession();
        TBook book = session.get(TBook.class,bookID);
        if(book != null) {
            Transaction ts = session.beginTransaction();
            session.delete(book);
            ts.commit();
        }
        String hql = "from TBook";
        Query query = session.createQuery(hql);
        ArrayList<TBook> books = (ArrayList<TBook>) query.list();
        session.close();
        return books;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
