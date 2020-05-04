public class Main {

    //se da un array de 7 cuvinte
    //sa se concateneze si sa se afiseze cuvintele de pe pozitiile divizibile cu 3 si mai mari decat 0

    public static void main(String[] args) {

        String[] array = new String[7];
        array[0] = "volumul";
        array[1] = "vânzări";
        array[2] = "triplat";
        array[3] = "perioadă";
        array[4] = "siguranţă";
        array[5] = "situaţie";
        array[6] = "izolare";

        concatenareCuvinte(array);
        
    }

    public static void concatenareCuvinte(String[] array) {
        String rezultatConcatenare = "";
        for (int cursor = 1; cursor < array.length; cursor++) {
            if (cursor % 3 == 0) {
                rezultatConcatenare = rezultatConcatenare.concat(array[cursor]);
            }
        }
        System.out.println("Rezultatul este: " + rezultatConcatenare);
    }

}
