public class Main {

    //se da un array de caractere
    //sa se afiseze caracterele in ordinea inversa

    public static void main(String[] args) {

        char[] caractere = new char[10];
        caractere[0] = 'a';
        caractere[1] = 'b';
        caractere[2] = 'c';
        caractere[3] = 'd';
        caractere[4] = 'e';
        caractere[5] = 'f';
        caractere[6] = 'g';
        caractere[7] = 'h';
        caractere[8] = 'i';
        caractere[9] = 'j';

        afisareCaractere(caractere);

    }

    public static void afisareCaractere(char[] array) {
        for (int cursor = array.length - 1; cursor >=0; cursor--) {
            System.out.println(array[cursor]);
        }
    }

}
