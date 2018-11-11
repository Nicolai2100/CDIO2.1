package Controller;

public class PlayerTurnController {
    private int turn = 0;
    private int numOfPlayers;

    SquareController square = new SquareController();
    PlayerController [] playerCArray;

    public PlayerTurnController(int numOfPlayers){
        this.numOfPlayers = numOfPlayers;
        playerCArray = new PlayerController[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
                        playerCArray[i] = new PlayerController(i,square);
        }
    }
    /*public int playerTurnCalc(int turn){
    }*/
    public PlayerController getRef(int i){
        return playerCArray[i];
    }
    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setTurn(int currentTurn){
        this.turn = currentTurn;

    }
    public int getTurn() {
        return turn;
    }
}
