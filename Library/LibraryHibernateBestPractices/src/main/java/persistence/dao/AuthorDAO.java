package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Author;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

@Repository
public class AuthorDAO {

    public void insert(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
    }

    public List<Author> findByAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findByAllQuery = session.createNamedQuery("findByAll");
        List<Author> authorListByAll = findByAllQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return authorListByAll;
    }

    public List<Author> findBySurname(String surname) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findBySurnameQuery = session.createNamedQuery("findBySurname");
        findBySurnameQuery.setParameter("surname", surname);
        List<Author> authorListBySurname = findBySurnameQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return authorListBySurname;
    }

}
