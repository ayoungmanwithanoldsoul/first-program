import java.util.Scanner;

public class CountIntegers {
    public static void main(String[] args) {

        System.out.print("Please input integer to count length: ");
        Scanner scan = new Scanner(System.in);
        int intInput = scan.nextInt();
        int digits = countIntegers(intInput);

        System.out.printf("\nThe number of digits based on the input integer is: %d", digits);
    }

    private static int countIntegers(int inputInt) {
        if (inputInt == 0) {
            return 0;
        }
        return 1 + countIntegers(inputInt / 10);
    }
}
