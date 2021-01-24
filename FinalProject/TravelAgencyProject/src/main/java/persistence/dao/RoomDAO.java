package persistence.dao;

import persistence.config.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import persistence.entities.Room;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RoomDAO {

    //nu am facut metoda de insert deoarece inserez camerele din hotel

    public Room findAvailableRoomByTypeAndByExtrabedAndByHotel(String roomType, boolean extraBed, String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findRoomQuery = session.createNamedQuery("findAvailableRoomByTypeAndByExtraBedAndByHotel");
        findRoomQuery.setParameter("roomType", roomType);
        findRoomQuery.setParameter("extraBed", extraBed);
        findRoomQuery.setParameter("name", name);
        Room roomFound = null;
        try {
            roomFound = (Room) findRoomQuery.getSingleResult();
        } catch (NoResultException exception) {
            System.out.println(exception.getMessage());
        }
        session.getTransaction().commit();
        session.close();
        return roomFound;
    }

    public Room findRoomByTypeAndByHotel(String roomType, String hotelName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findRoomQuery = session.createNamedQuery("findRoomByTypeAndByHotel");
        findRoomQuery.setParameter("roomType", roomType);
        findRoomQuery.setParameter("hotelName", hotelName);
        Room roomFound = null;
        try {
            roomFound = (Room) findRoomQuery.getSingleResult();
        } catch (NoResultException exception) {
            System.out.println(exception.getMessage());
        }
        session.getTransaction().commit();
        session.close();
        return roomFound;
    }

    public List<Room> findRoomByExtraBedAndByHotel(boolean extraBed, String hotelName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findRoomQuery = session.createNamedQuery("findRoomByExtraBedAndByHotel");
        findRoomQuery.setParameter("extraBed", extraBed);
        findRoomQuery.setParameter("hotelName", hotelName);
        List<Room> roomList = findRoomQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return roomList;
    }

    public List<Room> findAllRoomsByHotel(String hotelName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query findAllRoomsQuery = session.createNamedQuery("findAllRoomsByHotel");
        findAllRoomsQuery.setParameter("hotelName", hotelName);
        List<Room> roomList = findAllRoomsQuery.getResultList();
        session.getTransaction().commit();
        session.close();
        return roomList;
    }

    public int updateRoomByTypeAndByHotel(int availableRooms, String roomType, String hotelName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateAvailableRoomsQuery = session.createNamedQuery("updateRoomByTypeAndByHotel");
        updateAvailableRoomsQuery.setParameter("availableRooms", availableRooms);
        updateAvailableRoomsQuery.setParameter("roomType", roomType);
        updateAvailableRoomsQuery.setParameter("hotelName", hotelName);
        int numberOfRoomsUpdated = updateAvailableRoomsQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return numberOfRoomsUpdated;
    }

    //am creat metoda pt updatarea camerelor disponibile in functie de tipul camerei, dintr-un anumit hotel
    public void updateAvailableRooms(int roomNumber, String roomType, String hotelName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query updateAvailableRoomsQuery = session.createNamedQuery("updateAvailableRooms");
        updateAvailableRoomsQuery.setParameter("roomNumber", roomNumber);
        updateAvailableRoomsQuery.setParameter("roomType", roomType);
        updateAvailableRoomsQuery.setParameter("hotelName", hotelName);
        updateAvailableRoomsQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public int deleteRoomByTypeAndByHotel(String roomType, String hotelName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query deleteRoomQuery = session.createNamedQuery("deleteRoom");
        deleteRoomQuery.setParameter("roomType", roomType);
        deleteRoomQuery.setParameter("hotelName", hotelName);
        int numberOfRoomsDeleted = deleteRoomQuery.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return numberOfRoomsDeleted;
    }



}
