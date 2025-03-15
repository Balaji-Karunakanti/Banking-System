
import java.util.*;

public class BankingSystem {
    private ArrayList<BankAccount> accounts= new ArrayList<>();
    private  static  long counter = 13426738;

   public  void createAccount(String name,double initialDeposit){
       if(initialDeposit<0){
           System.out.println("Initial Deposit cannot be negative ");
           return;
       }

       long accountNumber = counter++;
       BankAccount account = new BankAccount( accountNumber,name,initialDeposit);
       accounts.add(account);

       System.out.println("Your Account is successfully created ");
       System.out.println("Your Account Number is :" + accountNumber);
   }

   public  BankAccount searchAccount(long accountNumber){
       for(BankAccount  account: accounts){
           if(account.getAccountNumber() == accountNumber){
               return account;
           }
       }
       System.out.println("Account not found ");
       return null;
   }

   public void deposit(Scanner scan ){
       System.out.println("Enter your account number :");
       long acno = scan.nextLong();
       System.out.println("Enter your deposit amount :");
       double amount = scan.nextDouble();

       BankAccount account = searchAccount(acno);

       if(account != null){
           account.deposit(amount);
       }else{
           System.out.println("Account not found");
       }
   }

   public void withdraw(Scanner scan){
       System.out.println("Enter your account number : ");
       long accountNumber = scan.nextLong();
       System.out.println("Enter your withdrawal amount : ");
       double amount = scan.nextDouble();

       if(amount <100){
           System.out.println("Withdrawal amount should be at least 100 ");
       }else{
           BankAccount account = searchAccount(accountNumber);

           if(account != null){
               account.withdraw(amount);
           }else{
               System.out.println("Account not found ");
           }
       }
   }

   public void display(){
       if(accounts.isEmpty()){
           System.out.println("No accounts found ");
       }else{
           for (BankAccount account :accounts){
               account.displayDetails();
               System.out.println("---------");
           }
       }
   }
}
