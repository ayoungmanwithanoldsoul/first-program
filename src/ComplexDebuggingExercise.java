import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ComplexDebuggingExercise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Complex Debugging Exercise!");
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();
        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);
            int sum = readAndCalculateSum(fileScanner);
            System.out.println("The sum of numbers from the file is: " + sum);
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please provide a valid file path.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in the file. Please check the file contents.");

        }
        scanner.close();

    }

    private static int readAndCalculateSum(Scanner scanner) {
        int sum = 0;
        while (scanner.hasNext())
        {
            String nextToken = scanner.next();
            System.out.println(nextToken);
            try {
                int number = Integer.parseInt(nextToken);
                if (number % 2 == 0) {
                    sum += number;

                } else {
                    sum -= number;

                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format in the file. Skipping.");

            }
        }
        return sum;

    }
}