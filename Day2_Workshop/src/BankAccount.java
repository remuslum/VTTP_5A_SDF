package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BankAccount {
    private final String holderName;
    private final String accountNumber;
    private float accountBalance;
    private List<String> transactions;
    private boolean isClosed;
    private Date openingDate;
    private Date closingDate;

    public BankAccount(String holderName) {
        this.accountNumber = generateAccountNumber();
        this.holderName = holderName;
        this.accountBalance = 0.0f;

        if (this.transactions == null) {
            this.transactions = new ArrayList<>();
        }
    }

    public BankAccount(String holderName, float accountBalance) {
        this.accountNumber = generateAccountNumber();
        this.holderName = holderName;
        this.accountBalance = accountBalance;

        if (this.transactions == null) {
            this.transactions = new ArrayList<>();
        }
    }

    private String generateAccountNumber() {
        int startAsciiNo = 65;
        int endAsciiNo = 90;
        int accountNoLength = 10;

        Random random = new Random();
        String accountNo = "";

        for (int i = 0; i < accountNoLength; i++) {
            int randomValue = startAsciiNo + random.nextInt(endAsciiNo - startAsciiNo + 1);
            accountNo += (char) randomValue;
        }
        return accountNo;
    }

    public String getHolderName() {
        return holderName;
    }

    // public void setHolderName(String holderName) {
    //     this.holderName = holderName;
    // }

    public String getAccountNumber() {
        return accountNumber;
    }

    // public void setAccountNumber(String accountNumber) {
    //     this.accountNumber = accountNumber;
    // }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public boolean isIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public void deposit(float amount, Date date) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Incorrect amount given");
        } 
        accountBalance += amount;
        System.out.printf("deposit %.2f at %s \n", amount, date.toString());
    }

    public void withdraw (float amount, Date date) throws IllegalArgumentException {
        if (amount <= 0 || amount > accountBalance) {
            throw new IllegalArgumentException("Invalid amount given");
        }
        accountBalance -= amount;
        System.out.printf("withdraw %.2f at %s \n", amount, date.toString());

    }

}