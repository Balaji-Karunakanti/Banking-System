public class BankAccount {
    private final long accountNumber;
    private String name;
    private double balance;

    public BankAccount(long  accountNumber,String name,double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public long getAccountNumber(){
        return accountNumber;
    }
    public String getName(){
        return name;
    }
    public double getBalance(){
        return balance;
    }


    public void deposit(double deposit_amount){
        if(deposit_amount<=0){
            System.out.println("Amount cannot be Negative or Zero");
        }else{
            this.balance+= deposit_amount;
            System.out.println("Balance after deposit :" + this.balance);
        }

    }
    public void withdraw(double withdraw_amount ){
        if(withdraw_amount <100  ){
            System.out.println("Amount should be  100 or more than 100 to Withdraw");
        }else if(withdraw_amount > balance){
            System.out.println("Insufficient balance to withdraw");
        }else{
            balance-= withdraw_amount;
            System.out.println("Withdraw was Successful");
        }

        System.out.println("Balance after withdrawal : " + this.balance);

        if(balance == 0){
            System.out.println("Your account balance is zero");
        }
    }
    public void displayDetails(){
        System.out.println("Account Holder Name : " + this.name );
        System.out.println("Account Number :" + this.accountNumber);
        System.out.println("Balance : " + this.balance);
    }
}
