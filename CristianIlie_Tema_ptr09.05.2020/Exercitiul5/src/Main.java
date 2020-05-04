public class Main {

    //Se da un text
    //Sa se afiseze toate cuvintele care incep cu litera "s" sau cu litera "d" ---> o metoda
    //Sa se afiseze litera de la pozitia 3 din fiecare cuvant ---> o alta metoda

    public static void main(String[] args) {

        String text = "are în plan dezvoltarea unei soluţii care să digitalizeze procesele birocratice între persoanele fizice şi furnizorii de servicii publice";

        afiseazaCuvinte(text);
        System.out.println();
        afiseazaCaracter(text);

    }

    public static void afiseazaCuvinte (String text) {
        System.out.println("Cuvintele cautate sunt urmatoarele: ");
        String[] array = text.split(" ");
        for (int cursor = 0; cursor < array.length; cursor++) {
            if (array[cursor].startsWith("s") || array[cursor].startsWith("d")) {
                System.out.println(array[cursor]);
            }
        }
    }

    public static void afiseazaCaracter(String text) {
        System.out.println("Litera de la pozitia 3 din fiecare cuvant este: ");
        String[] array = text.split(" ");
        for (int cursor = 0; cursor < array.length; cursor++) {
            if (array[cursor].length() > 3) {
                char litera = array[cursor].charAt(3);
                System.out.println(litera);
            }
        }
    }




}
