public class Main {

    //avem un vector cu 10 elemente int
    //sa se returneze cel mai mare numar

    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;
        array[4] = 4;
        array[5] = 5;
        array[6] = 6;
        array[7] = 7;
        array[8] = 8;
        array[9] = 9;

        System.out.println("Cel mai mare numar este: " + celMaiMareNumar(array));

    }

    public static int celMaiMareNumar(int[] array) {
        int numar = 0;
        for (int cursor = 0; cursor < array.length; cursor++) {
            if (array[cursor] > numar) {
                numar = array[cursor];
            }
        }
        return numar;
    }


}
