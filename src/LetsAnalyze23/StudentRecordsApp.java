package LetsAnalyze23;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Scanner;

public class StudentRecordsApp {

    private static final Scanner scanner = new Scanner(System.in);
    static File file = new File(".\\src\\lab\\studentRecords.data");

    static ArrayList<StudentRecord> studentList = new ArrayList<>();
    static ObjectOutputStream outputStream = null;
    static ObjectInputStream inputStream = null;
    static ListIterator<StudentRecord> list = null;

    public static void main(String[] args) throws Exception {

        if (file.isFile()) {
            inputStream = new ObjectInputStream(new FileInputStream(file));
            studentList = (ArrayList<StudentRecord>) inputStream.readObject();
            inputStream.close();
        }

        int choice = -1;

        do {
            System.out.println("Please enter the number corresponding to the action that you want:");
            System.out.println("[1] ADD STUDENT");
            System.out.println("[2] DISPLAY STUDENTS");
            System.out.println("[3] SEARCH STUDENT");
            System.out.println("[4] DELETE STUDENT");
            System.out.println("[5] UPDATE STUDENT");
            System.out.println("[6] SORT STUDENTS BY ID");
            System.out.println("[0] EXIT");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    updateStudent();
                    break;
                case 6:
                    sortStudentsById();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    break;
                default:
                    System.out.println("Please enter the corresponding option.");

            }
        } while (choice != 0);
    }

    private static void sortStudentsById() {
        Collections.sort(studentList);
        System.out.println("Students sorted by ID.");
    }

    private static void updateStudent() {
        try {
            if (file.isFile()) {
                inputStream = new ObjectInputStream(new FileInputStream(file));
                studentList = (ArrayList<StudentRecord>) inputStream.readObject();
                inputStream.close();

                boolean found = false;
                System.out.print("Enter the Student ID to Update: ");
                int studentId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("--------------------------------------------------------------------------------");
                list = studentList.listIterator();

                while (list.hasNext()) {
                    StudentRecord student = list.next();
                    if (student.studentId == studentId) {
                        System.out.println("Found a student record!!");
                        System.out.println(student);
                        System.out.println("Enter new data in the fields required");
                        System.out.print("Enter New Student Name: ");
                        String studentName = scanner.nextLine();

                        System.out.print("Enter New Grades for 5 Courses (separated by space): ");
                        int[] newGrades = new int[5];
                        for (int i = 0; i < 5; i++) {
                            newGrades[i] = scanner.nextInt();
                        }
                        list.set(new StudentRecord(studentId, studentName, newGrades));
                        found = true;
                    }
                }
                if (found) {
                    outputStream = new ObjectOutputStream(new FileOutputStream(file));
                    outputStream.writeObject(studentList);
                    outputStream.close();
                    System.out.println("Record Updated Successfully...!");
                } else {
                    System.out.println("Record Not Found...!");
                }
                System.out.println("--------------------------------------------------------------------------------");
            } else {
                System.out.println("File Does Not Exist...!");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void deleteStudent() {
        try {
            if (file.isFile()) {
                inputStream = new ObjectInputStream(new FileInputStream(file));
                studentList = (ArrayList<StudentRecord>) inputStream.readObject();
                inputStream.close();

                boolean found = false;
                System.out.print("Enter the Student ID to Delete: ");
                int studentId = scanner.nextInt();
                System.out.println("--------------------------------------------------------------------------------");
                list = studentList.listIterator();

                while (list.hasNext()) {
                    StudentRecord student = list.next();
                    if (student.studentId == studentId) {
                        System.out.println("Found a student record!!");
                        System.out.println(student);
                        list.remove();
                        found = true;
                    }
                }
                if (found) {
                    outputStream = new ObjectOutputStream(new FileOutputStream(file));
                    outputStream.writeObject(studentList);
                    outputStream.close();
                    System.out.println("Student Record Deleted Successfully...!");
                } else {
                    System.out.println("Student Record Not Found...!");
                }
                System.out.println("--------------------------------------------------------------------------------");
            } else {
                System.out.println("File Does Not Exist...!");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void searchStudent() {
        try {
            if (file.isFile()) {
                inputStream = new ObjectInputStream(new FileInputStream(file));
                studentList = (ArrayList<StudentRecord>) inputStream.readObject();
                inputStream.close();

                boolean found = false;
                System.out.print("Enter the Student ID to Search: ");
                int studentId = scanner.nextInt();
                System.out.println("--------------------------------------------------------------------------------");
                list = studentList.listIterator();

                while (list.hasNext()) {
                    StudentRecord student = list.next();
                    if (student.studentId == studentId) {
                        System.out.println("Found a student record!!");
                        System.out.println(student);
                        found = true;
                    }
                }
                if (!found) System.out.println("Record Not Found...!");
                System.out.println("--------------------------------------------------------------------------------");
            } else {
                System.out.println("File Does Not Exist...!");
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayStudents() {
        try {
            if (file.isFile()) {
                inputStream = new ObjectInputStream(new FileInputStream(file));
                studentList = (ArrayList<StudentRecord>) inputStream.readObject();
                inputStream.close();

                System.out.println("--------------------------------------------------------------------------------");
                System.out.printf("| %-15s | %-25s | %-25s | %-20s |\n", "Student ID", "Student Name", "Course Grades", "Average Grade");
                System.out.println("--------------------------------------------------------------------------------");

                list = studentList.listIterator();
                while (list.hasNext()) {
                    StudentRecord student = list.next();
                    int sumGrades = 0;
                    for (int grade : student.courseGrades) {
                        sumGrades += grade;
                    }
                    double averageGrade = sumGrades / 5.0;

                    System.out.printf("| %-15d | %-25s | %-25s | %-20.2f |\n", student.studentId, student.studentName,
                            arrayToString(student.courseGrades), averageGrade);
                }
                System.out.println("--------------------------------------------------------------------------------");
            } else {
                System.out.println("File Does Not Exist...!");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void addStudent() {
        System.out.println("Please enter 10 Student Records:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("For Student [%d]\n", i + 1);

            System.out.print("\tStudent ID: ");
            int studentId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("\tStudent Name: ");
            String studentName = scanner.nextLine();

            System.out.print("\tGrades for 5 Courses (separated by space): ");
            int[] courseGrades = new int[5];
            for (int j = 0; j < 5; j++) {
                courseGrades[j] = scanner.nextInt();
            }
            scanner.nextLine(); // consume the newline

            studentList.add(new StudentRecord(studentId, studentName, courseGrades));

            System.out.println("--------------------------------------------------------------------------------");

            try {
                outputStream = new ObjectOutputStream(new FileOutputStream(file));
                outputStream.writeObject(studentList);
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int value : array) {
            result.append(value).append(" ");
        }
        return result.toString().trim();
    }
}
