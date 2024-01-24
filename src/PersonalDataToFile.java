import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PersonalDataToFile {

    public static void main(String[] args) {
        // Sample personal data
        String[] personalData = {"John Doe,25,123 Main St", "Jane Smith,30,456 Oak Ave", "Bob Johnson,22,789 Pine Rd"};

        // Output personal data to a file
        writeToOutputFile(personalData);
    }

    // Method to write personal data to a file using BufferedWriter
    private static void writeToOutputFile(String[] personalData) {
        String fileName = "personal_data.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String data : personalData) {
                writer.write(data);
                writer.newLine();  // Add a new line after each entry
            }

            System.out.println("Personal data has been written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
