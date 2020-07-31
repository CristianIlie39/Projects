package persistence.dao;

import org.hibernate.Session;
import persistence.entities.Person;

public class PersonDAO {

    //facem metoda de insert persoana
    public void insert(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }
}
