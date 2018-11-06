package Controller;

import Model.Player;
import View.Gui_Handler;

public class PlayerTurnController {

    private Player model;
    private SquareController square;
    private AccountController accountC;

    public PlayerTurnController(int objectNumb, SquareController square) {
        this.model = new Player(objectNumb);
        this.square = square;
        accountC = new AccountController();
    }
    public int getObjectNumb(){
       return model.getObjectNumber();
    }

    public void roll(MessageController message, Gui_Handler gui, DiceCupController diceCup, PlayerTurnController player1) {
        int currentSum = diceCup.rollAndGetSum();
        newSquare(currentSum, getPosition());
        square.squareImpact(message, gui, player1, diceCup);
    }

    public void newSquare(int rollsum, int getSqaure) {
        if (rollsum + getSqaure == 24) {
            setPosition(12);
        } else if (rollsum + getSqaure > 12) {
            setPosition((rollsum + getSqaure) % 12);
        } else {
            setPosition(rollsum + getSqaure);
        }
    }

    public void won() {
        if (accountC.getBalance() >= 3000) setWon(true);
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
        int newBalance = (accountC.getBalance() + accountUpdate);
        if (newBalance < 0) {
            newBalance = 0;
        }
        accountC.setBalance(newBalance);
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
