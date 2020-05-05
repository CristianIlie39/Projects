import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import static java.lang.Character.toTitleCase;
import static java.lang.Character.toUpperCase;
import static java.lang.Integer.bitCount;
import static java.lang.String.copyValueOf;
import static java.lang.String.valueOf;
import static java.util.Calendar.getInstance;

public class Main {

    //Vreau sa afisam data de astazi

    //Vreau sa vedem luna curenta

    //Vreau sa vedem anul curent

    //Vreau sa creem un obiect care sa tina un text

    //Vreau sa vedem ultima aparitie din text a caracterului A

    //Vreau sa creem un obiect care sa tina numarul 126

    //Vreau sa creem un obiect care sa tina caracterul "s"

    //Vreau pentru fiecare obiect sa cautam cate 2 comportamente noi

    public static void main(String[] args) {

        Date dataDeAzi = new Date();
        System.out.println(dataDeAzi);

        int lunaCurenta = getInstance().get(Calendar.MONTH);
        System.out.println(lunaCurenta);

        switch (lunaCurenta) {
            case 0:
                System.out.println("ianuarie");
                break;
            case 1:
                System.out.println("februarie");
                break;
            case 2:
                System.out.println("martie");
                break;
            case 3:
                System.out.println("aprilie");
                break;
            case 4:
                System.out.println("mai");
                break;
            case 5:
                System.out.println("iunie");
                break;
            case 6:
                System.out.println("iulie");
                break;
            case 7:
                System.out.println("august");
                break;
            case 8:
                System.out.println("septembrie");
                break;
            case 9:
                System.out.println("octombrie");
                break;
            case 10:
                System.out.println("noiembrie");
                break;
            case 11:
                System.out.println("decembrie");
                break;
            default:
                System.out.println("luna gresita");
        }

        int anCurent = getInstance().get(Calendar.YEAR);
        System.out.println("Anul curent este: " + anCurent);

        String text = new String("Ana are mere");
        System.out.println(text);

        int x = text.lastIndexOf('a');
        System.out.println("ultima aparitie a caracterului 'a' in obiectul text este: " + x);

        Integer numar = Integer.valueOf(126);
        System.out.println(numar);

        Character caracter = Character.valueOf('s');
        System.out.println(caracter);

        char[] caractere = new char[5];
        caractere[0] = 'a';
        caractere[1] = 'b';
        caractere[2] = 'c';
        caractere[3] = 'd';
        caractere[4] = 'e';

        String textRezultat = copyValueOf(caractere);
        System.out.println(textRezultat);

        String text2 = " Ana are mere ";
        if (text2.startsWith(" ") || text2.endsWith(" ")) {
            System.out.println("text2 incepe sau se termina cu spatiu");
        }

        String textFaraSpatii = text2.trim();

        if (textFaraSpatii.startsWith(" ") || textFaraSpatii.endsWith(" ")) {
            System.out.println("Textul incepe sau se termina cu pauza/spatiu");
        } else {
            System.out.println("Textul textFaraSpatii nu incepe sau nu se termina cu pauza/spatiu");
        }

        System.out.println(textFaraSpatii);

        int y = bitCount(numar);
        System.out.println(y);

        int z = numar.byteValue();
        System.out.println(z);

        int a = numar.compareTo(100);
        System.out.println(a);

        int numar1 = 150;

        int b = numar.compare(180, 150);
        System.out.println(b);

        double numar2 = numar.doubleValue();
        System.out.println(numar2);

        String string = numar.toString();
        System.out.println(string);

        char caracter1 = toUpperCase(caracter);
        System.out.println(caracter1);

        char caracter2 = toTitleCase(caracter);
        System.out.println(caracter2);
        

    }


}
