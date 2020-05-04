public class Main {

    //se da un text
    //sa se numere cuvintele care au lungimea impara si se termina cu litera e

    public static void main (String[] args) {
        String text = "Numărul ameninţărilor informatice care exploatează subiectul pandemiei cu noul coronavirus a urcat constant în luna aprilie, pe măsură ce tot mai multe ţări au fost afectate de SARS-CoV-2, cu un plus de activitate de luni până vineri, când mai multe dispozitive sunt active, şi o uşoară domolire în weekenduri, conform datelor companiei de securitate cibernetică Bitdefender, controlată de familia Talpeş.";
        System.out.println("Numarul cuvintelor cautate este: " + numarCuvinteCautate(text));
    }

    public static int numarCuvinteCautate (String text) {
        String[] array = text.split(" ");
        int numar = 0;
        for (int cursor = 0; cursor < array.length; cursor++) {
            if (array[cursor].length() % 2 != 0 && array[cursor].endsWith("e")) {
                numar++;
            }
        }
        return numar;
    }

}
