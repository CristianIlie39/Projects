import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {

    //TEMA
    //sa se reprezinte un calculator care face operatiile simple (adunare, scadere, inmultire, impartire), operatiile stiintifice (ridicare la putere, radical, logaritm in baza 10, logaritm) dar si urmatorele operatii cu stringuri:
    //concateneaza 2 stringuri
    //verifica daca stringul contine un anumit caracter
    //aduna lungimea a 2 stringuri
    //verifica daca lungimea unui string este numar par sau impar
    //transforma un string intr-un sir de caractere
    //verifica daca stringul incepe cu o vocala
    //numara spatiile dintr-un string

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        System.out.println("Rezultatul adunarii numerelor este: " + calculator.adunare(10, 5));
        System.out.println("Rezultatul scaderii numerelor este: " + calculator.scadere(10, 5));
        System.out.println("Rezultatul inmultirii numerelor este: " + calculator.inmultire(10, 5));
        System.out.println("Rezultatul impartirii numerelor este: " + calculator.impartire(10, 5));

        //Acum vrem sa introducem numerele de la tastatura:

        //declaram un obiect de tip scaner
        Scanner scan = new Scanner(System.in);

        System.out.println("Va rugam sa introduceti primul numar: ");
        int primulNumar = scan.nextInt();
        System.out.println("Va rugam sa introduceti al doilea numar: ");
        int alDoileaNumar = scan.nextInt();
        System.out.println("Numerele introduse de dumneavoastra sunt: " + primulNumar + " si " + alDoileaNumar);

        int adunare = calculator.adunare(primulNumar, alDoileaNumar);
        System.out.println("Rezultatul adumarii numerelor este: " + adunare);
        int scadere = calculator.scadere(primulNumar, alDoileaNumar);
        System.out.println("Rezultatul scaderii numerelor este: " + scadere);
        int inmultire = calculator.inmultire(primulNumar, alDoileaNumar);
        System.out.println("Rezultatul inmultirii numerelor este: " + inmultire);
        int impartire = calculator.impartire(primulNumar, alDoileaNumar);
        System.out.println("Rezultatul impartirii numerelor este: " + impartire);


        //operatii calculator stiintific
        CalculatorStiintific calculatorStiintific = new CalculatorStiintific();

        System.out.println("Rezultatul ridicarii la putere este: " + calculatorStiintific.ridicareLaPutere(3, 3));
        System.out.println("Rezultat radical este: " + calculatorStiintific.radical(81));
        System.out.println("Rezultat logaritm in baza 10 este: " + calculatorStiintific.logaritmBaza10(100));
        System.out.println("Rezultat logaritm este: " + calculatorStiintific.logaritm(8));

        //acum vrem sa introducem numerele de la tastatura pentru calculatorul stiintific

        //declaram un obiect de tip scaner
        Scanner scan2 = new Scanner(System.in);

        System.out.println("Va rugam sa introduceti primul numar pentru ridicare la putere: ");
        int primulNr = scan2.nextInt();
        System.out.println("Va rugam sa introduceti al doilea numar pentru ridicare la putere: ");
        int alDoileaNr = scan2.nextInt();
        System.out.println("Numerele introduse sunt: " + primulNr + " si " + alDoileaNr);
        System.out.println("Rezultatul ridicarii la putere este: " + calculatorStiintific.ridicareLaPutere(primulNr, alDoileaNr));

        System.out.println("Va rugam sa introduceti numarul din care se extrage radicalul: ");
        int numarRadical = scan2.nextInt();
        System.out.println("Rezultat radical este: " + calculatorStiintific.radical(numarRadical));

        System.out.println("Va rugam sa introduceti numarul pentru logaritm in baza 10: ");
        int numarLogaritmBaza10 = scan2.nextInt();
        System.out.println("Rezultat logaritm in baza 10 este: " + calculatorStiintific.logaritmBaza10(numarLogaritmBaza10));

        System.out.println("Va rugam sa introduceti numarul pentru logaritm: ");
        int numarLogaritm = scan2.nextInt();
        System.out.println("Rezultat logaritm este: " + calculatorStiintific.logaritm(numarLogaritm));

        //concateneaza 2 stringuri
        CalculatorString rezultatConcatenare = new CalculatorString();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Va rog sa introduceti primul string");
        String text1 = scanner1.nextLine();
        System.out.println("Va rog sa introduceti al doilea string");
        String text2 = scanner1.nextLine();
        System.out.println(rezultatConcatenare.concatenareStringuri(text1, text2));

        //verifica daca stringul contine un anumit caracter
        CalculatorString verificare = new CalculatorString();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Va rog sa introduceti un text");
        String text = scanner2.nextLine();
        System.out.println("Va rog sa introduceti un caracter");
        String caracter = scanner2.nextLine();
        System.out.println("Caracterul introdus este la pozitia " + verificare.contineCaracter(text, caracter));


        //aduna lungimea a 2 stringuri
        String a = "Ana are mere";
        String b = "Gina vinde pere";
        CalculatorString adunaLungimea = new CalculatorString();
        System.out.println(adunaLungimea.sumaLungimilor(a, b));

        //verifica daca lungimea unui string este numar par sau impar
        String c = "Marin munceste cu spor";
        CalculatorString verificaString = new CalculatorString();
        System.out.println(verificaString.verificareLungimeString(c));

        //transforma un string intr-un sir de caractere
        Scanner scann = new Scanner(System.in);
        System.out.println("Va rog sa introduceti un string de la tastatura");
        String scanner = scann.nextLine();
        CalculatorString sirCaractere = new CalculatorString();
        sirCaractere.arrayCaractere(scanner);

        //verifica daca stringul incepe cu o vocala
        System.out.println("Va rugam introduceti un string pentru verificare daca incepe cu o vocala");
        Scanner scan3 = new Scanner(System.in);
        String string1 = scan3.nextLine();
        CalculatorString incepeVocala = new CalculatorString();
        System.out.println(incepeVocala.vocalaText(string1));

        ////numara spatiile dintr-un string
        System.out.println("Va rugam introduceti un string pentru numararea spatiilor din string");
        String string2 = scan3.nextLine();
        CalculatorString numaraSpatii = new CalculatorString();
        System.out.println(numaraSpatii.numaraSpatiiString(string2));


    }


}
