import java.io.IOException;
import java.util.*;

public class Solution {

    MyFileReader myFileReader = MyFileReader.getInstance();

    ProductComparator productComparator = new ProductComparator();

    //aici fac metoda pt afisarea produselor grupate in cate o colectie in functie de tip
    public void storeProductsByType(String filePath) throws IOException {
        System.out.println("Aici afisam produsele grupate in cate o colectie diferita in functie de tip");
        List<Product> tshirtList = new ArrayList<>();
        List<Product> shirtList = new ArrayList<>();
        List<Product> jacketList = new ArrayList<>();
        for (Product product : myFileReader.readFile(filePath)) {
            if (product.getType().contains("tricou")) {
                tshirtList.add(product);
            } else if (product.getType().contains("camasa")) {
                shirtList.add(product);
            } else if (product.getType().contains("jacheta")) {
                jacketList.add(product);
            } else {
                System.out.println("produsul nu exista");
            }
        }
        for (Product product : tshirtList) {
            System.out.println(product.toString());
        }
        for (Product product : shirtList) {
            System.out.println(product.toString());
        }
        for (Product product : jacketList) {
            System.out.println(product.toString());
        }
    }

    //aici fac metoda pt sortarea si afisarea din fisier a tricourilor in ordinea descrescatoare a marimii
    public void displayTshirtsListByDecreasingSize(String filePath) throws IOException {
        System.out.println("Aici afisam tricourile in ordinea descrescatoare a marimii");
        List<Product> productList = new ArrayList<>();
        for (Product product : myFileReader.readFile(filePath)) {
            if (product.getType().equals("tricou")) {
                productList.add(product);
            }
        }
        Collections.sort(productList, productComparator.reversed());
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    //aici fac metoda pt sortarea si afisarea din fisier a camasilor in ordinea crescatoare a pretului
    public void displayShirtsListByIncreasePrice(String filePath) throws IOException {
        System.out.println("Aici afisam camasile in ordinea crescatoare a pretului");
        List<Product> productList = new ArrayList<>();
        for (Product product : myFileReader.readFile(filePath)) {
            if (product.getType().equals("camasa")) {
                productList.add(product);
            }
        }
        Collections.sort(productList, productComparator);
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    //aici facem metoda pt stocarea jachetelor intr-o colectie, grupate pe culori
    public void displayJacketsByColors(String filePath) throws IOException {
        System.out.println("Aici stocam jachetele intr-o singura colectie grupate pe culori");
        Map<String, ArrayList<Product>> jacketsMapByColor = new HashMap<>();
        for (Product product : myFileReader.readFile(filePath)) {
            jacketsMapByColor.put(product.getColor(), new ArrayList<>());
            if (product.getType().equalsIgnoreCase("jacheta")) {
                jacketsMapByColor.get(product.getColor()).add(product);
            }
            ArrayList<Product> jacketList = jacketsMapByColor.get(product.getColor());
            for (Product product1 : jacketList) {
                System.out.println(product1.toString());
            }
        }



    }

}
