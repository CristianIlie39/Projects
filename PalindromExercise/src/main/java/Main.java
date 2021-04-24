public class Main {

    /*
    Create a program that checks if a number is palindrome.
    A palindrome number remains the same when its digits are reversed. Example of palindrome numbers:
    1221
    12321
    7557
     */

    public static void main(String[] args) {

        int number = 75988957;
        checkPalindromNumber(number);

    }

    public static void checkPalindromNumber(int number) {
        char[] array = String.valueOf(number).toCharArray();
        int firstChar = 0;
        int lastChar = array.length - 1;
        boolean palindrom = true;
        while (firstChar < lastChar) {
            if (array[firstChar] == array[lastChar]) {
                palindrom = true;
                firstChar++;
                lastChar--;
            } else {
                palindrom = false;
                break;
            }
        }
        System.out.println(palindrom);
    }

}
