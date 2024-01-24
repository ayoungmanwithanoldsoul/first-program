import java.util.Scanner;

public class tellerMachine {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int input_acct, input_pin, input_amount;

        // let us assume that the customer's name is Paolo Andrew and the account number is 547047 and the savings is 10599 and the pin is 4002
        int acct_id = 547047, acct_pin = 4002;
        float acct_bal = 10599F;
        String acct_name = "Paolo Andrew Pomar";

        Scanner scan = new Scanner(System.in);
//        scan.useDelimiter(",");
//        System.out.println(scan.delimiter());

//        do {
//            int iter = 0;
//            System.out.print("Please enter account number or insert card: ");
//            input_acct = scan.nextInt();
//            iter++;
//        } while(input_acct != acct_id);


        int iter = 0;
        do {

            System.out.printf(String.format("%sPlease %sinsert card: ",
                    ((iter > 0) ? "Your card cannot be recognized.\n\n" : ""),
                    ((iter > 0) ? "re" : "")));
            input_acct = scan.nextInt();
//			System.out.println(transaction);
            iter++;
        } while (input_acct != acct_id);


//        do {
//            int iter = 0;
        System.out.print("Please enter PIN number for this account or card: ");
        input_pin = scan.nextInt();
        if (input_pin != acct_pin) {
            System.out.println("---------INCORRECT PIN-----------");
            System.out.println("---------ENDING TRANSACTION-----------");
            return;
        }
//            iter++;
//        } while(input_pin != acct_pin);


        System.out.printf(String.format("Hello %s you currently have PHP %.2f remaning balance on your account.\n", acct_name, acct_bal));

        int transaction = 0;

        try {

        } catch (Exception e) {

        }

        int iteration = 0;
        do {
            System.out.printf(String.format("%sWould you like to withdraw or deposit?\n 1. Withdraw\n 2. Deposit \n\nTransaction: ",
                    (iteration > 0) ? "You entered an incorrect input. Please try again.\n\n" : ""));
            transaction = scan.nextInt();
            System.out.println();
            iteration++;
        } while (transaction != 2 && transaction != 1);


        if (transaction == 1) {
            float withdraw;
            System.out.println("--------------- Withdrawal ---------------");
            System.out.print("Please enter the amount you want to withdraw: PHP ");
            withdraw = scan.nextFloat();

            if (withdraw > acct_bal) {
                System.out.println("----TRANSACTION UNSUCCESSFUL-----\n");
                System.out.printf(String.format("Withdraw amount PHP %.2f is greater than the balance on the account PHP %.2f", withdraw, acct_bal));
            } else {
                float prev_bal = acct_bal;

                acct_bal -= withdraw;

                System.out.println("----TRANSACTION SUCESSFUL-----\n");
                System.out.println("----RECEIPT-----");
                String receipt = String.format(
                        "Name: %s\n"
                                + "Account #: %d\n"
                                + "Transaction: %s\n"
                                + "Previous balance: PHP %.2f\n"
                                + "Balance after %s: PHP %.2f", acct_name, acct_id, ((transaction == 1) ? "withdrawal" : "deposit"), prev_bal, ((transaction == 1) ? "withdrawal" : "deposit"), acct_bal);

                System.out.print(receipt);
            }
        } else if (transaction == 2) {
            float deposit;
            System.out.println("--------------- Deposit ---------------");
            System.out.println("Please enter the amount you want to deposit: PHP ");
            deposit = scan.nextFloat();
            float prev_bal = acct_bal;
            acct_bal += deposit;
            System.out.println("----TRANSACTION SUCESSFUL-----\n");
            System.out.println("----RECEIPT-----");
            String receipt = String.format(
                    "Name: %s\n"
                            + "Account #: %d\n"
                            + "Transaction: %s\n"
                            + "Previous balance: PHP %.2f\n"
                            + "Balance after %s: PHP %.2f", acct_name, acct_id, ((transaction == 1) ? "withdrawal" : "deposit"), prev_bal, ((transaction == 1) ? "withdrawal" : "deposit"), acct_bal);

            System.out.print(receipt);
        } else {

        }


    }

}