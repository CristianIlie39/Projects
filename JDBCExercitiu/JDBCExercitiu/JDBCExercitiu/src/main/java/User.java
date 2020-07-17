import java.util.Scanner;

public class User {

    public User() {

    }

    DatabaseConnection databaseConnection = new DatabaseConnection();
    Scanner scanner = new Scanner(System.in);

    //userul apasa tasta 1/introduce masina in baza de date
    public void insertCarOption() {
        Menu.menuAddCar();
        String brand = scanner.next();
        System.out.println("Ati introdus marca: " + brand);
        String model = scanner.next();
        System.out.println("Ati introdus modelul: " + model);
        String year = scanner.next();
        System.out.println("Ati introdus anul fabricatiei: " + year);
        String color = scanner.next();
        System.out.println("Ati introdus culoarea: " + color);
        String fuelType = scanner.next();
        System.out.println("Ati introdus tipul combustibilului: " + fuelType);
        Car carToInsert = new Car(brand, model, year, color, fuelType);
        databaseConnection.insertCar(carToInsert);
    }

    //userul apasa tasta 2/updateaza o masina in baza de date
    public void updateCarOption() {
        Menu.menuUpdateCar();
        String brand = scanner.next();
        System.out.println("Ati introdus marca: " + brand);
        String model = scanner.next();
        System.out.println("Ati introdus modelul: " + model);
        String color = scanner.next();
        System.out.println("Ati setat culoarea: " + color);
        Car carToUpdate = new Car(brand, model, "2019", color, "motorina");
        databaseConnection.updateCar(carToUpdate);
    }

    //userul apasa tasta 3/sterge o masina in baza de date
    public void deleteCarOption() {
        Menu.menuDeleteCar();
        String brand = scanner.next();
        System.out.println("Ati introdus marca: " + brand);
        String model = scanner.next();
        System.out.println("Ati introdus modelul: " + model);
        String year = scanner.next();
        System.out.println("Ati introdus anul fabricatiei: " + year);
        Car carToDelete = new Car(brand, model, year, "red", "benzina");
        databaseConnection.deleteCar(carToDelete);
    }

    //userul apasa tasta 4/cauta o masina in baza de date
    public void selectCarOption() {
        Menu.menuSearchCar();
        String brand = scanner.next();
        System.out.println("Ati introdus marca: " + brand);
        String model = scanner.next();
        System.out.println("Ati introdus modelul: " + model);
        String year = scanner.next();
        System.out.println("Ati introdus anul fabricatiei: " + year);
        Car carToSelect = new Car(brand, model, year, "black", "benzina");
        databaseConnection.selectCar(carToSelect);
    }
}






