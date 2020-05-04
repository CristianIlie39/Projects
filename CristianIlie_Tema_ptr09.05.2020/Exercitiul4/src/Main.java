public class Main {

    //Se da un sting:
    //Sa se numere si sa se afiseze toate cuvintele care au lungimea mai mare decat 2, contin caracterul "i" si caracterul "i" se afla pe o pozitie para.

    public static void main(String[] args) {

        String text = "Legendarul investitor American, Warren Buffett, a vândut integral acţiunile deţinute de firma sa în patru companii aeriene americane, avertizând că „lumea s-a schimbat” pentru industria aviatică din cauza crizei. Într-un comentariu care va stârni valuri pe piaţa financiară deja afectată de şocul pandemiei, Buffet a spus că focarul ar putea avea o gamă „extraordinar de largă” de posibile rezultate, scriu cei de la The Guardian.";

        numarCuvinte(text);

    }

    public static int numarCuvinte(String text) {
        String[] arrayCuvinte = text.split(" ");
        int numarCuv = 0;
        System.out.println("Cuvintele cautate sunt urmatoarele:");
        for (int cursor = 0; cursor < arrayCuvinte.length; cursor++) {
            if (arrayCuvinte[cursor].length() > 2 && arrayCuvinte[cursor].contains("i") && arrayCuvinte[cursor].indexOf("i") % 2 ==0) {
                numarCuv++;
                System.out.println(arrayCuvinte[cursor]);
            }
        }
        System.out.println("Numarul cuvintelor cautate este: " + numarCuv);
        return numarCuv;

    }





}
