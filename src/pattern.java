import java.util.Scanner;

public class pattern {
	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in); 
		System.out.println("------------------ A program that prints a pattern depending on the user inputted number -------------------");
		System.out.print("Please enter the integer to create a pattern of integers: ");
				int integer =  scanner.nextInt();
		for (int i = 1; i <= integer; i++) {
			for (int j = 1; j <= i; j++){
				System.out.print(j + " ");
			}
			System.out.println();
		}
		scanner.close();
	}
}
