import java.util.Scanner;

public class Harmonic {
    public static double harmonicSeries(int n) {
        if (n == 1) {
            return 1.0;
        }
        return 1.0 / n + harmonicSeries(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        double result = harmonicSeries(n);

        System.out.printf("Sum of the harmonic series up to %d terms: %f%n", n, result);

        scanner.close();
    }
}

