import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /* Modelam un automat de Vending Machine care o sa poata vinde:
         - bauturi (Cola, Fanta, apa) cu nume, pret si cantitate (despartite prin ";")
         - cafea - cu nume, pret si cantitate; putem vinde Cappucino, Americano, Espresso
         - snack-uri - cu nume, pret si cantitate: croassant, chips, chocolate bar
           Fiecare din aceste categorii vor fi citite din fisier (3 fisiere - bauturi, cafea, snack-uri)
           Vom implementa un meniu:
         - optiunea 1: Introduceti o suma de bani; utilizatorul va introduce un numar; trebuie
           sa ne asiguram ca numarul > 0, daca nu se arunca o exceptie AmountNotAcceptedException
         - apoi se afiseaza optiunile de cumparare: tasta 1 - cola, tasta 2 - fanta, tasta 3 - apa, tasta 4 - Cappucino,
           tasta 5 - Americano, tasta 6 - Espresso, tasta 7 - croassant, tasta 8 - chips, tasta 9 - chocolate bar
           Dupa ce user-ul selecteaza ce vrea, daca are destui bani automatul ii vinde ce vrea, daca nu aruncam
           o exceptie NotEnoughMoneyException. Trebuie sa verificam daca exista cantitatea solicitata, daca nu
           se arunca exceptia NotEnoughQuantityException.

            Inventar:
            - 3 fisiere - bauturi, cafea, snack-uri
            - 1 clasa abstracta Product: nume, pret si cantitate
            - 1 clasa VendingMachine - folosim Singleton
            - 1 clasa ProductFactory - folosim design pattern-ul FactoryMethod
            - 1 clasa abstracta Bauturi - mosteneste clasa Produs
            - 1 clasa abstracta Cafea - mosteneste clasa Produs
            - 1 clasa abstracta Snack - mosteneste clasa Produs
            - 3 clase: Cola, Fanta si Apa - mostenesc Bauturi
            - 3 clase: Cappucino, Americano si Espresso - mostenesc Cafea
            - 3 clase: Croissant, Chips si ChocolateBar - mostenesc Snack
            - 1 clasa AmountNotAcceptedException - daca suma de bani introdusa <= 0
            - 1 clasa NotEnoughMoneyException - daca userul nu are destui bani pt produsele solicitate
            - 1 clasa NotEnoughQuantityException - daca nu exista cantitatea
         */

        try {
            String pathDrinks = "D:\\cursuri Alex\\21.06.2020\\Drinks.txt";
            String pathCoffees = "D:\\cursuri Alex\\21.06.2020\\Coffees.txt";
            String pathSnacks = "D:\\cursuri Alex\\21.06.2020\\Snacks.txt";

            FileReader fileReaderDrinks = new FileReader(pathDrinks);
            FileReader fileReaderCoffees = new FileReader(pathCoffees);
            FileReader fileReaderSnacks = new FileReader(pathSnacks);

            BufferedReader bufferedReaderDrinks = new BufferedReader(fileReaderDrinks);
            BufferedReader bufferedReaderCoffees = new BufferedReader(fileReaderCoffees);
            BufferedReader bufferedReaderSnacks = new BufferedReader(fileReaderSnacks);

            String text = bufferedReaderDrinks.readLine();

            VendingMachine vendingMachine = VendingMachine.getInstance();

            //ne ocupam de fisierul Drinks
            while (text != null && !text.isEmpty()) {
                String[] arrayCuvinte = text.split(";");
                if (arrayCuvinte[0].equals("Cola")) { //cream obiectul Cola pe care apoi il punem mai jos in vendingMachine
                    Cola cola = new Cola(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setColaProduct(cola);
                }
                if (arrayCuvinte[0].equals("Fanta")) {
                    Fanta fanta = new Fanta(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setFantaProduct(fanta);
                }
                if (arrayCuvinte[0].equals("Water")) {
                    Water water = new Water(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setWaterProduct(water);
                }
                text = bufferedReaderDrinks.readLine();
            }

            //ne ocupam de fisierul Coffees
            String text2 = bufferedReaderCoffees.readLine();
            while (text2 != null && !text2.isEmpty()) {
                String[] arrayCuvinte = text2.split(";");
                if (arrayCuvinte[0].equals("Cappucino")) {
                    Cappucino cappucino = new Cappucino(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setCappucinoProduct(cappucino);
                }
                if (arrayCuvinte[0].equals("Americano")) {
                    Americano americano = new Americano(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setAmericanoProduct(americano);
                }
                if (arrayCuvinte[0].equals("Espresso")) {
                    Espresso espresso = new Espresso(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setEspressoProduct(espresso);
                }
                text2 = bufferedReaderCoffees.readLine();
            }

            //ne ocupam de fisierul Snacks
            String text3 = bufferedReaderSnacks.readLine();
            while (text3 != null && !text3.isEmpty()) {
                String[] arrayCuvinte = text3.split(";");
                if (arrayCuvinte[0].equals("Croissant")) {
                    Croissant croissant = new Croissant(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setCroissantProduct(croissant);
                }
                if (arrayCuvinte[0].equals("Chips")) {
                    Chips chips = new Chips(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setChipsProduct(chips);
                }
                if (arrayCuvinte[0].equals("ChocolateBar")) {
                    ChocolateBar chocolateBar = new ChocolateBar(arrayCuvinte[0], Integer.valueOf(arrayCuvinte[1]), Integer.valueOf(arrayCuvinte[2]));
                    vendingMachine.setChocolateBarProduct(chocolateBar);
                }
                text3 = bufferedReaderSnacks.readLine();
            }

            //verificam daca se afiseaza cantitatea de Cola, Fanta, etc
            System.out.println("Afisam cantitatea de cola " + vendingMachine.getColaProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de fanta " + vendingMachine.getFantaProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de apa " + vendingMachine.getWaterProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de cappucino " + vendingMachine.getCappucinoProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de americano " + vendingMachine.getAmericanoProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de espresso " + vendingMachine.getEspressoProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de croissant " + vendingMachine.getCroissantProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de chips " + vendingMachine.getChipsProduct().getProductQuantity());
            System.out.println("Afisam cantitatea de chocolate bar " + vendingMachine.getChocolateBarProduct().getProductQuantity());
            System.out.println();

            //urmeaza de facut partea prin care vindem - Tema

            System.out.println("Va rog sa introduceti o suma de bani");
            Scanner scanner = new Scanner(System.in);
            int valueEntered = scanner.nextInt();
            if (valueEntered > 0) {
                System.out.println("Meniu de cumparaturi");
            } else {
                throw new AmountNotAcceptedException("Valoarea introdusa nu este acceptata!");
            }
            System.out.println("tasta 1 - Cola");
            System.out.println("tasta 2 - Fanta");
            System.out.println("tasta 3 - Apa");
            System.out.println("tasta 4 - Cappucino");
            System.out.println("tasta 5 - Americano");
            System.out.println("tasta 6 - Espresso");
            System.out.println("tasta 7 - Croissant");
            System.out.println("tasta 8 - Chips");
            System.out.println("tasta 9 - Chocolate Bar");
            System.out.println("Va rog sa apasati una din tastele de mai sus");
            int optiune = scanner.nextInt();
            switch (optiune) {
                case 1:
                    System.out.println("Ati ales Cola");
                    if (valueEntered >= vendingMachine.getColaProduct().getProductPrice() && vendingMachine.getColaProduct().getProductQuantity() >= 1) {
                        System.out.println("Va rog sa ridicati produsul si restul de " + (valueEntered - vendingMachine.getColaProduct().getProductPrice()) + " lei");
                    } else if (valueEntered >= vendingMachine.getColaProduct().getProductPrice() && vendingMachine.getColaProduct().getProductQuantity() < 1) {
                        throw new NotEnoughQuantityException("Nu putem livra produsul!");
                    } else if (valueEntered < vendingMachine.getColaProduct().getProductPrice()) {
                        throw new NotEnoughMoneyException("Nu putem livra produsul!");
                    }
                    break;
                case 2:
                    System.out.println("Ati ales Fanta");
                    if (valueEntered >= vendingMachine.getFantaProduct().getProductPrice() && vendingMachine.getFantaProduct().getProductQuantity() >= 1) {
                        System.out.println("Va rog sa ridicati produsul si restul de " + (valueEntered - vendingMachine.getFantaProduct().getProductPrice()) + " lei");
                    } else if (valueEntered >= vendingMachine.getFantaProduct().getProductPrice() && vendingMachine.getFantaProduct().getProductQuantity() < 1) {
                        throw new NotEnoughQuantityException("Nu putem livra produsul!");
                    } else if (valueEntered < vendingMachine.getFantaProduct().getProductPrice()) {
                        throw new NotEnoughMoneyException("Nu putem livra produsul!");
                    }
                    break;
                case 3:
                    System.out.println("Ati ales apa");
                    if (valueEntered >= vendingMachine.getWaterProduct().getProductPrice() && vendingMachine.getWaterProduct().getProductQuantity() >= 1) {
                        System.out.println("Va rog sa ridicati produsul si restul de " + (valueEntered - vendingMachine.getWaterProduct().getProductPrice()) + " lei");
                    } else if (valueEntered >= vendingMachine.getWaterProduct().getProductPrice() && vendingMachine.getFantaProduct().getProductQuantity() < 1) {
                        throw new NotEnoughQuantityException("Nu putem livra produsul!");
                    } else if (valueEntered < vendingMachine.getWaterProduct().getProductPrice()) {
                        throw new NotEnoughMoneyException("Nu putem livra produsul!");
                    }
                    break;
                case 4:
                    System.out.println("Ati ales Cappucino");
                    if (valueEntered >= vendingMachine.getCappucinoProduct().getProductPrice() && vendingMachine.getCappucinoProduct().getProductQuantity() >= 1) {
                        System.out.println("Va rog sa ridicati produsul si restul de " + (valueEntered - vendingMachine.getCappucinoProduct().getProductPrice()) + " lei");
                    } else if (valueEntered >= vendingMachine.getCappucinoProduct().getProductPrice() && vendingMachine.getCappucinoProduct().getProductQuantity() < 1) {
                        throw new NotEnoughQuantityException("Nu putem livra produsul!");
                    } else if (valueEntered < vendingMachine.getCappucinoProduct().getProductPrice()) {
                        throw new NotEnoughMoneyException("Nu putem livra produsul!");
                    }
                    break;
                case 5:
                    System.out.println("Ati ales Americano");
                    if (valueEntered >= vendingMachine.getAmericanoProduct().getProductPrice() && vendingMachine.getAmericanoProduct().getProductQuantity() >= 1) {
                        System.out.println("Va rog sa ridicati produsul si restul de " + (valueEntered - vendingMachine.getAmericanoProduct().getProductPrice()) + " lei");
                    } else if (valueEntered >= vendingMachine.getAmericanoProduct().getProductPrice() && vendingMachine.getAmericanoProduct().getProductQuantity() < 1) {
                        throw new NotEnoughQuantityException("Nu putem livra produsul!");
                    } else if (valueEntered < vendingMachine.getAmericanoProduct().getProductPrice()) {
                        throw new NotEnoughMoneyException("Nu putem livra produsul!");
                    }
                    break;
                case 6:
                    System.out.println("Ati ales Espresso");
                    if (valueEntered >= vendingMachine.getEspressoProduct().getProductPrice() && vendingMachine.getEspressoProduct().getProductQuantity() >= 1) {
                        System.out.println("Va rog sa ridicati produsul si restul de " + (valueEntered - vendingMachine.getEspressoProduct().getProductPrice()) + " lei");
                    } else if (valueEntered >= vendingMachine.getEspressoProduct().getProductPrice() && vendingMachine.getEspressoProduct().getProductQuantity() < 1) {
                        throw new NotEnoughQuantityException("Nu putem livra produsul!");
                    } else if (valueEntered < vendingMachine.getEspressoProduct().getProductPrice()) {
                        throw new NotEnoughMoneyException("Nu putem livra produsul!");
                    }
                    break;
                case 7:
                    System.out.println("Ati ales Croissant");
                    if (valueEntered >= vendingMachine.getCroissantProduct().getProductPrice() && vendingMachine.getCroissantProduct().getProductQuantity() >= 1) {
                        System.out.println("Va rog sa ridicati produsul si restul de " + (valueEntered - vendingMachine.getCroissantProduct().getProductPrice()) + " lei");
                    } else if (valueEntered >= vendingMachine.getCroissantProduct().getProductPrice() && vendingMachine.getCroissantProduct().getProductQuantity() < 1) {
                        throw new NotEnoughQuantityException("Nu putem livra produsul!");
                    } else if (valueEntered < vendingMachine.getCroissantProduct().getProductPrice()) {
                        throw new NotEnoughMoneyException("Nu putem livra produsul!");
                    }
                    break;
                case 8:
                    System.out.println("Ati ales Chips");
                    if (valueEntered >= vendingMachine.getChipsProduct().getProductPrice() && vendingMachine.getChipsProduct().getProductQuantity() >= 1) {
                        System.out.println("Va rog sa ridicati produsul si restul de " + (valueEntered - vendingMachine.getChipsProduct().getProductPrice()) + " lei");
                    } else if (valueEntered >= vendingMachine.getChipsProduct().getProductPrice() && vendingMachine.getChipsProduct().getProductQuantity() < 1) {
                        throw new NotEnoughQuantityException("Nu putem livra produsul!");
                    } else if (valueEntered < vendingMachine.getChipsProduct().getProductPrice()) {
                        throw new NotEnoughMoneyException("Nu putem livra produsul!");
                    }
                    break;
                case 9:
                    System.out.println("Ati ales Chocolate Bar");
                    if (valueEntered >= vendingMachine.getChocolateBarProduct().getProductPrice() && vendingMachine.getChocolateBarProduct().getProductQuantity() >= 1) {
                        System.out.println("Va rog sa ridicati produsul si restul de " + (valueEntered - vendingMachine.getChocolateBarProduct().getProductPrice()) + " lei");
                    } else if (valueEntered >= vendingMachine.getChocolateBarProduct().getProductPrice() && vendingMachine.getChocolateBarProduct().getProductQuantity() < 1) {
                        throw new NotEnoughQuantityException("Nu putem livra produsul!");
                    } else if (valueEntered < vendingMachine.getChocolateBarProduct().getProductPrice()) {
                        throw new NotEnoughMoneyException("Nu putem livra produsul!");
                    }
                    break;
                default:
                    System.out.println("Optiunea introdusa de dumneavoastra nu exista");
            }

        } catch (AmountNotAcceptedException e) {
            System.out.println("Ati introdus un numar mai mic sau egal cu zero! " + e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println("Suma introdusa este prea mica! " + e.getMessage());
        } catch (NotEnoughQuantityException e) {
            System.out.println("Produsele s-au terminat! " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit " + e.getMessage());
        } catch (IOException e) {
            System.out.println("A aparut o exceptie " + e.getMessage());
        }
    }
}
