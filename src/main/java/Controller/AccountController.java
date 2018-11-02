package Controller;

import Model.Account;

public class AccountController {
    Account account;
    public AccountController() {

        account = new Account();
        account.setBalance(1000);
    }
    public void newBalance(int squareSum, PlayerTurnController player){
        player.accountUpdate(squareSum);
    }

    public int getBalance()
    {
        return getBalance();
    }
    public int resetBalance(){
        return resetBalance();
    }
}
