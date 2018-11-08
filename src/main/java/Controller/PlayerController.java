package Controller;

import Model.Player;
import View.Gui_Handler;

public class PlayerController {

    private Player model;
    private SquareController square;

    public PlayerController(int objectNumb, SquareController square) {
        this.model = new Player(objectNumb);
        this.square = square;
    }
    public int getObjectNumb(){
       return model.getObjectNumber();
    }

    public void roll(Gui_Handler gui, DiceCupController diceCup, PlayerController player1) {
        int currentSum = diceCup.rollAndGetSum();
        newSquare(currentSum, getPosition());
        square.squareImpact(gui, player1, diceCup);
    }

    public void newSquare(int rollSum, int playerPosition) {
        if (rollSum + playerPosition == 24) {
            setPosition(12);
        } else if (rollSum + playerPosition > 12) {
            setPosition((rollSum + playerPosition) % 12);
        } else {
            setPosition(rollSum + playerPosition);
        }
    }

    public void won() {
        if (model.getBalance().getBalance() >= 3000) setWon(true);
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

    public void updateAccountBalance(int accountUpdate) {   //The balance should not be able to go into minus
        int newBalance = (model.getBalance().getBalance() + accountUpdate);
        if (newBalance < 0) {
            newBalance = 0;
        }
        model.setBalance(newBalance);
    }

    public int getBalance() {
        return model.getBalance().getBalance();
    }

    public void setWon(boolean bool) {
        model.setWon(bool);
    }

    public boolean getWon() {
        return model.getWon();
    }
}
