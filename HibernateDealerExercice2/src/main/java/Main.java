import entities.Car;
import entities.Customer;
import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Main {

    //Introducem o masina in baza de date
    //Introducem un client in baza de date

    public static void main(String[] args) {

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        Session session = metadata.getSessionFactoryBuilder().build().openSession();

        session.beginTransaction();
        Car car = new Car("Mercedes", "GLC", 2019, "black", "benzina", 4);
        session.save(car);
        session.getTransaction().commit();

        session.beginTransaction();
        Customer customer = new Customer("Marculescu", "Stefan", 48, "Galati", 5);
        session.save(customer);
        session.getTransaction().commit();

        session.close();

    }

}
