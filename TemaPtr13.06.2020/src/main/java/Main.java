import java.lang.annotation.Documented;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        1.sa se modeleze un calculator doar cu operatiile de baza adunare, scadere, inmultire si impartire, dar pt numere foarte mari
        cel putin 15 cifre: ex 123456789123456, 823567412589879
        2.sa se citeasca si sa se documenteze despre folosirea enumeratiilor in Java: ce clase exista? + 2 exercitii care sa exemplifice folosirea lor
        3.sa se citeasca si sa se documenteze despre relatia de compozitie
        4.sa se citeasca si sa se documenteze despre alte 2 metode folosite pt a parcurge o colectie: 2 exemple
        5.sa se citeasca si sa se documenteze despre schimbarile aparute in Java 8 in ceea ce priveste interfetele: 2 exemple
        */



        /*  1.sa se modeleze un calculator doar cu operatiile de baza adunare, scadere, inmultire si impartire, dar pt numere foarte mari
        cel putin 15 cifre: ex 123456789123456, 823567412589879 */

        long a = 123456789123456L; // am pus L la finalul numarului ca sa-l recunoasca ca fiind de tipul long, altfel il vede de tipul int

        long b = 823567412589879L;

        Calculator calculator = new Calculator();

        System.out.println("Afisam adunarea: " + calculator.adunare(a, b));
        System.out.println("Afisam scaderea: " + calculator.scadere(a, b));
        System.out.println("Afisam inmultirea: " + calculator.inmultire(a, b));
        System.out.println("Afisam impartirea: " + calculator.impartire(a, b));

        System.out.println();


        /*  2.sa se citeasca si sa se documenteze despre folosirea enumeratiilor in Java: ce clase exista? + 2 exercitii
         care sa exemplifice folosirea lor

Enumeratia: - este un tip de data folosita pentru a controla valorile posibile ale unei variabile, adica este
              un tip de data ce ne lasa sa alegem doar una dintre mai multe valori posibile (denumite constante) ale
              unei variabile
            - este o clasa speciala care contine in denumire cuvantul cheie "enum"
            - contine un set de constante (sunt declarate implicit public, static si final; nu pot fi modificate si nici suprascrise)
            - constantele sunt urmate de "," virgula; dupa ultima constanta se poate pune ";" sau nu (";" este optional)
              dar daca se pune totusi ";" dupa o constanta => s-a terminat enumerarea constantelor
            - conform conventiilor de nume recomandate de Java, constantele se scriu cu majuscule, dar programul
              ruleaza chiar daca sunt scrise cu litere mici; deci nu e gresit daca se scriu cu litere mici
            - poate exista (poate fi declarata) ca o clasa separata, ori ca o clasa interioara altei clase dar in afara
              oricarei alte metode din clasa respectiva
            - poate contine atribute, metode si constructori
            - enumeratiile NU pot fi folosite pentru crearea de obiecte/ NU pot fi instantiate; singurele instante sunt
              cele definite de propriile constante -> doar pt aceste instante sunt apelati constructorii
            - extinde implicit clasa parinte Enum si nu mai poate extinde alta clasa, dar poate implementa mai multe
              interfete
            - mai multe informatii despre enumeratii sunt in sectiunea 8.9 of The Java™ Language Specification.

            - exemple de clase separate ---> LengthUnit
                                        ---> EngineType

        public enum LengthUnit {                public enum EngineType {
            METER,                                  GAS,
            CENTIMETER,                             DIESEL,
            FOOT,                                   ELECTRIC,
            INCH                                    HYBRID
        }                                       }


        - constantele din cadrul enumeratiilor pot fi accesate prin sintaxa de mai jos: */

        LengthUnit meterUnit; /*  am declarat variabila meterUnit care este de tipul LengthUnit */
        meterUnit = LengthUnit.METER; /* am initializat variabila meterUnit cu valoarea METER; deoarece variabila are ca
        tip o enumeratie, ea poate lua valori DOAR dintre constantele dn cadrul enumeratiei */
        System.out.println("We display the unit of measure for length: " + meterUnit);
        System.out.println(meterUnit.convertToMeters()); // am apelat metoda convertToMeter din enumeratia LengthUnit
        System.out.println(LengthUnit.CENTIMETER.convertToMeters()); // am apelat metoda convertToMeter din enumeratia LengthUnit

        EngineType engineType = EngineType.ELECTRIC; //am declarat si initializat variabila engineType
        System.out.println("We display the type of engine: " + engineType); //am afisat variabila engineType

        /* - folosirea unei enumeratii su switch */
        LengthUnit unit = LengthUnit.INCH;
        switch (unit) {
            case METER:
                System.out.println("Meter unit is selected");
                break;
            case CENTIMETER:
                System.out.println("Centimeter unit is selected");
                break;
            case FOOT:
                System.out.println("Foot unit is selected");
                break;
            case INCH:
                System.out.println("Inch unit is selected");
        }

        /* exemple de enumeratii sub forma de clase interioare clasei Main ---> clasa public enum Level ---> de mai jos din afara metodei main
                                                                           ---> clasa public enum Colors ---> de mai jos din afara metodei main: */

        Level personLevel; /* am declarat variabila personLevel de tipul Level; variabila poate lua valori doar dintre
        constantele din enumeratia Level */
        personLevel = Level.HIGH; //am initializat variabila personLevel cu valoarea HIGH din cadrul enumeratiei Level
        System.out.println("We display the person's level of training: " + personLevel);

        Colors color = Colors.green;
        System.out.println("We display the color: " + color);


        /* Parcurgerea unui enumeratii si afisarea fiecarei constante din cadrul enumeratiei
        cu bucla for si metoda value() -> returneaza un array format din constantele enumeratiei in ordinea declararii lor */

        for (EngineType engineType1 : EngineType.values()) {
            System.out.println(engineType1);
        }

        /* Exercitiu cu enumeratii
        Create enum Planets.
            a) Override toString method. It should print relative size of a planet and it’s name. E.g. „Huge Jupiter”, „Small Pluto”.
            b) Create distanceFromEarth method.
            c) Verify both methods for multiple planets.
         */

        //aici apelam metodele toString() si distanceFromEarth()
        for (Planets planet : Planets.values()) {
            System.out.println("The distance between " + planet.toString() + " and Earth is " + planet.distanceFromEarth());
        }


        /* 3.sa se citeasca si sa se documenteze despre relatia de compozitie

    Compozitia:
        - ne permite sa modelam obiecte care sunt alcatuite din alte obiecte; adica un obiect il compune pe altul
          sau un obiect il contine pe altul
        - obiectul continut nu poate exista fara obiectul proprietar
        - intre cele 2 obiecte exista o relatie "has-a"
        - inseamna folosirea unui obiect ca tip de atribut al altui obiect;

          Exemplul 1 : atributele din clasa ComputerSet sunt de tipul Mouse si Monitor
          Exemplul 2 : clasele Job si Person ---> Person has a Job
          */

        Person person = new Person();
        long personSalary = person.getPersonSalary();
        System.out.println("Salariul este " + personSalary + " EUR");



    }

    public enum Level {
        LOW,
        MEDIUM,
        HIGH
    }

    public enum Colors {
        red,
        yellow,
        green
    }


}
