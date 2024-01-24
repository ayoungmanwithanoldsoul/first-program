import java.util.Scanner;

public class sampleProg {
    public static void main(String[] args) {
  /*      char d;
        int count;
        String order = "";
        Scanner scan = new Scanner(System.in);
        do {

            System.out.println("What is your order: ");

            count = scan.nextInt();


            switch (count) {

                case 1:

                    order += "burger \n";

                    break;

                case 2:

                    order += "fries \n";

                    break;

                case 3:

                    order += "coke \n";

                    break;

                default:

                    System.out.println("Choose your order");

            }

            System.out.println("Do you want to order anything else? (Y/N): ");

            d = scan.next().charAt(0);

        } while (d == 'Y' || d == 'y');

        System.out.println(order);

*/
        String [] names = {"Jay","Java","UM","30"};



        names[3] ="";



        for(int i=0; i < names.length;i++) {

            System.out.println(names[i]);

        }
    }

}
