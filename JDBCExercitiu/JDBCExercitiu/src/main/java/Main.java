import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*Inventar:
        - 1 clasa Masina
        - 1 clasa DBConnection - tinem operatiile cu DB
        - 1 clasa Menu - meniul utilizatorului
        - 1 clasa exceptie - NoCarWhithYourDescriptionFoundException
        - 1 clasa User
         */

        Menu.mainMenu();
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        if (option == 1) {
            user.insertCarOption();
        } else if (option == 2) {
            user.updateCarOption();
        } else if (option == 3) {
            user.deleteCarOption();
        } else if (option == 4) {
            user.selectCarOption();
        } else {
            System.out.println("Optiunea introdusa nu exista!");
        }
    }
}
