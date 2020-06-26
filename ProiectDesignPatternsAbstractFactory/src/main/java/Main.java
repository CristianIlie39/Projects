public class Main {

    public static void main(String[] args) {

        /* Abstract Factory - Design Pattern:
           - este un design pattern creational prin care se permite crearea de familii de obiecte fara
             sa fie necesara specificarea exacta a claselor acestora
           - o fabrica abstracta este un obiect cu ajutorul caruia creem familii de obiecte
           - obiectele dintr-o familie sunt conexe sau dependende unele de altele -> sunt proiectate sa lucreze
             impreuna, iar familiile de obiecte create trebuie folosite impreuna
           - utilizeaza relatia de compozitie
         */

        /* Exemplu:
           - modelam o fabrica abstracta care produce topping-uri pentru mici si pizza
           - un topping contine la modul general sos si branza
           - topping-ul pt pizza contine sos tomat si mozzarella
           - topping-ul pt mici contine sos mustar si branza de capra

           Inventar:
           - 1 interfeta care contine comportamentul "prepara sos"
           - 1 interfata care contine comportamentul "prepara branza"
           - 4 clase care reprezinta ingredientele toppingurilor, respectiv: SosTomat, SosMustar, BranzaCapra
             si Mozzarella
           - 1 clasa abstracta fabrica de topping ---> reprezinta cheia exemplului deoarece cu ajutorul ei vom crea
             familii de obiecte
           - 2 clase fabrici de topping (una pt mici si una pt pizza) care extind clasa abstracta

         */


        //cream un obiect fabrica abstracta
        FabricaTopping fabricaTopping = new FabricaToppingMici();

        /* in continuare cream obiectele conexe care fac parte din aceeasi familie, respectiv ingredientele de tip BranzaCapra si
        de tip SosMustar; acestea formeaza o familie de obiecte deoarece toppingul pt mici nu poate exista fara unul
        dintre ele */

        fabricaTopping.produceSos();
        /* cu ajutorul obiectului fabricaTopping am apelat metoda produceSos() din
        subclasa FabricaToppingMici, prin care am creat un obiect de tip SosMustar, obiect care are in constructor
        metoda preparaSos() din interfata Sos, metoda care a fost suprascrisa in clasa SosMustar care implementeaza
        interfata Sos; la final, metoda preparaSos() afiseaza "Se prepara sosul cu mustar"; de asemenea am creat
        obiectul SosMustar fara sa fie nevoie sa specific exact in cod clasa SosMustar*/

        fabricaTopping.produceBranza();

        System.out.println("S-a produs toppingul pentru mici");

        System.out.println();


        FabricaTopping fabricaTopping2 = new FabricaToppingPizza();
        fabricaTopping2.produceSos();
        fabricaTopping2.produceBranza();
        System.out.println("S-a produs toppingul pentru pizza");


    }

}
