import java.util.Scanner;

public class summation {
	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		System.out.println("---------- A Program that calculates summation using while loop ----------");
		System.out.print("Please enter the n to calculate Summation of 1 to n: ");
		int number  = scanner.nextInt();
		int i = 1, sum = 0;
		while (i <= number) {
			sum += i;
			System.out.printf("%d %s", i, (i == number) ? " = " + sum : " + ");
			i++;
		}
		System.out.println("\nThe sum of the item from 1 to " + number + " is: " + sum);
		scanner.close();
	}
}
