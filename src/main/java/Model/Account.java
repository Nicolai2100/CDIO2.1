package Model;

public class Account{
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    //The balance should not be able to go into minus
    public void updateBalance(int accountUpdate) {   //The balance should not be able to go into minus
        int newBalance = (balance + accountUpdate);
        if (newBalance < 0) {
            newBalance = 0;
        }
        setBalance(newBalance);
    }
}
