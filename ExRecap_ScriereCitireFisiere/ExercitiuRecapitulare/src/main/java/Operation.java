import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Operation {

    //aici rezolv cerinta nr 1
    public void countRows(String filePath) throws IOException {
        List<String> rowsList = MyFileReader.getInstance().readFile(filePath);
        int count = 0;
        for (String row : rowsList) {
            String[] arrayWords = row.split(" ");
            if (Integer.parseInt(arrayWords[0]) == arrayWords.length - 1) {
                count++;
            }
        }
        System.out.println("Rezultatul pt cerinta 1 este: " + count + " randuri");
    }

    //aici rezolv cerinta nr 2
    public void countWords(String filePath) throws IOException {
        List<String> rowsList = MyFileReader.getInstance().readFile(filePath);
        Map<String, Integer> map = new HashMap<>();
        System.out.println("Rezultatul pt cerinta 2 este: ");
        for (String row : rowsList) {
            int count = 0;
            String[] arrayWords = row.split(" ");
            for (String word : arrayWords) {
                if (Integer.parseInt(arrayWords[0]) == word.length()) {
                    count++;
                }
            }
            map.put(row, count);
        }
        Set<String> setRows = map.keySet();
        for (String row : setRows) {
            System.out.println(row + " - " + map.get(row) + " cuvinte");
        }
    }

    //aici rezolv cerinta 3
    public void countWordsStartsWhithVowel(String filePath) throws IOException {
        List<String> rowsList = MyFileReader.getInstance().readFile(filePath);
        Map<String, Integer> map = new HashMap<>();
        System.out.println("Rezultatul pt cerinta 3 este: ");
        for (String row : rowsList) {
            int count = 0;
            String[] arrayWords = row.split(" ");
            for (String word : arrayWords) {
                word = word.toLowerCase();
                if (word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") ||
                        word.startsWith("u") || word.startsWith("ă")) {
                    count++;
                }
            }
            map.put(row, count);
        }
        Set<String> setRows = map.keySet();
        for (String row : setRows) {
            System.out.println(row + " - " + map.get(row) + " cuvinte");
        }
    }

    //aici rezolv cerinta nr 4
    public void replaceCharacter(String filepath) throws IOException {
        List<String> rowsList = MyFileReader.getInstance().readFile(filepath);
        System.out.println("Rezultatul pt cerinta 4 este: ");
        for (String row : rowsList) {
            String[] arrayWords = row.split(" ");
            for (String word : arrayWords) {
                if (Integer.parseInt(arrayWords[0]) < word.length()) {
                    char characterToReplace = word.charAt(Integer.parseInt(arrayWords[0]));
                    String text = word.replace(characterToReplace, '*');
                    System.out.println(text);
                }
            }
        }
    }

    //aici rezolv cerinta nr 5
    public void checkPerfectSquare(String filePath) throws IOException {
        List<String> rowsList = MyFileReader.getInstance().readFile(filePath);
        System.out.println("Rezultatul pt cerinta 5 este: ");
        for (String row : rowsList) {
            String[] arrayWords = row.split(" ");
            double number = Math.sqrt(Integer.parseInt(arrayWords[0]));
            int nearestNumber = (int) Math.floor(number);
            if ((number - nearestNumber) == 0) {
                System.out.println("Numarul " + Integer.valueOf(arrayWords[0]) + " este patrat perfect");
            } else {
                System.out.println("Numarul " + Integer.valueOf(arrayWords[0]) + " nu este patrat perfect");
            }
        }
    }

    //aici rezolv cerinta nr 6
    public void writeFile(String filePathToRead, String filePathToWrite) throws IOException {
        List<String> rowsList = MyFileReader.getInstance().readFile(filePathToRead); //am adus lista de randuri
        System.out.println("Rezultatul pt cerinta 6 a fost scris in fisier: ");
        FileWriter fileWriter = new FileWriter(filePathToWrite);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String row : rowsList) {
            row = row.toLowerCase();
            String[] arrayWords = row.split(" ");//aici sparg randul in cuvinte dupa spatiu " "
            //mai jos ridicam la puterea a 3-a primul numar din rand si apoi il transformam in string
            double startingNumber = Double.parseDouble(arrayWords[0]);
            double newStartingNumber = Math.pow(startingNumber, 3);
            String newStartingNumberIntoString = String.valueOf(newStartingNumber);
            arrayWords[0] = newStartingNumberIntoString;
            /*aici introduc toate cuvintele din arrayWords intr-o lista de cuvinte wordsList, pentru a putea elimina
            cuvinte din lista mai jos utilizand o complexitate O(1)*/
            LinkedList<String> wordsList = new LinkedList<>();
            for (String word : arrayWords) {
                wordsList.add(word);
            }
            /*incepand cu pozitia 1 sterg din lista toate cuvintele care se termina cu consoana si le las doar pe cele
            care se termina cu vocala; pe pozitia 0 am nevoie sa-mi ramana numarul ridicat la putere fara sa fie sters*/
            for (int cursor = 1; cursor < wordsList.size(); cursor++) {
                if (!wordsList.get(cursor).endsWith("a") && !wordsList.get(cursor).endsWith("e") &&
                        !wordsList.get(cursor).endsWith("i") && !wordsList.get(cursor).endsWith("o") &&
                        !wordsList.get(cursor).endsWith("u") && !wordsList.get(cursor).endsWith("ă")) {
                    wordsList.remove(wordsList.get(cursor));
                }
            }
            //aici actualizez randul din lista initiala rowsList
            row = "";
            for (String word : wordsList) {
                String text = word + " ";
                row += text;
            }
            //aici scriu randul in fisier
            bufferedWriter.write(row);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
