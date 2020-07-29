package persistence.dao;

import org.hibernate.Session;
import persistence.entities.Teacher;
import javax.persistence.Query;
import java.util.List;

public class TeacherDAO {

    public void insert(Teacher teacher) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();
    }

    public List<Teacher> findByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTeacherByName = session.createNamedQuery("findTeacherByName");
        findTeacherByName.setParameter("name", name);
        List<Teacher> teacherList = findTeacherByName.getResultList();
        session.getTransaction().commit();
        session.close();
        return teacherList;
    }

    public List<Teacher> findByAge(int age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findTeacherByAge = session.createNamedQuery("findTeacherByAge");
        findTeacherByAge.setParameter("age", age);
        List<Teacher> teacherList = findTeacherByAge.getResultList();
        session.getTransaction().commit();
        session.close();
        return teacherList;
    }

    public void deleteByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteTeacherByName = session.createNamedQuery("deleteTeacherByName");
        deleteTeacherByName.setParameter("name", name);
        deleteTeacherByName.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void deleteByAge(int age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteTeacherByAge = session.createNamedQuery("deleteTeacherByAge");
        deleteTeacherByAge.setParameter("age", age);
        deleteTeacherByAge.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

}
