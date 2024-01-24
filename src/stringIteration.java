import java.util.Scanner;

public class stringIteration {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("please enter name");
		String name = scan.nextLine();
		
		for (int i = 0; i < name.length(); i++) {
			System.out.println(name.charAt(i));
		}
		scan.close();
	}

}
