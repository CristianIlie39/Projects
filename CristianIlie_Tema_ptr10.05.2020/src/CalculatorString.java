public class CalculatorString extends CalculatorStiintific {

    //concateneaza 2 stringuri
    //verifica daca stringul contine un anumit caracter
    //aduna lungimea a 2 stringuri
    //verifica daca lungimea unui string este numar par sau impar
    //transforma un string intr-un sir de caractere
    //verifica daca stringul incepe cu o vocala
    //numara spatiile dintr-un string

    public CalculatorString() {

    }

    public String concatenareStringuri(String text1, String text2) {
        return "Rezultatul concatenarii stringurilor este: " + text1.concat(text2);
    }

    public int contineCaracter(String text, String caracter) {
            return text.indexOf(caracter);
    }

    public String sumaLungimilor(String text1, String text2) {
        return "Suma lungimilor celor 2 stringuri este: " + (text1.length() + text2.length());
    }

    public String verificareLungimeString(String text) {
        if (text.length() % 2 == 0) {
            return "Lungimea stringului este numar par";
        } else {
            return "Lungimea stringului este numar impar";
        }
    }

    public char[] arrayCaractere(String text) {
        char[] array = new char[text.length()];
        for (int cursor = 0; cursor < array.length; cursor++) {
            array[cursor] = text.charAt(cursor);
            System.out.println(array[cursor]);
        }
        return array;

    }

    public String vocalaText(String text) {
        char primaLitera = text.charAt(0);
        if (primaLitera == 'a' || primaLitera == 'e' || primaLitera == 'i' || primaLitera == 'o' || primaLitera == 'u') {
            return "Prima litera este o vocala";
        } else {
            return "Prima litera nu este o vocala";
        }
    }

    public int numaraSpatiiString(String text) {
        int nrSpatii = 0;
        for (int cursor = 0; cursor < text.length(); cursor++) {
            if (text.charAt(cursor) == ' ') {
                nrSpatii++;
            }
        }
        return nrSpatii;
    }



}
