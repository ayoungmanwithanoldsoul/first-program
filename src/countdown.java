import java.util.Scanner;

public class countdown {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("----------- A countdown Program using while loop -----------");
		System.out.print("Please enter seconds: ");
		Scanner scanner =  new Scanner(System.in);
		int seconds = scanner.nextInt();
		int i = seconds;
		while(i > 0){
			System.out.printf("%d second%s remaining\n", i, (i == 1) ? "" : "s");
			i--;
			Thread.sleep(1000);

		}
		System.out.println("----------The "+seconds+" second countdown ended-----------");
		scanner.close();
	}
}