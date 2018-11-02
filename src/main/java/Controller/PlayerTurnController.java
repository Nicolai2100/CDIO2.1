package Controller;

import Model.Player;

public class PlayerTurnController {

    private Player model;
    private SquareController square;
    private AccountController accountC;

    public PlayerTurnController(Player model, SquareController square){
        this.model = model;
        this.square = square;
        accountC = new AccountController();
    }

    public int roll(DiceCupController diceCup){

        return diceCup.rollAndGetSum();

    }

    public Player getRef(){
        return model;
    }

    public int getPosition() {
        return model.getPosition();
    }

    public void setPosition(int position) {
        model.setPosition(position);
    }

    public String getName() {
        return model.getName();
    }

    public void setName(String name) {
        model.setName(name);
    }

    public void setAccountBalance(int accountUpdate)
    {

        int x = (accountC.getBalance()+accountUpdate);
        accountC.setBalance(x);
    }

    public int getBalance() {
        return accountC.getBalance();
    }

    public void setWon(boolean bool) {
        model.setWon(bool);
    }
    public boolean getWon() {
        return model.getWon();
    }



}
