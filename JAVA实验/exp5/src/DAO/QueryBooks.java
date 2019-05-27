package DAO;

import Table.TBookEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;

public class QueryBooks {

    public ArrayList queryBooksByPrice(double priceMin, double priceMax) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "from TBookEntity where bookprice >= :priceMin and bookprice <= :priceMax";
        Query query = session.createQuery(hql);
        query.setParameter("priceMin",priceMin);
        query.setParameter("priceMax",priceMax);
        ArrayList books = (ArrayList) query.list();
        session.close();
        return books;
    }

    public ArrayList queryBooksByNameAndPrice(String bookName, double maxPrice) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<TBookEntity> criteria = criteriaBuilder.createQuery(TBookEntity.class);
        Root<TBookEntity> root = criteria.from(TBookEntity.class);
        criteria.where(criteriaBuilder.and(criteriaBuilder.like(root.get("bookname"),"%" + bookName + "%"),criteriaBuilder.le(root.get("bookprice"),maxPrice)));
        ArrayList<TBookEntity> books = (ArrayList) session.createQuery(criteria).list();
        session.close();
        return books;
    }
}
