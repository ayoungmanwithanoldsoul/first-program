import java.util.Scanner;

public class TwoDimensionalOperations {
    static int[] ArA = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static int[] ArB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performAddition();
                    break;
                case 2:
                    performSubtraction();
                    break;
                case 3:
                    performMultiplication();
                    break;
                case 4:
                    performDivision();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void performAddition() {
        int[][] sum = new int[10][10];

        System.out.println("Addition:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                sum[i][j] = ArA[i] + ArB[j];
            }
        }

        displayMatrix("Addition", ArA, ArB, sum);
    }

    private static void performSubtraction() {
        int[][] difference = new int[10][10];

        System.out.println("Subtraction:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                difference[i][j] = ArA[i] - ArB[j];
            }
        }

        displayMatrix("Subtraction", ArA, ArB, difference);
    }

    private static void performMultiplication() {
        int[][] multiply = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                multiply[i][j] = ArA[i] * ArB[j];
            }
        }

        displayMatrix("Multiplication", ArA, ArB, multiply);
    }

    private static void performDivision() {
        int[][] divisionResult = new int[10][10];

        System.out.println("Division:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (ArB[j] != 0) {
                    divisionResult[i][j] = ArA[i] / ArB[j];
                } else {
                    divisionResult[i][j] = Integer.MAX_VALUE; // Representing division by zero as infinity
                }
            }
        }

        displayMatrix("Division", ArA, ArB, divisionResult);
    }

    private static void displayMatrix(String operation, int[] rowValues, int[] colValues, int[][] matrix) {
        System.out.println(operation + ":");
        String sign = switch (operation) {
            case "Addition" -> "+";
            case "Subtraction" -> "-";
            case "Multiplication" -> "*";
            case "Division" -> "/";
            default -> "";
        };

        // Display column headers
        System.out.printf(" %s ", sign);
        for (int col : colValues) {
            System.out.printf("%2d ", col);
        }
        System.out.println();

        // Display matrix with row headers
        for (int i = 0; i < 10; i++) {
            System.out.printf("%2d ", rowValues[i]);
            for (int j = 0; j < 10; j++) {
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
