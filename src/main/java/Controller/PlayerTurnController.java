package Controller;

import Model.Player;

public class PlayerTurnController {

    private Player model;
    private SquareController square;

    public PlayerTurnController(Player model, SquareController square){
        this.model = model;
        this.square = square;
    }

    public void roll(DiceCupController diceCup, Player player){
        setPosition(square.newSquare(player.getPosition(), diceCup.rollAndGetSum()));
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
