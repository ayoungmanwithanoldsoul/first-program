public class EvenNum {

    public static void main(String[] args) {

        System.out.println("Even numbers from 1 to 50.");

        System.out.println("\n----------using for loop----------");
        for (int i = 1; i <= 50; i++) {
            if ((i % 2) == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n\n----------using while loop----------");
        int j = 0;
        while (j <= 50) {
            if ((j % 2) == 0) {
                System.out.print(j + " ");
            }
            j++;
        }

        System.out.println("\n\n----------using do...while loop----------");

        int k = 0;
        do {
            if ((k % 2) == 0) {
                System.out.print(k + " ");
            }
            k++;
        } while (k <= 50);
    }

}
