package persistence.dao;

import org.hibernate.Session;
import persistence.entities.Student;
import javax.persistence.Query;
import java.util.List;

public class StudentDAO {

    public void insert(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

    public List<Student> findByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findStudentByName = session.createNamedQuery("findStudentByName");
        findStudentByName.setParameter("name", name);
        List<Student> studentList = findStudentByName.getResultList();
        session.getTransaction().commit();
        session.close();
        return studentList;
    }

    public List<Student> findByYear(int year) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findStudentByYear = session.createNamedQuery("findStudentByYear");
        findStudentByYear.setParameter("yearOfBirth", year);
        List<Student> studentList = findStudentByYear.getResultList();
        session.getTransaction().commit();
        session.close();
        return studentList;
    }

    public void deleteByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteStudentByName = session.createNamedQuery("deleteStudentByName");
        deleteStudentByName.setParameter("name", name);
        deleteStudentByName.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void deleteByYear(int year) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteStudentByYear = session.createNamedQuery("deleteStudentByYear");
        deleteStudentByYear.setParameter("yearOfBirth", year);
        deleteStudentByYear.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

}
