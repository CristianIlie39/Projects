package persistence.dao;

import org.hibernate.Session;
import persistence.entities.Workout;

public class WorkoutDAO {

    //facem metoda de insert antrenament
    public void insert(Workout workout) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(workout);
        session.getTransaction();
        session.close();
    }
}

