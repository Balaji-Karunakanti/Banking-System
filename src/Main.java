
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BankingSystem bank = new BankingSystem();

        while (true) {
            System.out.println("\n----- Banking System Menu -----");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Account Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scan.next();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter your Name: ");
                    scan.nextLine();
                    String name = scan.nextLine();
                    if (!name.matches("[a-zA-Z ]+")) {
                        System.out.println("Invalid name! Please enter a valid name (only alphabets and spaces allowed).");
                        continue;
                    }
                    System.out.print("Enter Initial Deposit Amount: ");
                    double deposit;
                    try {
                        deposit = scan.nextDouble();
                        scan.nextLine();
                    } catch (Exception e) {
                        System.out.println("Invalid amount! Please enter a valid number.");
                        scan.next();
                        continue;
                    }
                    bank.createAccount(name, deposit);
                    break;

                case 2:
                    bank.deposit(scan);
                    break;

                case 3:
                    bank.withdraw(scan);
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    long accNumber;
                    try {
                        accNumber = scan.nextLong();
                        scan.nextLine();
                    } catch (Exception e) {
                        System.out.println("Invalid account number! Please enter a valid number.");
                        scan.next();  // Clear invalid input
                        continue;
                    }
                    BankAccount account = bank.searchAccount(accNumber);
                    if (account != null) {
                        System.out.println("Account Balance: " + account.getBalance());
                    }
                    break;

                case 5:
                    bank.display();
                    break;

                case 6:
                    System.out.println("Exiting the Banking System. Thank you!");
                    scan.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }
}
