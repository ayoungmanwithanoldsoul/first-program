import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class newClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double overtimeThreshold = 40.0;
        double overtimeRate = 1.5;

        // Prompt for employee information
        String employeeType;
        System.out.print("Enter employee type (full-time/part-time): ");
        employeeType = scanner.nextLine();
        while (!"full-time".equalsIgnoreCase(employeeType) && !"part-time".equalsIgnoreCase(employeeType)) {
            System.out.print("Invalid employee type.\nPlease enter employee type (full-time/part-time): ");
            employeeType = scanner.nextLine();
        }

        System.out.print("Enter employee ID: ");
        int employeeID;
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid employee ID.\nPlease enter a valid ID with only with integers: ");
        }
        employeeID = Integer.parseInt(scanner.next());
        scanner.nextLine();

        System.out.print("Enter employee name: ");
        String employeeName = scanner.nextLine();

        System.out.print("Enter hourly rate of the employee: PHP ");
        double hourlyRate = 0;// = getDoubleInput(scanner);
        boolean invalidInput = false;
        do {

                try {
                    hourlyRate = Double.parseDouble(scanner.next());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid hourly rate.\nPlease enter a valid hourly rate: PHP ");
                    invalidInput = true;
                }
        }        while(invalidInput);

        double regularPay = 0;
        double overtimePay = 0.0;
        double totalHoursMonth = 0.0;
        double totalHoursWeek;
        for (int i = 1; i <= 4; i++) {
            System.out.print("Enter total hours worked in week " + i + ": ");
            while (!scanner.hasNextDouble()) {
                scanner.next(); // Consume the invalid input
                System.out.print("Invalid input. Please enter a valid hourly rate: PHP");
            }
            totalHoursWeek = scanner.nextInt();
            totalHoursMonth += totalHoursWeek;
            if ("full-time".equalsIgnoreCase(employeeType)) {
                // if fulltime and has overtime
                if (totalHoursWeek > overtimeThreshold) {
                    overtimePay += (totalHoursWeek - overtimeThreshold) * hourlyRate * 1.5;
                }
                regularPay += hourlyRate * 40;
            } else {
                // part-time workers pay
                regularPay += hourlyRate * totalHoursWeek;
            }
        }
        double totalSalary = regularPay + overtimePay;
        // Write employee information to a text file
        try (FileWriter fileWriter = new FileWriter("employee" + employeeID + "salary.txt")) {
            fileWriter.write("---------Payroll--------\n");
            fileWriter.write("Employee ID: " + employeeID + "\n");
            fileWriter.write("Name: " + employeeName + "\n");
            fileWriter.write("Hourly rate:  PHP " + hourlyRate + "0\n");
            fileWriter.write("Employee type: " + employeeType + "\n");
            fileWriter.write("Number of hours working in a Month: " + totalHoursMonth + "\n");
            fileWriter.write("Salary: PHP " + totalSalary + "0\n");

            System.out.println(employeeName +"'s salary has been written to employee"+ employeeID + "salary.txt.");
        } catch (IOException e) {
            System.out.println("file save err");
        }
    }
}

