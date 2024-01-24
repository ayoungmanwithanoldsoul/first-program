import java.util.Scanner;

public class pyramid {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("------------------ A program that prints a pattern depending on the user inputted number -------------------");
        System.out.print("Please enter the integer to create a pattern of integers: ");
        int integer =  scanner.nextInt();
        for (int i = 1; i <= integer; i++) {
//            for (int j = (integer/2); j >= 0; j--){
//                System.out.print("#");
//            }
            for (int j = (integer - i); j >= 0; j--){
                System.out.print(" " + " ");
            }
            for (int k = 1; k <= i; k++){
                System.out.print("*" + " ");
            }
            for (int k = 1; k <= i; k++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
//        for (int i = 0; i <= integer; i++){
//            for (int j = (integer - i); j >= 0; j--){
//                System.out.print("# ");
//            }
//            System.out.println("_");
//        }
        scanner.close();
    }
}
