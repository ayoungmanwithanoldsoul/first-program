import java.util.Random;
import java.util.Scanner;

public class guessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("--------- A guessing game constructed using the do while loop ---------");
        int randInt = random.nextInt(1 + 10);
        int number = 0;
        int i = 0;
        do {
            System.out.printf("%s", (i == 0) ? "Guess a number ranging from 1 to 10: " : "Wrong integer!! " + number + " is not the correct asnwer\nEnter the correct integer again: ");
            number = scanner.nextInt();
            i++;
        } while (randInt != number);
        System.out.println("Congratulations!!! " + number + " is the correct number.");
        scanner.close();
    }
}