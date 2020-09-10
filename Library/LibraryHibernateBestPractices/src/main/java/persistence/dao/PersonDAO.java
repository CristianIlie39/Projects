package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Person;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonDAO {

    public void insert(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    public List<Person> findByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findPersonBySurnameQuery = session.createNamedQuery("findPersonBySurname");
        findPersonBySurnameQuery.setParameter("surname", name);
        List<Person> personList = findPersonBySurnameQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return personList;
    }

    public List<Person> findByAge(int age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findPersonByAgeQuery = session.createNamedQuery("findPersonByAge");
        findPersonByAgeQuery.setParameter("age", age);
        List<Person> personList = findPersonByAgeQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return personList;
    }
}


