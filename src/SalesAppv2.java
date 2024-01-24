import java.io.*;
import java.util.Scanner;

public class SalesAppv2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Please enter the number corresponding to the action that you want:");
            System.out.println("[1] INSERT");
            System.out.println("[2] DISPLAY");
            System.out.println("[3] SEARCH");
            System.out.println("[4] DELETE");
            System.out.println("[5] UPDATE");
            System.out.println("[6] SALES AVERAGE");
            System.out.println("[0] EXIT");
            System.out.print("Enter your choice: ");

            String choice = scanner.next();
            scanner.nextLine(); // Consume the newline character to prevent issues

            switch (choice) {
                case "1":
                    insertData();
                    break;
                case "2":
                    displayData();
                    break;
                case "3":
                    searchData();
                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

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

    private static void searchData() {
        System.out.print("\tSearch for Employee ID: ");
        int inputID;
        inputID = SalesAppv2.scanner.nextInt();
        SalesAppv2.scanner.nextLine(); // consume newline character so that the scanner won't hav problems with \n endings
        try {
            FileReader fileReader = new FileReader(".\\src\\salesAppV2out.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            boolean found = false;
            while ((line = bufferedReader.readLine()) != null) {
                String[] dataArr = line.split(",");
                if (Integer.parseInt(dataArr[0].trim()) == inputID) {
                    int employeeID = Integer.parseInt(dataArr[0].trim());
                    String employeeName = dataArr[1].trim();
                    double accumulatedSales = Integer.parseInt(dataArr[2].trim());
                    System.out.printf("Found an employee matching the provided employee ID %d \n", inputID);
                    String Line = "----------------------------------------";
                    System.out.println(Line.repeat(2));
                    System.out.printf("| %-15s | %-18s | %-15s |\n", "Employee ID", "Employee Name", "Sales Accumulated");
                    System.out.println(Line.repeat(2));
                    System.out.printf("| %-15d | %-18s | %-17.2f |\n", employeeID, employeeName, accumulatedSales);
//                    return;
                    found = true;
                    break;
                }
            }
            if (!found) {
//                System.out.println("exxec");
                System.out.println("Employee Not Found in Directory!!!!");
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Phonebook file not found. No contacts available.");
        } catch (IOException e) {
            System.out.println("Error occurred while reading from file: " + e.getMessage());
        }
    }

    private static void displayData() {
        try {
            FileReader fileReader = new FileReader(".\\src\\salesAppV2out.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String Line = "----------------------------------------";
            System.out.println(Line.repeat(2));
            System.out.printf("| %-15s | %-18s | %-15s |\n", "Employee ID", "Employee Name", "Sales Accumulated");
            System.out.println(Line.repeat(2));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
                String[] dataArr = line.split(",");
                int employeeID = Integer.parseInt(dataArr[0].trim());
                String employeeName = dataArr[1].trim();
                double accumulatedSales = Integer.parseInt(dataArr[2].trim());

                System.out.printf("| %-15d | %-18s | %-17.2f |\n", employeeID, employeeName, accumulatedSales);
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Phonebook file not found. No contacts available.");
        } catch (IOException e) {
            System.out.println("Error occurred while reading from file: " + e.getMessage());
        }
    }

    private static void insertData() {
        System.out.println("Please enter 10 Sales Employee:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("For Sales Employee number [%d]\n", i + 1);

            System.out.print("\tEmployee ID: ");
            int employeeID = SalesAppv2.scanner.nextInt();
            SalesAppv2.scanner.nextLine();

            System.out.print("\tSales Employee Name: ");
            String employeeName = SalesAppv2.scanner.nextLine();

            System.out.print("\tSales Accumulated: ");
            int accumulatedSales = SalesAppv2.scanner.nextInt();
            SalesAppv2.scanner.nextLine();

            System.out.println("------------------------------------------");

            try {
                FileWriter fileWriter = new FileWriter(".\\src\\salesAppV2out.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                // Write the details to the file into a csv-like format
                printWriter.println(employeeID + "," + employeeName + "," + accumulatedSales);

                printWriter.close();
                System.out.println("Data added successfully.");

            } catch (IOException e) {
                System.out.println("Error occurred while writing to file: " + e.getMessage());
            }
        }
    }
}
