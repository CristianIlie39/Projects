import java.io.IOException;
import java.util.ConcurrentModificationException;

public class Main {

    /*
    Se da un fisier text
    Pe fiecare rand vom avea un numar urmat de cateva cuvinte separate prin spatiu
    1) Sa se verifice cate randuri au nr de cuvinte egal cu nr de la inceputul randului
    2) Sa se verifice cate cuvinte de pe fiecare rand au nr de litere egal cu nr de la inceputul randului
    3) Sa se verifice cate cuvinte de pe fiecare rand incep cu o vocala
    4) Sa se inlocuiasca in fiecare cuvant litera corespunzatoare nr de la inceputul randului cu * (pozitia din cuvant)
    5) Sa se verifice daca nr de la inceputul randului este patrat perfect
    6) Sa se scrie intr-un alt fisier in acelasi format doar ca randurile vor incepe cu nr din primul fisier ridicat la
       puterea 3 si doar cuvintele care se termina cu vocale

     */

    public static void main(String[] args) {
        Operation operation = new Operation();
        try {
            String filePathToRead = "D:\\cursuri Alex\\RECAPITULARE\\18.10.2020\\FisierDeCitit.txt";
            String filePathToWrite = "D:\\cursuri Alex\\RECAPITULARE\\18.10.2020\\FisierDeScris.txt";
            operation.countRows(filePathToRead);
            System.out.println();
            operation.countWords(filePathToRead);
            System.out.println();
            operation.countWordsStartsWhithVowel(filePathToRead);
            System.out.println();
            operation.replaceCharacter(filePathToRead);
            System.out.println();
            operation.checkPerfectSquare(filePathToRead);
            System.out.println();
            operation.writeFile(filePathToRead, filePathToWrite);
        } catch (IOException exception) {
            System.out.println("A aparut o eroare " + exception.getMessage());
        }
    }

}
