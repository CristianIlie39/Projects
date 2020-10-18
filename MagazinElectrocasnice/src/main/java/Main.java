public class Main {

    /*

    Folosind programarea orientata obiect, modelam un magazin de produse electrocasnice.

    - nu exista limitari; trebuie reprezentate obiecte astfel incat sa folosim toate conceptele programarii OOP

     */

    public static void main(String[] args) {

        Refrigerator refrigerator = new Refrigerator("Samsung", "gray", "A++", 2000, 50, 150);
        Refrigerator refrigerator2 = new Refrigerator();
        refrigerator2.setMark("Samsung");
        refrigerator2.setColor("gray");
        refrigerator2.setEnergeticEfficiency("A++");
        refrigerator2.setPrice(2000);
        refrigerator2.setStock(50);
        refrigerator2.setVolume(150);
        Refrigerator refrigerator3 = new Refrigerator("Samsung", "white", "A+++", 2000, 50, 150);

        refrigerator.start();
        refrigerator2.running();
        refrigerator3.connectToWiFi();
        refrigerator.cools();
        refrigerator2.freeze();
        refrigerator3.defrosts();
        refrigerator.stop();
        System.out.println(refrigerator.toString());
        System.out.println(refrigerator2.toString());
        System.out.println(refrigerator3.toString());
        System.out.println(refrigerator.equals(refrigerator2));
        System.out.println(refrigerator.equals(refrigerator3));
        System.out.println("Refrigerator are hashcode: " + refrigerator.hashCode());
        System.out.println("Refrigerator2 are hashcode: " + refrigerator2.hashCode());
        System.out.println("Refrigerator3 are hashcode: " + refrigerator3.hashCode());
        if (refrigerator.equals(refrigerator2) && refrigerator.hashCode() == refrigerator2.hashCode()) {
            System.out.println("refrigerator = refrigerator2");
        } else {
            System.out.println("refrigerator != refrigerator2");
        };
        if (refrigerator.equals(refrigerator3) && refrigerator.hashCode() == refrigerator3.hashCode()) {
            System.out.println("refrigerator = refrigerator3");
        } else {
            System.out.println("refrigerator != refrigerator3");
        };
        System.out.println();

        WashingMachine washingMachine = new WashingMachine("Whirlpool", "white", "A+++", 1200, 100, 10);
        WashingMachine washingMachine2 = new WashingMachine();
        washingMachine2.setMark("Whirlpool");
        washingMachine2.setColor("white");
        washingMachine2.setEnergeticEfficiency("A+++");
        washingMachine2.setPrice(1200);
        washingMachine2.setStock(100);
        washingMachine2.setNumberOfPrograms(10);
        WashingMachine washingMachine3 = new WashingMachine("Bosch", "gray", "A+++", 1200, 100, 10);

        washingMachine.start();
        washingMachine2.running();
        washingMachine3.connectToWiFi();
        washingMachine.washClothes();
        washingMachine2.stop();
        System.out.println(washingMachine.toString());
        System.out.println(washingMachine2.toString());
        System.out.println(washingMachine3.toString());
        System.out.println(washingMachine.equals(washingMachine2));
        System.out.println(washingMachine.equals(washingMachine3));
        System.out.println("Washing machine has hashcode: " + washingMachine.hashCode());
        System.out.println("Washing machine 2 has hashcode: " + washingMachine2.hashCode());
        System.out.println("Washing machine 3 has hashcode: " + washingMachine3.hashCode());
        if (washingMachine.equals(washingMachine2) && washingMachine.hashCode() == washingMachine2.hashCode()) {
            System.out.println("washing machine = washing machine 2");
        } else {
            System.out.println("washing machine != washing machine 3");
        };
        if (washingMachine.equals(washingMachine3) && washingMachine.hashCode() == washingMachine3.hashCode()) {
            System.out.println("washing machine = washing machine 3");
        } else {
            System.out.println("washing machine != washing machine 3");
        };
        System.out.println();

        DishWasher dishWasher = new DishWasher("Bosch", "white", "A++", 1100, 40, true);
        Vacuum vacuum = new Vacuum("Philips", "red", "A+++", 700, 150, 800);
        // la fel vom proceda cu obiectele dishWasher si vacuum








    }

}
