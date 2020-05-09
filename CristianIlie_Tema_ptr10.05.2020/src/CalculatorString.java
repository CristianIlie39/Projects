public class CalculatorString {

    //concateneaza 2 stringuri
    //verifica daca stringul contine un anumit caracter
    //aduna lungimea a 2 stringuri
    //verifica daca lungimea unui string este numar par sau impar
    //transforma un string intr-un sir de caractere
    //verifica daca stringul incepe cu o vocala
    //numara spatiile dintr-un string

    public CalculatorString() {

    }

    public String concatenareStringuri(String a, String b) {
        return "Rezultatul concatenarii stringurilor este: " + a.concat(b);
    }

    public String verificaCaracter(String a) {
        if (a.contains("f")) {
            return "Stringul contine caracterul f";
        } else {
            return "Stringul nu contine caracterul f";
        }
    }

    public String sumaLungimilor(String a, String b) {
        return "Suma lungimilor celor 2 stringuri este: " + (a.length() + b.length());
    }

    public String verificareLungimeString(String a) {
        if (a.length() % 2 == 0) {
            return "Lungimea stringului este numar par";
        } else {
            return "Lungimea stringului este numar impar";
        }
    }

    public char[] arrayCaractere(String string) {
        char[] array = new char[string.length()];
        for (int cursor = 0; cursor < array.length; cursor++) {
            array[cursor] = string.charAt(cursor);
            System.out.println(array[cursor]);
        }
        return array;

    }


}
