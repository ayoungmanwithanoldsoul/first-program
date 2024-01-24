import java.io.FileWriter;
import java.io.IOException;

public class ArraySumToFile {

    public static void main(String[] args) {
        // Sample array
        int[] numbers = {1, 2, 3, 4, 5};

        // Sum the array values
        int sum = sumArray(numbers); // Passing array (array number) as parameter

        // Output the sum to a file
        writeToOutputFile(sum);
    }

    // Method to sum the values of an array
    private static int sumArray(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

    // Method to write the sum to a file
    private static void writeToOutputFile(int sum) {
        String fileName = "output.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Sum of the array: " + sum);
            System.out.println("Sum has been written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
