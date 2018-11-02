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
        square.newSquare(player.getPosition(),diceCup.rollAndGetSum());
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



}
