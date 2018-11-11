package Controller;
//klassen har fået ansvar den ikke skal have, hvorfor skulle den skabe objektet af PlayerController?

public class PlayerTurnController {
    private int turn = 0;
    private int numOfPlayers;

    public PlayerTurnController(int numOfPlayers){
        this.numOfPlayers = numOfPlayers;

    }
    // når der er 3 players,
    //j = 0 så skal i = 0
    //j = 1 så skal i = 1
    //j = 2 så skal i = 2
    //j = 3 så skal i = 0
    //j = 4 så skal i = 1

    public int calcTurn(int j) {
        int currentTurn;
        if (j < numOfPlayers){
            currentTurn = j;
        }
        else {
            currentTurn = j%numOfPlayers;
        }
        return currentTurn;
    }


    /*public int playerTurnCalc(int turn){
    }*/



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
