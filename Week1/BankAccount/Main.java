package BankAccount;

public class Main {
    
    public static void main(String[] args) {
        BankAccount checkingAccount = new BankAccount(3000, 0);
        BankAccount savingsAccount = new BankAccount(8000, 0);
        savingsAccount.deposit(10000);
        checkingAccount.withdraw(100);
        System.out.println(checkingAccount);
        System.out.println(savingsAccount);
        System.out.println(BankAccount.totalAccounts);
        System.out.println(checkingAccount.getBalance());
    }
}
