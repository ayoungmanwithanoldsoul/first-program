import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            // if the number of terms is not 0 or 1, call the function recursively
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        // Create a new instance of scanner to retrieve user input
        Scanner scanner = new Scanner(System.in);
        int terms = 0;
        // retrieve hte input
        System.out.print("Enter the number of terms to generate Fibonacci Sequence:");
//        terms = scanner.nextInt();
        try {
            terms = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect input, it must be an integer");
        }

        System.out.printf("Fibonacci sequence with %d terms: %n", terms);

        // create a loop with a length of numTerms then call the recursive func
        int term;
        int sum = 0;
        for (int i = 0; i < terms; i++) {
            term = fibonacci(i);
            sum += term;
            System.out.print(term + " ");
        }
        System.out.println();
        System.out.println("Sum: " + sum);
        scanner.close();
    }
}