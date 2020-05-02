public class Main {
    public static void main(String[] args) {

        //Ex1: Write a Java program to find the smallest number among three numbers
        int a = 5657;
        int b = 3489;
        int c = 1621;
        int nrMic = gasesteCelMaiMicNumar(a, b, c);
        System.out.println("Ex1 - cel mai mic numar este: " + nrMic);

        //Ex2: Write a Java program that takes three numbers as input to calculate and print the average of the numbers. 
        int medieNumere = mediaNumerelor(a, b, c);
        System.out.println("Ex2 - media celor 3 numere este: " + medieNumere);

        //Ex3: Write a Java program to display the middle character of a string
        String text = "Compania Regal, care administrează câteva restaurante în Galaţi, îşi remunerează acţionarii cu dividende de 2 mil. lei din vânzarea unor clădiri şi terenuri";
        afiseazaCaracter(text);

        //Ex4: Write a Java program to count all words in a string.
        int numarulcuvintelor = numaraCuvinte(text); //am folosit stringul text de mai sus
        System.out.println("Ex4 - numarul cuvintelor este: " + numarulcuvintelor);

        //Ex5: Write a Java program to print characters between two characters (i.e. A to P ) from a text.
        String text2 = "Ana are mere coapte. Prunele inca nu s-au copt.";
        printeazaCaractereleDintreAsiP(text2);

        //Ex6: Write a Java program start with an integer n, divide n by 2 if n is even or multiply by 3 and add 1 if n is odd, repeat the process until n = 1.
        int n = 12345;
        int rezultat = calculeazaEx6(n);
        System.out.println("Ex6 - rezultatul exercitiului este: " + rezultat);

        //Ex7: Write a Java program to test if an array of integers contains an element 10 next to 10 or an element 20 next to 20.
        int[] multime = new int[30];
        int primaPozitie = 0;
        int ultimaPozitie = 29;
        while (primaPozitie <= ultimaPozitie) {
            multime[primaPozitie] = primaPozitie;
            primaPozitie++;
        }
        System.out.println("Ex7 - rezultatul este: " + rezultatEx7(multime));

        //Ex8: Write a Java program to find the numbers greater than the average of the numbers of a given array.
        rezultatEx8(multime);

        //Ex9: Write a Java program to check if the value 20 appears three times in an array.
        System.out.println("Ex9 - rezultaul este: " + rezultatEx9(multime));

        //Ex10: Write a Java program to add all the digits of a given positive integer until the result has a single digit.
        int x = 2123;
        rezultatEx10(x);

        //Afla cate cifre are un numar.
        int y = 15801789;
        System.out.println("Exercitiu (facut in plus) care returneaza numarul cifrelor: Numarul cifrelor este: " + rezultatEx(y));

        //Ex11: Write a Java program to check if a positive number is a palindrome or not.
        int t = 1234321;
        System.out.println("Ex11 - rezultatul este: " + rezultatEx11(t));

        //Ex12: Write a Java program to check if a string is a palindrome or not.
        String textul = "madam";
        System.out.println("Ex12 - rezultatul este: " + functieEx12(textul));

    }

    public static int gasesteCelMaiMicNumar(int x, int y, int z) {
        if (x < y) {
            return x;
        } else if (y < z) {
            return y;
        } else {
            return z;
        }
    }

    public static int mediaNumerelor(int x, int y, int z) {
        int suma = x + y + z;
        int media = suma / 3;
        return media;
    }

    public static void afiseazaCaracter(String text) {
        char caracterCautat = text.charAt(text.length() / 2);
        System.out.println("Ex3 - Caracterul din mijlocul stringului este: " + caracterCautat);
    }

    public static int numaraCuvinte(String text) {
        int numar = 0;
        String[] cuvinte = text.split(" ");
        for (int cursor = 0; cursor < cuvinte.length; cursor++) {
            numar++;
        }
        return numar;
    }

    public static void printeazaCaractereleDintreAsiP(String text) {
        int pozitieA = text.indexOf('A');
        int pozitieP = text.indexOf('P');
        String textRezultat = text.substring(pozitieA, pozitieP);
        System.out.println("Ex5 - afiseaza caracterele dintre A si P din stringul text2: " + textRezultat);
    }

    public static int calculeazaEx6(int n) {
        int calcul1 = n / 2;
        int calcul2 = n * 3 + 1;
        if (n % 2 == 0) {
            return calcul1;
        } else {
            return calcul2;
        }
    }

    public static boolean rezultatEx7(int[] array) {
        boolean rezultat = array[10] == 10 || array[20] == 20;
        return rezultat;
    }

    public static int[] rezultatEx8(int[] array) {
        int sumaElementelor = 0;
        for (int cursor = 0; cursor < array.length; cursor++) {
            sumaElementelor = sumaElementelor + array[cursor];
        }
        int mediaElementelor = sumaElementelor / array.length;
        System.out.println("Ex8 - rezultatul este: ");
        for (int cursor = 0; cursor < array.length; cursor++) {
            if (array[cursor] > mediaElementelor) {
                System.out.println(array[cursor]);
            }
        }
        return array;
    }

    public static boolean rezultatEx9(int[] array) {
        int numar = 1;
        for (int cursor = 0; cursor < array.length; cursor++) {
            for (int pozitie = cursor + 1; pozitie < array.length; pozitie++) {
                if (array[cursor] == array[pozitie]) {
                    System.out.println(array[pozitie]);
                    numar++;
                }
            }
        }
        boolean rezultat = numar == 3;
        return rezultat;
    }

    public static int rezultatEx10(int numar) {
        int suma = 0;
        while (numar != 0) {
            int ultimaCifra = numar % 10;
            suma = suma + ultimaCifra;
            numar = numar / 10;
        }
        if (suma <= 9) {
            System.out.println("Ex10 - rezultatul este: " + suma);
        }
        return suma;
    }

    public static int rezultatEx(int numar) {
        int cifra = 0;
        while (numar != 0) {
            numar = numar / 10;
            cifra++;
        }
        return cifra;
    }

    public static boolean rezultatEx11(int numar) {
        int numarInitial = numar;
        int invers = 0;
        while (numar != 0) {
            int ultimaCifraNumar = numar % 10;
            invers = invers * 10 + ultimaCifraNumar;
            numar = numar / 10;
        }
        boolean rezultat = numarInitial == invers;
        return rezultat;
    }

    public static boolean functieEx12(String text) {
        int cursor1 = 0;
        int cursor2 = text.length() - 1;
        while (cursor1 < cursor2) {
            cursor1++;
            cursor2--;
        }
        boolean rezultat = text.charAt(cursor1) == text.charAt(cursor2);
        return rezultat;
    }


}
