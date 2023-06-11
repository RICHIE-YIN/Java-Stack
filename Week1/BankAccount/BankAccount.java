package BankAccount;

class BankAccount {

    // field attributes for the instance
    private double balance;
    private double int_rate;

    // static/class attributes/fields
    public static int totalAccounts;
    public static double totalDeposits;

    // constructor
    public BankAccount(double balance, double int_rate) {
        this.balance = balance;
        this.int_rate = int_rate;
        BankAccount.totalAccounts++;
    }


    @Override
    public String toString() {
        return "{" +
            " balance='" + getBalance() + "'" +
            ", int_rate='" + getInt_rate() + "'" +
            "}";
    }


    //methods

    public void deposit(double amount) {
        // this.setBalance(amount + balance);
        this.setBalance(amount + getBalance());
        BankAccount.totalDeposits += amount;
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        }
        else {
            System.out.println("Insufficient balance");
        }
    }


    //getters/setters
    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInt_rate() {
        return this.int_rate;
    }

    public void setInt_rate(double int_rate) {
        this.int_rate = int_rate;
    }





}



















