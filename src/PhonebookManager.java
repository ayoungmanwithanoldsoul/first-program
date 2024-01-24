import java.io.*;
import java.util.Scanner;

public class PhonebookManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[a] Add a contact");
            System.out.println("[d] Display contacts");
            System.out.println("[x] Exit");
            System.out.print("Action: ");

            String choice = scanner.next();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case "a":
                    addContact(scanner);
                    break;
                case "d":
                    displayContacts();
                    break;
                case "x":
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a, d, or x.");
            }
        }
    }

    // Function to add a contact to the phonebook.txt file
    private static void addContact(Scanner scanner) {
        try {
            FileWriter fileWriter = new FileWriter(".\\src\\phonebook.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            System.out.println("Enter contact details:");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Birthday: ");
            String birthday = scanner.nextLine();

            System.out.print("Gender: ");
            String gender = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Contact Number: ");
            String contactNumber = scanner.nextLine();

            // Write the contact details to the file
            printWriter.println(name + "," + birthday + "," + gender + "," + age + "," + contactNumber);

            printWriter.close();
            System.out.println("Contact added successfully.");

        } catch (IOException e) {
            System.out.println("Error occurred while writing to file: " + e.getMessage());
        }
    }

    // Function to display contacts from the phonebook.txt file
    private static void displayContacts() {
        try {
            FileReader fileReader = new FileReader(".\\src\\phonebook.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String Line = "----------------------------------------";
            System.out.println(Line.repeat(2));
            System.out.printf("| %-20s | %-18s | %-7s | %-3s | %-15s |\n", "Name", "Birthday", "Gender", "Age", "Contact Number");
            System.out.println(Line.repeat(2));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] contactDetails = line.split(",");
                String name = contactDetails[0].trim();
                String birthday = contactDetails[1].trim();
                String gender = contactDetails[2].trim();
                int age = Integer.parseInt(contactDetails[3].trim());
                String contactNumber = contactDetails[4].trim();

                System.out.printf("| %-20s | %-18s | %-7s | %-3d | %-15s |\n", name, birthday, gender, age, contactNumber);
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Phonebook file not found. No contacts available.");
        } catch (IOException e) {
            System.out.println("Error occurred while reading from file: " + e.getMessage());
        }
    }
}
