package Controller;

import Model.Player;
import View.Gui_Handler;

public class PlayerController {

    private SquareController square;
    private static int numOfPlayers;
    private Player [] playerModels;

    public PlayerController(int numOfPlayers) {
        playerModels = new Player[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            playerModels[i] = new Player(i);
        }
        this.square = square;
        numOfPlayers++;
    }

    public void roll(DiceCupController diceCup, int i) {
        int currentSum = diceCup.rollAndGetSum();
        newSquare(currentSum, i);
    }
    public Player getRef(int i){
        return playerModels[i];
    }

    public void newSquare(int rollSum, int i) {
        if (rollSum + playerModels[i].getPosition() == 24) {
            setPosition( 12 , i);
        } else if (rollSum + playerModels[i].getPosition() > 12) {
            setPosition((rollSum + playerModels[i].getPosition()) % 12, i);
        } else {
            setPosition(rollSum + playerModels[i].getPosition(),i);
        }
    }

    public void won(int i) {
        if (playerModels[i].getBalance().getBalance() >= 3000) setWon(true, i);
    }

    public int getPosition(int i) {
        return playerModels[i].getPosition();
    }

    public void setPosition(int position, int i) {
        playerModels[i].setPosition(playerModels[i].getPosition() + position);
    }

    public String getName(int i) {
        return playerModels[i].getName();
    }

    public void setName(String name, int i) {
        playerModels[i].setName(name);
    }

    public void updatePlayerBalance(int accountUpdate, int i) {
        playerModels[i].setBalance(accountUpdate);
    }

    public int getBalance(int i) {
        return playerModels[i].getBalance().getBalance();
    }

    public void setWon(boolean bool, int i) {
        playerModels[i].setWon(bool);
    }

    public boolean getWon(int i) {
        return playerModels[i].getWon();
    }

    public static int getNumOfPlayers(int i){
        return numOfPlayers;
    }
}
