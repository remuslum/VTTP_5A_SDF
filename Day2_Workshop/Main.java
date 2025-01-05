
import java.util.Date;
import src.BankAccount;
import src.FixedDepositAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Jack");
        Date today = new Date();
        bankAccount.deposit(200.00f, today);
        bankAccount.withdraw(100.00f, today);

        try {
            bankAccount.deposit(-200.00f, today);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            bankAccount.withdraw(500.00f, today);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("Paul", 0);
        fixedDepositAccount.deposit(200.00f, today);
        fixedDepositAccount.withdraw(100.00f, today);
    }
    
}
