import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MyFileReader {

    private static MyFileReader instance = new MyFileReader();

    ProductComparator productComparator = new ProductComparator();

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

    //aici fac metoda pt afisarea produselor grupate in cate o colectie in functie de tip
    public void storeProductsByType(String filePath) throws IOException {
        System.out.println("Aici afisam produsele grupate in cate o colectie diferita in functie de tip");
        List<Product> tshirtList = new ArrayList<>();
        List<Product> shirtList = new ArrayList<>();
        List<Product> jacketList = new ArrayList<>();
        for (Product product : readFile(filePath)) {
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
        for (Product product : readFile(filePath)) {
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
        for (Product product : readFile(filePath)) {
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
        for (Product product : readFile(filePath)) {
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
