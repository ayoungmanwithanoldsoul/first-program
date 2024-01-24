import java.io.InputStream;
import java.util.Scanner;

public class SumNum {

    public static int sum(int n){
        if (n == 0 || n == 1){
            return n;
        }
        return n + sum(n - 1);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("A Program to compute the sum of 1 to n");
        System.out.print("Please enter n: ");
        int n = scanner.nextInt();

        System.out.println("The sum of 1 to n is: " + sum(n));

        // Close the scanner to prevent memory leaks
        scanner.close();
    }
}
