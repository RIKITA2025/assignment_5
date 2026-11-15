interface Bank {
    void displayBank();
}

// Customer Class
class Customer {
    String name;
    String address;

    Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    void displayCustomer() {
        System.out.println("Customer Name: " + name);
        System.out.println("Address: " + address);
    }
}

// Account Class
class Account extends Customer implements Bank {
    int accountNumber;
    double balance;

    Account(String name, String address, int accountNumber, double balance) {
        super(name, address);
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayBank() {
        System.out.println("Bank Name: State Bank of India");
    }

    void displayAccount() {
        displayBank();
        displayCustomer();

        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// Main Class
public class BankDemo {
    public static void main(String[] args) {
        Account a = new Account("Rahul", "Kolkata", 10101, 25000);

        System.out.println("Bank Account Details");
        System.out.println("--------------------");

        a.displayAccount();
    }
}