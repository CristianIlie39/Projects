import entities.Department;
import entities.Employee;
import entities.Product;
import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import javax.persistence.Query;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /* Sa se modeleze o companie IT.
           Vom avea:
           - angajati: cu nume, prenume, adresa, varsta, nume departament, functie
           - departamente: nume, etajul, nr de angajati, nume sef departament
           - produse: nume, versiunea, numar de clienti, pret
           1. Sa se modeleze baza de date
           2. Sa se scrie un proiect Java care foloseste Hibernate
           3. Sa se salveze cel putin 10 angajati, 5 departamente, 5 produse
           4. Sa se stearga angajatii cu varsta > 65 ani
           5. Sa se stearga departamentele care nu au nici un angajat
           6. Sa se stearga produsele care au mai putin de 10 clienti
           7. Sa se mareasca pretul tuturor produselor cu 20%
           8. Sa se modifice functia angajatilor cu varsta intre 35 si 40 ani
           9. Sa se afiseze angajatii dintr-un anumit departament
           10. Sa se afiseze produsele care au mai mult de 200 de clienti
           11. Sa se afiseze etajul unui anumit departament
           12. Sa se afiseze departamentul si functia unui anumit angajat
           13. Sa se afiseze versiunea unui anumit produs

           Sa se documenteze despre proprietatile unei tranzactii (care este acronimul care defineste o tranzactie)
           Sa se exemplifice acest acronim (sa se foloseasca un exemplu care nu este pe internet). */

        //Inventar
        //avem nevoie de clasele entitati: Employee, Department si Product


        //Incarcam configurarile de Hibernate din fisierul hibernate.cfg.xml in memoria programului nostru cu ajutorul
        //obiectului de tip interfata ServiceRegistry
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        //Stocam in programul nostru diferitele proprietati din fisierul hibernate.cfg.xml cu ajutorul
        //obiectului de tip interfata Metadata
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        //Deschidem o sesiune de comunicare cu baza de date cu ajutorul obiectului de tip intefata Session
        Session session = metadata.getSessionFactoryBuilder().build().openSession();

        //3. Insert
        //Introducem 10 angajati in baza de date
        session.beginTransaction();
        Employee employee = new Employee("Stefan", "Nastase", "Bucuresti", 41, "production", "programmer");
        Employee employee2 = new Employee("Adrian", "Catoiu", "Galati", 43, "HR", "recruiter");
        session.save(employee);
        session.save(employee2);
        session.getTransaction().commit();

        session.beginTransaction();
        Employee employee3 = new Employee("Catalina", "Popa", "Braila", 45, "production", "programmer");
        Employee employee4 = new Employee("Marcel", "Tudose", "Iasi", 35, "sales", "agent");
        session.save(employee3);
        session.save(employee4);

        session.getTransaction().commit();

        session.beginTransaction();
        Employee employee5 = new Employee("Gabriela", "Popescu", "Cluj-Napoca", 25, "sales", "advisor");
        Employee employee6 = new Employee("Violeta", "Nichifor", "Bucuresti", 50, "legal", "lawyer");
        session.save(employee5);
        session.save(employee6);
        session.getTransaction().commit();

        session.beginTransaction();
        Employee employee7 = new Employee("Alina", "Iancu", "Timisoara", 49, "financial", "accountant");
        Employee employee8 = new Employee("Andrei", "Marinescu", "Galati", 28, "production", "tester");
        session.save(employee7);
        session.save(employee8);
        session.getTransaction().commit();

        session.beginTransaction();
        Employee employee9 = new Employee("Anton", "Popescu", "Constanta", 27, "production", "programmer");
        Employee employee10 = new Employee("Costel", "Ionescu", "Galati", 44, "production", "business-analyst");
        session.save(employee9);
        session.save(employee10);
        session.getTransaction().commit();

        //Introducem 5 departamente
        session.beginTransaction();
        Department department1 = new Department("HR", 1, 1, "Adrian");
        session.save(department1);
        session.getTransaction().commit();

        session.beginTransaction();
        Department department2 = new Department("legal", 1, 1, "Violeta");
        session.save(department2);
        session.getTransaction().commit();

        session.beginTransaction();
        Department department3 = new Department("production", 3, 5, "Anton");
        session.save(department3);
        session.getTransaction().commit();

        session.beginTransaction();
        Department department4 = new Department("sales", 2, 2, "Gabriela");
        session.save(department4);
        session.getTransaction().commit();

        session.beginTransaction();
        Department department5 = new Department("financial", 1, 1, "Alina");
        session.save(department5);
        session.getTransaction().commit();

        //Introducem 5 produse
        session.beginTransaction();
        Product product1 = new Product("Accounting Application", "2.0", 1000, 2500);
        session.save(product1);
        session.getTransaction().commit();

        session.beginTransaction();
        Product product2 = new Product("Transport Application", "3.0", 2000, 500);
        session.save(product2);
        session.getTransaction().commit();

        session.beginTransaction();
        Product product3 = new Product("Delivery Application", "1.0", 20000, 5);
        session.save(product3);
        session.getTransaction().commit();

        session.beginTransaction();
        Product product4 = new Product("Weather Application", "Beta", 100, 0);
        session.save(product4);
        session.getTransaction().commit();

        session.beginTransaction();
        Product product5 = new Product("Travel Application", "3.0", 30000, 10);
        session.save(product5);
        session.getTransaction().commit();

        //4. Sa se stearga angajatii cu varsta mai mare de 65 ani
        session.beginTransaction();
        Query deleteEmployeeByAgeQuery = session.createNamedQuery("Delete_Employee_By_Age");
        deleteEmployeeByAgeQuery.setParameter("age", 65);
        int resultQuery1 = deleteEmployeeByAgeQuery.executeUpdate();
        System.out.println("Numarul angajatilor cu varsta mai mare de 65 de ani care au fost stersi este: " + resultQuery1);
        session.getTransaction().commit();

        //5. Sa se stearga departamentele care nu au nici un angajat
        session.beginTransaction();
        Query deleteDepartmentByNumberOfEmployeesQuery = session.createNamedQuery("Delete_Department_By_Number_Of_Employees");
        deleteDepartmentByNumberOfEmployeesQuery.setParameter("numberOfEmployees", 0);
        int resultQuery2 = deleteDepartmentByNumberOfEmployeesQuery.executeUpdate();
        System.out.println("Numarul departamentelor fara nici un angajat care au fot sterse este: " + resultQuery2);
        session.getTransaction().commit();

        //6. Sa se stearga produsele care au mai putin de 10 clienti
        session.beginTransaction();
        Query deleteProductByNumberOfCustomersQuery = session.createNamedQuery("Delete_Product_By_Number_Of_Customers");
        deleteProductByNumberOfCustomersQuery.setParameter("numberOfCustomers", 10);
        int resultQuery3 = deleteProductByNumberOfCustomersQuery.executeUpdate();
        System.out.println("Numarul produselor sterse cu mai putin de 10 clienti este: " + resultQuery3);
        session.getTransaction().commit();

        //7. Sa se mareasca pretul tuturor produselor cu 20%
        session.beginTransaction();
        Query updatePriceQuery = session.createNamedQuery("Update_Product_By_Price");
        int resultQuery4 = updatePriceQuery.executeUpdate();
        System.out.println("Numarul produselor al caror pret s-a marit cu 20% este: " + resultQuery4);
        session.getTransaction().commit();

        //8. Sa se modifice functia angajatilor cu varsta intre 35 si 40 ani
        session.beginTransaction();
        Query updateEmployeeByPosition = session.createNamedQuery("Update_Employee_By_Position");
        updateEmployeeByPosition.setParameter("position", "agent");
        updateEmployeeByPosition.setParameter("age1", 40);
        updateEmployeeByPosition.setParameter("age2", 35);
        int resultQuery5 = updateEmployeeByPosition.executeUpdate();
        System.out.println("Numarul angajatilor carora li s-a modificat functia in agent este: " + resultQuery5);
        session.getTransaction().commit();

        //9. Sa se afiseze angajatii dintr-un anumit departament
        session.beginTransaction();
        Query selectEmployeeByDepartmentNameQuery = session.createNamedQuery("Select_Employee_By_Department");
        selectEmployeeByDepartmentNameQuery.setParameter("departmentName", "production");
        List<Employee> resultListEmployee = selectEmployeeByDepartmentNameQuery.getResultList();
        System.out.println("Afisam lista angajatilor din departamentul productie:");
        for (Employee employee1 : resultListEmployee) {
            System.out.println(employee1);
        }
        session.getTransaction().commit();

        //10. Sa se afiseze produsele care au mai mult de 200 de clienti
        session.beginTransaction();
        Query selectProductByNumberOfCustomers = session.createNamedQuery("Select_Product_By_Number_Of_Customers");
        selectProductByNumberOfCustomers.setParameter("numberOfCustomers", 200);
        List<Product> productList = selectProductByNumberOfCustomers.getResultList();
        System.out.println("Afisam lista produselor care au mai mult de 200 de clienti");
        for (Product product : productList) {
            System.out.println(product);
        }
        session.getTransaction().commit();

        //11. Sa se afiseze etajul unui anumit departament
        session.beginTransaction();
        Query selectDepartmentByFloor = session.createNamedQuery("Select_Department_By_Floor");
        selectDepartmentByFloor.setParameter("floor", 3);
        List<Department> departmentList = selectDepartmentByFloor.getResultList();
        System.out.println("Afisam departamentele de la etajul 3");
        for (Department department : departmentList) {
            System.out.println(department);
        }
        session.getTransaction().commit();

        //12. Sa se afiseze departamentul si functia unui anumit angajat
        session.beginTransaction();
        Query selectEmployeeByNameAndSurnameQuery = session.createNamedQuery("Select_Employee_By_Name_And_Surname");
        selectEmployeeByNameAndSurnameQuery.setParameter("name", "Catalina");
        selectEmployeeByNameAndSurnameQuery.setParameter("surname", "Popa");
        List<Employee> employeeList = selectEmployeeByNameAndSurnameQuery.getResultList();
        for (Employee employee1 : employeeList) {
            System.out.println("Afisam departamentul si functia angajatei Catalina Popa: " + employee1.getDepartmentName() + " " + employee1.getPosition());
        }
        session.getTransaction().commit();

        //13. Sa se afiseze versiunea unui anumit produs
        session.beginTransaction();
        Query selectProductByVersion = session.createNamedQuery("Select_Product_By_Version");
        selectProductByVersion.setParameter("productName", "Accounting Application");
        List<Product> productListByVersion = selectProductByVersion.getResultList();
        for (Product product : productListByVersion) {
            System.out.println("Produsul Accounting Application are versiunea: " + product.getProductVersion());
        }

        session.close();

        //Sa se documenteze despre proprietatile unei tranzactii (care este acronimul care defineste o tranzactie)

        /* proprietatile unei tranzactii sunt definite cu ajutorul acronimului ACID

`           Atomicitate	    Catastrofele nu pot întrerupe o tranzacţie "la mijloc"
            Consistenţă	    Tranzacţiile păstrează structurile de date corecte
            Independenţă	Programe executate în paralel nu interfereaza
            Durabilitate	Rezultatul unei tranzacţii este permanent

            Atomicitate ->  O tranzacţie grupează mai multe instrucţiuni laolaltă într-o ``macro-instrucţiune'' care se
                            comportă ca o unitate indivizibilă
                            dacă am grupat nişte instrucţiuni într-o tranzacţie, atunci in cazul intreruperii curentului
                            electric se execută ori toate ori niciuna: "totul sau nimic"

            Consistenta ->  Tranzacţiile păstrează structurile de date corecte
                            modificările din tranzacţie preiau o bază de date consistentă şi o predau, la final, tot
                            într-o stare consistentă (sunt respectate toate restricţiile definite pentru baza de date)

            Independenta -> se referă la un context în care mai multe programe acţionează simultan asupra aceluiaşi set
                            de date (activitate concurentă); Un program nu trebuie să vadă rezultatele parţiale ale altui
                            program, pentru că acestea nu ar fi corecte

            Durabilitate -> atunci cînd o tranzacţie se termină rezultatele ei trebuie să fie permanente, chiar în
                            cazul unor catastrofe (ex. căderea curentului). */

        /* Sa se exemplifice acest acronim (sa se foloseasca un exemplu care nu este pe internet).
                    ex. Eu cumpar un produs de pe E-mag, iar E-mag mi-l vinde
         */





    }

}
