package Controller;

import Model.Player;

public class PlayerTurnController {

    private Player model;
    private PlayerTurnController ref;
    private SquareController square;
    private AccountController accountC;

    public PlayerTurnController(Player model, SquareController square){
        this.model = model;
        this.square = square;
        accountC = new AccountController();
    }

    public void roll(DiceCupController diceCup, PlayerTurnController player){
        int currentSum = diceCup.rollAndGetSum();
        newSquare(currentSum, getPosition());
        square.squareImpact(player, diceCup);
    }

    public void newSquare(int rollsum, int getSqaure){
        if (rollsum + getSqaure > 12) {
            setPosition((rollsum + getSqaure) % 12);
        }
        else{
            setPosition(rollsum + getSqaure);
        }
    }

    public void won(){
       if (accountC.getBalance() >= 3000) model.setWon(true);
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
