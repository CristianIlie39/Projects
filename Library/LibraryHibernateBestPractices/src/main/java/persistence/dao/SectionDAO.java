package persistence.dao;

import config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Section;

import javax.persistence.Query;
import java.util.List;

@Repository
public class SectionDAO {

    public void insert(Section section) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(section);
        session.getTransaction().commit();
        session.close();
    }

    public List<Section> findByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findSectionByNameQuery = session.createNamedQuery("findSectionByName");
        findSectionByNameQuery.setParameter("name", name);
        List<Section> sectionList = findSectionByNameQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return sectionList;
    }

}
