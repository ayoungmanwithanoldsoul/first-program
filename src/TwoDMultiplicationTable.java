public class TwoDMultiplicationTable {
    static int[] ArA = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static int[] ArB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        int[][] multiply = new int[10][10];

        System.out.println("Multiplication Table: ");
        // Print the header 123445678910
        System.out.print(" * ");
        for (int k = 0; k < 10; k++) {
            System.out.printf("%2d ", ArA[k]);
        }
        System.out.println();

        // Multiply numbers
        for (int i = 0; i < 10; i++) {
            System.out.printf("%2d ", ArA[i]); // Print row header

            for (int j = 0; j < 10; j++) {

                multiply[i][j] = ArA[i] * ArB[j]; // Correct multiplication
                System.out.printf("%2d ", multiply[i][j]); // Print multiplication result
            }

            System.out.println(); // Move to the next line after each row
        }
    }
}
