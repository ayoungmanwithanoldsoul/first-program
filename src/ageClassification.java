import java.util.Scanner;

public class ageClassification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        if (age >= 18) {
            System.out.println("You are eligible to vote!");

            if (age >= 60) {
                System.out.println("You are a senior citizen.");
            } else if (age >= 20) {
                System.out.println("You are an adult.");
            } else {
                System.out.println("You are a young voter.");
            }
        } else {
            System.out.println("You are not eligible to vote yet.");
            if (age >= 13) {
                System.out.println("You are a teenager.");
            } else {
                System.out.println("You are a child.");
            }
        }

        scanner.close();
    }
}
