package Controller;

import Model.Player;

public class PlayerController {

    private int numOfPlayers;
    private Player [] playerModels;

    public PlayerController(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        playerModels = new Player[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            playerModels[i] = new Player(i);
        }
    }

    public void roll(DiceCupController diceCup, int i) {
        int currentSum = diceCup.rollAndGetSum();
        newSquare(currentSum, i);
    }
    public Player getRef(int i){
        return playerModels[i];
    }

    public void newSquare(int rollSum, int i) {
        int newPosition;
        if (rollSum + getPosition(i) == 24) {
            newPosition = 12;
            setPosition(newPosition, i);

        } else if ((rollSum + getPosition(i)) > 12) {
            newPosition = ((rollSum + getPosition(i)) % 12);
            setPosition(newPosition, i);
            System.out.println(getPosition(i));

        } else {
            newPosition = (rollSum + getPosition(i));
            setPosition(newPosition, i);
            System.out.println(getPosition(i));
        }
    }

    public void won(int i) {
        if (playerModels[i].getBalance().getBalance() >= 3000) setWon(true, i);
    }

    public int getPosition(int i) {
        return playerModels[i ].getPosition();
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
    public int getNumOfPlayers(){
        return numOfPlayers;
    }
}
