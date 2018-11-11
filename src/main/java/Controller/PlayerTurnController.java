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
    public PlayerController getPC(){
        return playerC;
    }
    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public int calcTurn(int i) {
        int currentTurn = numOfPlayers%i;
        return currentTurn;
    }

    public void setTurn(int currentTurn){

        this.turn = currentTurn;

    }
    public int getTurn() {
        return turn;
    }
}
