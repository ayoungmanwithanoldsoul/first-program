//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FinalLabExam {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // this is the containter of the nubmer of iteration
        int iterations = 0;
        // TODO Auto-generated method stub
        System.out.println("running method 1...");
        iteration();


        System.out.println("running method 2...");
        arrayMethod();

    }


    public static int iteration (){

        // this is the container for the nubmer inputted
        int x = 0;
        // this is the containter for the  array of integers in the string format
        String arrString = "";

        System.out.print("Please enter number of iterations: ");

        x = scan.nextInt();


        for (int i = 1, temp = 1; i <= x; i++, temp+=i) {
            arrString = arrString + " " + temp;
        }
        System.out.println(arrString);

        try {
            FileWriter fwriter =  new FileWriter("Iteration.txt", true);
            fwriter.write(arrString);
            fwriter.write(arrString);
            fwriter.close();
            System.out.println("writing");
        } catch (Exception e) {
            System.out.println("error");
        }

        return x;
    }



    public static double arrayMethod (){
        System.out.print("Please enter number of iterations: ");
        int y = Integer.parseInt(scan.next());

        int [] inputArray = new int[y];
        int sum = 0;
        double ave;

        for (int i = 0; i < y; i++) {
            System.out.printf("Input sample for [%s]: ", i+1);
            int temp = scan.nextInt();
            inputArray[i] = temp;
            sum += temp;
        }

        ave = (double) sum / y;
        System.out.printf("Average: %.2f\n", ave);
        System.out.println("Total: " + sum);

        try {
            FileWriter fwriterarray = new FileWriter("array.txt", true);
            for (int i = 0; i < inputArray.length; i++) {
                fwriterarray.write(inputArray[i] + " ");
            }
            fwriterarray.write(sum + " ");
            fwriterarray.write(String.format("%.2f", ave));

            fwriterarray.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scan.close();
        return y;
    }
}
