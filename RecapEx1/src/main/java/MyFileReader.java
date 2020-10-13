import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MyFileReader {

    private static MyFileReader instance = new MyFileReader();

    private MyFileReader() {

    }

    public static MyFileReader getInstance() {
        return instance;
    }

    //aici fac metoda pentru citire articole de imbracaminte din fisier
    public List<Product> readFile(String filePath) throws IOException {
        List<Product> productList = new ArrayList<>();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String text = bufferedReader.readLine();
        while (text != null && !text.isEmpty()) {
            String[] arrayWords = text.split(";");
            Product product = new Product(arrayWords[0], arrayWords[1], arrayWords[2], Integer.valueOf(arrayWords[3]), Integer.valueOf(arrayWords[4]));
            productList.add(product);
            text = bufferedReader.readLine();
        }
        return productList;
    }

    //aici fac metoda pt afisare articole de imbracaminte din fisier
    public void displayProducts(String filePath) throws IOException {
        System.out.println("Aici afisam articolele de imbracaminte din fisier");
        for (Product product : readFile(filePath)) {
            System.out.println(product.toString());
        }
    }

}
