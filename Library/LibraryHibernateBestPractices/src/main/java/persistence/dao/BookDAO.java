package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Book;

import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDAO {

    public void insert(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    public List<Book> findByTitle(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findBookByTitleQuery = session.createNamedQuery("findBookByTitle");
        findBookByTitleQuery.setParameter("title", title);
        List<Book> bookList = findBookByTitleQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return bookList;
    }

    public List<Book> findByBorrowed(boolean borrowed) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findByBorrowedQuery = session.createNamedQuery("findBookByBorrowed");
        findByBorrowedQuery.setParameter("borrowed", borrowed);
        List<Book> bookList = findByBorrowedQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return bookList;
    }

    public List<Book> findByAuthor(String authorSurname) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findByAuthorQuery = session.createNamedQuery("findBookByAuthor");
        findByAuthorQuery.setParameter("surname", authorSurname);
        List<Book> bookList = findByAuthorQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return bookList;
    }

}
