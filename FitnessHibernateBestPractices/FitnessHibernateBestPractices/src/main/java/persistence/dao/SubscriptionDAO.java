package persistence.dao;

import org.hibernate.Session;
import persistence.entities.Subscription;

public class SubscriptionDAO {

    //facem metoda de insert abonament
    public void insert(Subscription subscription) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(subscription);
        session.getTransaction();
        session.close();
    }
}
