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

    public void roll(Player  playerM, DiceCupController diceCup, int i) {
        int currentSum = diceCup.rollAndGetSum();
        newSquare(currentSum, playerM);
    }
    public Player getRef(int i){
        return playerModels[i];
    }

    public void newSquare(int rollSum, Player playerM) {
        int newPosition;
        int oldPosition = playerM.getPosition();

        if (rollSum + oldPosition == 24) {
            newPosition = 12;
            playerM.setPosition(newPosition);

        } else if ((rollSum + oldPosition) > 12) {
            newPosition = ((rollSum + oldPosition) % 12);
            System.out.println(playerM.getPosition());
            System.out.println(rollSum);
            playerM.setPosition((newPosition));
            System.out.println(playerM.getPosition());

        } else {
            newPosition = (rollSum + oldPosition);
            System.out.println(playerM.getPosition());
            System.out.println(rollSum);
            playerM.setPosition((newPosition));
            System.out.println(playerM.getPosition());

        }
    }

    public void won(int i) {
        if (playerModels[i].getBalance().getBalance() >= 3000) setWon(true, i);
    }

    public int getPosition(int i) {
        return playerModels[i].getPosition();
    }

    public void setPosition(int newPosition, int i) {
        int oldPosition = playerModels[i].getPosition();
        playerModels[i].setPosition(oldPosition + newPosition);
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
