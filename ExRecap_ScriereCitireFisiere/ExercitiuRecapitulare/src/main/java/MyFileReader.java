import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {

    private static MyFileReader instance = new MyFileReader();

    private MyFileReader() {

    }

    public static MyFileReader getInstance() {
        return instance;
    }

    public List<String> readFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String text = bufferedReader.readLine();
        List<String> rowsList = new ArrayList<>();
        while (text != null && !text.isEmpty()) {
            rowsList.add(text);
            text = bufferedReader.readLine();
        }
        return rowsList;
    }

    public void displayFile(String filePath) throws IOException {
        System.out.println("Aici afisam randurile din fisier");
        for (String string : readFile(filePath)) {
            System.out.println(string);
        }
    }


}
