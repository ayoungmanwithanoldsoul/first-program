import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class SalesApp {

    private static final Scanner scanner = new Scanner(System.in);
    static File file = new File(".\\src\\salesEmployee.txt");

    static ArrayList<SalesEmployee> arrayList = new ArrayList<>();
    static ObjectOutputStream outputStream = null;
    static ObjectInputStream inputStream = null;
    static ListIterator list = null;


    public static void main(String[] args) throws Exception {

        if (file.isFile()) {
            inputStream = new ObjectInputStream(new FileInputStream(file));
            arrayList = (ArrayList<SalesEmployee>) inputStream.readObject();
            inputStream.close();
        }

        int choice = -1;

        do {
            System.out.println("Please enter the number corresponding to the action that you want:");
            System.out.println("[1] INSERT");
            System.out.println("[2] DISPLAY");
            System.out.println("[3] SEARCH");
            System.out.println("[4] DELETE");
            System.out.println("[5] UPDATE");
            System.out.println("[6] SALES AVERAGE");
            System.out.println("[0] EXIT");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Insert();
                    break;
                case 2:
                    Display();
                    break;
                case 3:
                    Search();
                    break;
                case 4:
                    Delete();
                    break;
                case 5:
                    Update();
                    break;
                case 6:
                    System.out.println("----------------------------------------".repeat(2));
                    SalesAverage();
                    System.out.println("----------------------------------------".repeat(2));
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
//                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter the corresponding option.");

            }
        } while (choice != 0);
    }

    private static void SalesAverage() {
        try {
            if (file.isFile()) {
                inputStream = new ObjectInputStream(new FileInputStream(file));
                arrayList = (ArrayList<SalesEmployee>) inputStream.readObject();
                inputStream.close();

                double employeeSales = 0;

                list = arrayList.listIterator();
                int size = 0;
                while (list.hasNext()) {
                    SalesEmployee e = (SalesEmployee) list.next();
                    employeeSales += e.employeeSales;
                    size++;
                }
                System.out.printf("Total Accumulated Sales for %d Employees is PHP %.2f\n", size, (employeeSales / size));
            } else {
                System.out.println("File Not Exists...!");
            }
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void Update() {
        // TODO Auto-generated method stub
        try {
            if (file.isFile()) {
                inputStream = new ObjectInputStream(new FileInputStream(file));
                arrayList = (ArrayList<SalesEmployee>) inputStream.readObject();
                inputStream.close();

                boolean found = false;
                System.out.print("Enter the Employee Number to Update: ");
                int employeeId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("----------------------------------------".repeat(2));
                list = arrayList.listIterator();

                while (list.hasNext()) {
                    SalesEmployee e = (SalesEmployee) list.next();
                    if (e.employeeId == employeeId) {
                        System.out.print("Enter New Employee Name: ");
                        String employeeName = scanner.nextLine();

                        System.out.print("Enter New Salary: ");
                        int accumulatedSales = scanner.nextInt();
                        list.set(new Employee(employeeId, employeeName, accumulatedSales));
                        found = true;
                    }
                }
                if (found) {
                    outputStream = new ObjectOutputStream(new FileOutputStream(file));
                    outputStream.writeObject(arrayList);
                    outputStream.close();
                    System.out.println("Record Updates Successfully...!");
                } else {
                    System.out.println("Record Not Found...!");
                }
                System.out.println("----------------------------------------".repeat(2));
            } else {
                System.out.println("File Do Not Exists...!");
            }
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void Delete() {
        // TODO Auto-generated method stub
        try {
            if (file.isFile()) {
                inputStream = new ObjectInputStream(new FileInputStream(file));
                arrayList = (ArrayList<SalesEmployee>) inputStream.readObject();
                inputStream.close();

                boolean found = false;
                System.out.println("Enter the Employee Number to Delete: ");
                int employeeId = scanner.nextInt();
                System.out.println("----------------------------------------".repeat(2));
                list = arrayList.listIterator();

                while (list.hasNext()) {
                    SalesEmployee e = (SalesEmployee) list.next();
                    if (e.employeeId == employeeId) {
                        // System.out.println(e);
                        list.remove();
                        found = true;
                    }
                }
                if (found) {
                    outputStream = new ObjectOutputStream(new FileOutputStream(file));
                    outputStream.writeObject(arrayList);
                    outputStream.close();
                    System.out.println("Sales Employee Record Deleted Successfully...!");
                } else {
                    System.out.println("Sales Employee Record Not Found...!");
                }
                System.out.println("----------------------------------------".repeat(2));
            } else {
                System.out.println("File Do Not Exist...!");
            }
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void Search() {
        // TODO Auto-generated method stub
        try {
            if (file.isFile()) {
                inputStream = new ObjectInputStream(new FileInputStream(file));
                arrayList = (ArrayList<SalesEmployee>) inputStream.readObject();
                inputStream.close();

                boolean found = false;
                System.out.print("Enter the Employee Number to Search: ");
                int employeeId = scanner.nextInt();
                System.out.println("----------------------------------------".repeat(2));
                list = arrayList.listIterator();

                while (list.hasNext()) {
                    SalesEmployee e = (SalesEmployee) list.next();
                    if (e.employeeId == employeeId) {
                        System.out.println(e);
                        found = true;
                    }
                }
                if (!found) System.out.println("Record Not Found...!");
                System.out.println("----------------------------------------".repeat(2));
            } else {
                System.out.println("File Not Exists...!");
            }
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void Display() {
        // TODO Auto-generated method stub
        try {
            if (file.isFile()) {
                inputStream = new ObjectInputStream(new FileInputStream(file));
                arrayList = (ArrayList<SalesEmployee>) inputStream.readObject();
                inputStream.close();

                System.out.println("----------------------------------------".repeat(2));

                for (SalesEmployee salesEmployee : arrayList) {
                    String row = String.valueOf(salesEmployee);
                    System.out.println(row);

                }
                System.out.println("----------------------------------------".repeat(2));
                SalesAverage();
                System.out.println("----------------------------------------".repeat(2));
            } else {
                System.out.println("File Not Exists...!");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void Insert() {
        // TODO Auto-generated method stub
        System.out.println("Please enter 10 Sales Employee:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("For Sales Employee [%d]\n", i + 1);

            System.out.print("\tEmployee ID: ");
            int employeeID = scanner.nextInt();
            scanner.nextLine();

            System.out.print("\tSales Employee Name: ");
            String employeeName = scanner.nextLine();

            System.out.print("\tSales Accumulated: ");
            int accumulatedSales = scanner.nextInt();
            scanner.nextLine();

            arrayList.add(new SalesEmployee(employeeID, employeeName, accumulatedSales));

            System.out.println("----------------------------------------".repeat(2));

            try {
                outputStream = new ObjectOutputStream(new FileOutputStream(file));
                outputStream.writeObject(arrayList);
                outputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
