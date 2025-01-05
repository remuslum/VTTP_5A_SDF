package src;

import java.util.Date;

public class FixedDepositAccount extends BankAccount{
    private float interest;
    private int duration;
    private boolean hasDurationChanged = false;
    private boolean hasInterestChanged = false;

    public FixedDepositAccount(String name, float balance) {
        super(name,balance);
        this.interest = 0.03f;
        this.duration = 6;
    }

    public FixedDepositAccount(String name, float balance, float interest) {
        super(name, balance);
        this.interest = interest;
        this.hasInterestChanged = !this.hasInterestChanged;
    }

    public FixedDepositAccount(String name, float balance, float interest, int duration) {
        super(name, balance);
        this.interest = interest;
        this.duration = duration;
        this.hasInterestChanged = !this.hasInterestChanged;
        this.hasDurationChanged = !this.hasDurationChanged;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void withdraw(float amount, Date date) {
        System.out.println("Unable to conduct operation");
    }

    @Override
    public void deposit(float amount, Date date) {
        System.out.println("Unable to conduct operation");
    }

}
