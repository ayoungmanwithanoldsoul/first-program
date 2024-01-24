import java.util.Scanner;

public class ProductInventoryManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Define the structure of the inventory
        int rows = 3;
        int columns = 3;
        String[][] inventory = new String[rows][columns];

        // Categorize products tat we will use as look up table
        String[] categoryA = {"Pepsi", "Coke Zero", "Sprite"};
        String[] categoryB = {"Corned Beef", "Tuna", "Beef loaf"};
        String[] categoryC = {"Evap Milk", "Condensed Milk", "Kremdensada"};

        String[][] categoryLookup = {categoryA, categoryB, categoryC};

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[a] Add a product");
            System.out.println("[d] Display inventory");
            System.out.println("[x] Exit");
            System.out.print("Action: ");

            String choice = scanner.next();
            scanner.nextLine(); // Consume the newline character to prevent issues

            switch (choice) {
                case "a":
                    addProductToInventory(inventory, categoryLookup);
                    break;
                case "d":
                    displayInventory(inventory);
                    break;
                case "x":
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a, b, or c.");
            }
        }
    }

    // Function to add a product to the inventory
    private static void addProductToInventory(String[][] inventory, String[][] categoryLookup) {
        System.out.println("Enter the product name:");
        String product = scanner.nextLine();

        for (int i = 0; i < categoryLookup.length; i++) {
            for (int j = 0; j < categoryLookup[i].length; j++) {
                if (product.equalsIgnoreCase(categoryLookup[i][j])) {
                    // Find the first available slot in the inventory for the category
                    for (int k = 0; k < inventory[i].length; k++) {
                        if (inventory[i][k] == null) {
                            inventory[i][k] = product;
                            System.out.println(product + " added to Category " + (char) ('A' + i));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Product not found in the specified categories.");
    }

    // Function to display the organized inventory
    private static void displayInventory(String[][] inventory) {
        System.out.println("-------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s |\n", "Category A", "Category B", "Category C");
        System.out.println("-------------------------------");

        for (String[] strings : inventory) {
            System.out.print("|");
            for (String string : strings) {
                System.out.printf(" %-15s |", string != null ? string : "Empty");
            }
            System.out.println();
        }

        System.out.println("-------------------------------");
    }
}
