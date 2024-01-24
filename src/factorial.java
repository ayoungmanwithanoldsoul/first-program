import java.util.*;
public class factorial {

    public static int factorial (int terms){
        if (terms == 1){
            return 1;
        }
        return terms * factorial(terms - 1);
    }
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("------------------A program that computes factorial---------------");
        System.out.print("please enter the number of terms factorial(n): ");
        int terms = scan.nextInt();
        System.out.println(factorial(terms));
        scan.close();
    }
}
