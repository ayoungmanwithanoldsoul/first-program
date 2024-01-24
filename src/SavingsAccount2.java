import java.util.Scanner;

public class SavingsAccount2 {

    private static double balance = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char option;
        do {
            System.out.println("[d] – Deposit\n[w] – Withdrawal\n[x] – Exit");
            System.out.print("Option: ");
            option = scanner.next().charAt(0);

            switch (option) {
                case 'd':
                    performDeposit();
                    break;
                case 'w':
                    performWithdrawal();
                    break;
                case 'x':
                    calculateInterest();
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }

        } while (option != 'x');

        System.out.println("\nBeginning of Month Balance: " + balance);
        System.out.println("Balance after the transaction: " + balance);
    }

    private static void performDeposit() {
        calculateInterest();
        System.out.println("Beginning of Month Balance: " + balance);
        System.out.print("Enter deposit amount: ");
        Scanner scanner = new Scanner(System.in);
        double depositAmount = scanner.nextDouble();

        balance += depositAmount;

        System.out.println("Balance after the transaction: " + balance);
    }

    private static void performWithdrawal() {
        calculateInterest();
        System.out.println("Beginning of Month Balance: " + balance);
        System.out.print("Enter withdrawal amount: ");
        Scanner scanner = new Scanner(System.in);
        double withdrawalAmount = scanner.nextDouble();

        if (withdrawalAmount <= balance) {
            balance -= withdrawalAmount;
            System.out.println("Balance after the transaction: " + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal not allowed.");
        }
    }

    private static void calculateInterest() {
        double yearlyRate = 0.025;
        balance += (yearlyRate / 12) * balance;
    }
}
