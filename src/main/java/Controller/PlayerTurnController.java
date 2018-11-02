package Controller;

import Model.Player;

public class PlayerTurnController {

    private Player model;
    private SquareController square;
    private AccountController account;

    public PlayerTurnController(Player model, SquareController square){
        this.model = model;
        this.square = square;
        account = new AccountController();
    }

    public void roll(DiceCupController diceCup, Player player){
        square.newSquare(player.getPosition(), diceCup.rollAndGetSum());

    }

    public void accountUpdate(int accountUpdate)
    {
        model.setBalance(account.getBalance()+accountUpdate);
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

    public int getBalance() {
        return model.getBalance();
    }

    public void setWon(boolean bool) {
        model.setWon(bool);
    }
    public boolean getWon() {
        return model.getWon();
    }



}
