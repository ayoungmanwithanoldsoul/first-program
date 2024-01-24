import java.util.Scanner;

public class identityCheck {
    public static void main(String[] args) {
        System.out.println("_______IDENTITY CHECKER_______");
        Scanner scanner = new Scanner(System.in);
        String name;
        boolean match = false;
        do {
            System.out.print("Enter firstname: ");
            name = scanner.next().toLowerCase();
            for (int i = 0; (i < name.length()) && (name.length() > 3); i++) {
                if (i + 4 == name.length() && (i + 3 > name.length() ? name.charAt(i + 2) != 's' : name.charAt(i + 3) != 's')) {
                    break;
                }
                if (name.charAt(i) == 'i' && name.charAt(i + 1) == 's' && name.charAt(i + 2) == 'i' && name.charAt(i + 3) == 's') {
                    System.out.println("----WARNING!! CHECK IDENTITY----");
                    match = true;
                    break;
                }
            }
        } while (!match);
        scanner.close();
    }
}
