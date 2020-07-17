import java.util.SortedMap;

public class Menu {

    public static void mainMenu() {
        //facem meniul principal
        System.out.println("Meniu principal");
        System.out.println("1. Introduceti o masina");
        System.out.println("2. Faceti update la masina");
        System.out.println("3. Stergeti o masina");
        System.out.println("4. Cautati o masina");
    }

    //vom face submeniuri pentru fiecare tasta din meniul principal

    //facem submeniu pt tasta 1
    public static void menuAddCar() {
        System.out.println("Va rog urmati pasii de mai jos pentru a insera o masina in baza de date:");
        System.out.println("Introduceti marca");
        System.out.println("Introduceti modelul");
        System.out.println("Introduceti anul fabricatiei");
        System.out.println("Introduceti culoarea");
        System.out.println("Introduceti tipul combustibilului");
    }

    //facem submeniu pt tasta 2
    public static void menuUpdateCar() {
        System.out.println("Va rog sa updatam o masina in baza de date urmand pasii de mai jos:");
        System.out.println("1. Introduceti marca");
        System.out.println("2. Introduceti modelul");
        System.out.println("3. Stabiliti culoarea dorita");
    }

    //facem submeniu pt tasta 3
    public static void menuDeleteCar() {
        System.out.println("Va rog sa stergem din baza de date o masina cu caracteristicile de mai jos:");
        System.out.println("1. Introduceti marca");
        System.out.println("2. Introduceti modelul");
        System.out.println("3. Introduceti anul fabricatiei");
    }

    //facem submeniu pt tasta 4
    public static void menuSearchCar() {
        System.out.println("Cautati in baza de date o masina cu caracteristicile de mai jos");
        System.out.println("1. Introduceti marca");
        System.out.println("2. Introduceti modelul");
        System.out.println("3. Introduceti anul fabricatiei");
    }

}
