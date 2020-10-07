import java.io.IOException;

public class Main {

    /*
    Intr-un fisier se afla mai multe articole de imbracaminte, fiecare articol pe cate un rand.
    Pe fiecare rand avem:
    - tipul articolului: tricou, camasa, jacheta
    - marca articolului
    - culoarea
    - marimea
    - pretul
    Cerinte:
    1. sa se citeasca articolele din fisier
    2. sa se stocheze in cate o colectie diferita in functie de tip
    3. sa se afiseze tricourile in ordinea descrescatoare a marimii
    4. sa se afiseze camasile in ordinea crescatoare a pretului
    5. sa se stocheze jachetele intr-o singura colectie grupate pe culori
     */

    public static void main(String[] args) {

        MyFileReader myFileReader = MyFileReader.getInstance();

        try {
            String filePath = "D:\\cursuri Alex\\RECAPITULARE\\04.10.2020\\fisierDeCitit.txt";
            myFileReader.displayProducts(filePath);
            myFileReader.storeProductsByType(filePath);
            myFileReader.displayTshirtsListByDecreasingSize(filePath);
            myFileReader.displayShirtsListByIncreasePrice(filePath);
            myFileReader.displayJacketsByColors(filePath);
        } catch (IOException e) {
            System.out.println("A aparut o exceptie " + e.getMessage());
        }

    }

}
