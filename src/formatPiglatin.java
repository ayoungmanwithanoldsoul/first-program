import java.util.Scanner;

public class formatPiglatin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;
        do {
            System.out.print("Please enter any word (enter \"quit\" to stop): ");
            word = scanner.next().toLowerCase();
            if (word.equals("quit")) {
                System.out.println("Stopping the program.........");
                break;
            }
            System.out.println(meth1(word));
        } while (true);
        scanner.close();
    }

    private static String meth1(String str) {
        String newStr = "";
        for (int i = 1; i < str.length(); i++) {
            newStr = newStr + str.charAt(i);
        }
        newStr += str.charAt(0) + "ay";
        return newStr;
    }
}