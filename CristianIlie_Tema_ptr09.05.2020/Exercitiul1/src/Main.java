public class Main {

    //avem o functie care primeste 2 stringuri ca parametri si verifica daca al doilea string exista in primul string

    public static void main(String[] args) {
        String text1 = "Ana are mere dulci si le vinde foarte bine.";
        String text2 = "vinde foarte bine.";

        verificaString(text1, text2);

    }

    public static void verificaString (String text1, String text2) {
        if (text1.contains(text2)) {
            System.out.println("Stringul al doilea exista in primul string.");
        } else {
            System.out.println("Stringul al doilea nu exista in primul string");
        }
    }

}
