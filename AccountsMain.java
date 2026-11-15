
abstract class Accounts {
    double balance;
    int accountNumber;
    String accountHoldersName;
    String address;

    Accounts(double balance, int accountNumber,
             String accountHoldersName, String address) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountHoldersName = accountHoldersName;
        this.address = address;
    }

    abstract void withdrawl(double amount);
    abstract void deposit(double amount);

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHoldersName);
        System.out.println("Address: " + address);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends Accounts {
    double rateOfInterest;

    SavingsAccount(double balance, int accountNumber,
                   String name, String address, double rate) {
        super(balance, accountNumber, name, address);
        rateOfInterest = rate;
    }

    void withdrawl(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful");
        } else {
            System.out.println("Invalid amount or Insufficient Balance");
        }
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful");
        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }

    void calculateAmount() {
        double interest = balance * rateOfInterest / 100;
        System.out.println("Interest: " + interest);
        System.out.println("Total Amount: " + (balance + interest));
    }
}

public class AccountsMain {
    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount(
            10000, 101, "Rikita", "Kolkata", 5
        );

        s.display();
        s.deposit(2000);
        s.withdrawl(3000);
        s.calculateAmount();
        s.display();
    }
}

