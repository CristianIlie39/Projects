package persistence.dao;

import org.hibernate.Session;
import persistence.entities.Group;
import javax.persistence.Query;
import java.util.List;



public class GroupDAO {

    public void insert(Group group) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(group);
        session.getTransaction().commit();
        session.close();
    }

    public List<Group> findByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findGroupByName = session.createNamedQuery("findGroupByName");
        findGroupByName.setParameter("name", name);
        List<Group> groupList = findGroupByName.getResultList();
        session.getTransaction().commit();
        session.close();
        return groupList;
    }

}
