package Controller;

public class PlayerTurnController {
    private int turn = 0;
    private int numOfPlayers;

    SquareController square = new SquareController();
    PlayerController playerC;

    public PlayerTurnController(int numOfPlayers){
        this.numOfPlayers = numOfPlayers;

        playerC = new PlayerController(numOfPlayers);
    }
    /*public int playerTurnCalc(int turn){
    }*/
    public PlayerController getRef(){
        return playerC;
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
