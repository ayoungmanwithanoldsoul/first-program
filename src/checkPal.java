import java.util.Scanner;

public class checkPal {
    private static boolean palindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < str.length(); i++, j--) {
            if (str.charAt(i) == str.charAt(j)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;
        do {
            System.out.print("Enter a word to check for a palindrome(enter \"quit\" to stop execution): ");
            word = scanner.next().toLowerCase();
            if (word.equals("quit")) {
                System.out.println("Stopping the program.........");
                break;
            }
            System.out.printf("The String that you entered is %s palindrome\n", (palindrome(word) ? "a" : "not a"));
        } while (true);
        scanner.close();
    }
}
