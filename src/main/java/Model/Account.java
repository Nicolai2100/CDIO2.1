package Model;

public class Account {
    int balance;
    public Account(int balancetal){
        this.balance=balancetal;
    }
    public void deposit(int amount){
        balance=balance+amount;
    }
    public void withdraw(int amount){
        balance=balance-amount;
    }
    public int getBalance(){
        return balance;
    }
    public int resetBalance(){
        return balance=0;
    }
}