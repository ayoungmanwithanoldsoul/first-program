import java.util.*;

public class factorialTwo {
	
	static int gg = 53;
	
	
	public  int factorial (int x) {
		if (x == 1) {
//			System.out.println(x);
			return 1;
		}
//		System.out.print(x + " * ");
		return x * factorial(x - 1);
	}
	
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter n to calculate factorial(n): ");
		int terms = scan.nextInt();
//		System.out.print(" = " + factorial(terms));
		
//		factorial instanceOfFactorial = new factorial();
		
		System.out.print(" = " + factorial.factorial(terms));
		
		scan.close();
	}
	
//	public double factorial (double x){
//		return x;
//
//	}

}
