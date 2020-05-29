import java.io.*;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) {

        //sa se modeleze un parc auto
        //masinile vor fi citite intr-un fisier
        //in fisier vom avea marca, modelul, culoarea, pretul, combustibil, anul fabricatiei (separate cu virgula)
        //3 tipuri de masini: nemtesti, frantuzesti si altele
        //o sa creem, populam si citim dintr-un fisier masinile
        //daca masina este nemteasca o scriem intr-un fisier separat, pt frantuzesti separat si pt altele separat
        //fiecare masina o sa aiba urm comportament:
        //poate fi vanduta in leasing -> putem lua de pe masina numarul de rate si cat valoreaza fiecare rata
        //la leasing trebuie sa aiba si un avans care scade din pretul total
        //masinile pot fi comparate prin calitate -> depinde de anul de fabricatie
        //masinile mai au un atribut (boolean) vandut
        //dupa ce setam campul vandut pe true, masinile vandute vor fi scrise intr-un alt fisier
        //la final afisam toate masinile vandute
        //masinile vandute o sa fie cele nemtesti care au culoarea neagra si combustibilul benzina


        //inventar:
        //avem nevoie de o clasa masina
        //o sa contina marca, model, culoare, pret, combustibil, anul fabricatiei
        //o sa aiba un camp de vanzare (boolean)
        //interfata pt leasing (vom avea getRate si getValoare)
        //implementam pt a putea compara(Comparable - interfata)
        //vom avea nevoie de un fisier de unde sa citim masinile
        //cand le citim le sortam pe fisierul respectiv
        //vom mai adauga un fisier cu masinile vandute si le vom citi


        try {
            String filePathMasiniInitial = "D:\\cursuri Alex\\ParcAuto\\MasiniInitial.txt";
            FileReader fileReaderMasiniInitial = new FileReader(filePathMasiniInitial);
            BufferedReader bufferedReaderMasiniInitial = new BufferedReader(fileReaderMasiniInitial);

            String filePathMasiniNemtesti = "D:\\cursuri Alex\\ParcAuto\\MasiniNemtesti.txt";
            FileWriter fileWriterMasiniNemtesti = new FileWriter(filePathMasiniNemtesti);
            BufferedWriter bufferedWriterMasiniNemtesti = new BufferedWriter(fileWriterMasiniNemtesti);

            String filePathMasiniFrantuzesti = "D:\\cursuri Alex\\ParcAuto\\MasiniFrantuzesti.txt";
            FileWriter fileWriterMasiniFrantuzesti = new FileWriter(filePathMasiniFrantuzesti);
            BufferedWriter bufferedWriterMasiniFrantuzsti = new BufferedWriter(fileWriterMasiniFrantuzesti);

            String filePathMasiniAltele = "D:\\cursuri Alex\\ParcAuto\\MasiniAltele.txt";
            FileWriter fileWriterMasiniAltele = new FileWriter(filePathMasiniAltele);
            BufferedWriter bufferedWriterMasiniAltele = new BufferedWriter(fileWriterMasiniAltele);

            String filePathMasiniVandute = "D:\\cursuri Alex\\ParcAuto\\MasiniVandute.txt";
            FileWriter fileWriterMasiniVandute = new FileWriter(filePathMasiniVandute);
            BufferedWriter bufferedWriterMasiniVandute = new BufferedWriter(fileWriterMasiniVandute);

            String text = bufferedReaderMasiniInitial.readLine();
            while (text != null) {
                String[] arrayWords = text.split(",");
                Masina masina = new Masina(arrayWords[0], arrayWords[1], arrayWords[2], Integer.valueOf(arrayWords[3]), arrayWords[4], Integer.valueOf(arrayWords[5]));
                System.out.println("Rata la masina " + masina.getMarca() + " " + masina.getModel() + " este: " + masina.payRate());

                if(masina.getSold()== true){
                    bufferedWriterMasiniVandute.write(text);
                    bufferedWriterMasiniVandute.flush();
                    bufferedWriterMasiniVandute.newLine();
                }

                if (masina.getMarca().equals("Audi") || masina.getMarca().equals("BMW") || masina.getMarca().equals("Mercedes") || masina.getMarca().equals("Volkswagen")) {
                    bufferedWriterMasiniNemtesti.write(text);
                    bufferedWriterMasiniNemtesti.flush();
                    bufferedWriterMasiniNemtesti.newLine();
                }

                if (masina.getMarca().equals("Renault") || masina.getMarca().equals("Peugeot") || masina.getMarca().equals("Citroen")) {
                    bufferedWriterMasiniFrantuzsti.write(text);
                    bufferedWriterMasiniFrantuzsti.flush();
                    bufferedWriterMasiniFrantuzsti.newLine();
                }

                if (masina.getMarca().equals("Toyota") || masina.getMarca().equals("Mazda") || masina.getMarca().equals("Suzuki") || masina.getMarca().equals("Tesla")) {
                    bufferedWriterMasiniAltele.write(text);
                    bufferedWriterMasiniAltele.flush();
                    bufferedWriterMasiniAltele.newLine();
                }

                text = bufferedReaderMasiniInitial.readLine();
            }

            bufferedWriterMasiniVandute.close();
            bufferedWriterMasiniNemtesti.close();
            bufferedWriterMasiniFrantuzsti.close();
            bufferedWriterMasiniAltele.close();




        } catch (Exception e) {
            System.out.println("A aparut o eroare: " + e.getMessage());
        }


    }

}
