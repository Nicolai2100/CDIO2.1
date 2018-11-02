package Controller;

import Model.Player;
import View.Gui_Handler;

public class GameEngine {
    private Gui_Handler guiHandler;
    private PlayerTurnController playerTurnController1;
    private PlayerTurnController playerTurnController2;
    private Player player1;
    private Player player2;
    private SquareController square;

    public GameEngine(){
        guiHandler = new Gui_Handler();
        player1 = new Player();
        player2 = new Player();
        square = new SquareController();
        playerTurnController1 = new PlayerTurnController(player1, square);
        playerTurnController2 = new PlayerTurnController(player2, square);
    }
    public void start(){
        setUpGame();
        playGame();
    }
    private void setUpGame() {
        //int noPlayers = guiHandler.askForNoPlayers();
        //LOOP and make players
        //guiHandler.askForPlayerNames();
        guiHandler.setGameUpGui(playerTurnController1, playerTurnController2);
    }
    public void playGame() {
        //Controller
        DiceCupController diceCup = new DiceCupController(2,6);
        PlayerTurnController playerTurnController1 = new PlayerTurnController(player1, square);
        PlayerTurnController playerTurnController2 = new PlayerTurnController(player2, square);
        MessageController message = new MessageController();

        guiHandler.starGame(message);
        //Set player names
        guiHandler.enterNamePlayer(message, playerTurnController1);
        guiHandler.enterNamePlayer(message, playerTurnController2);

     //Start the main game
        do {
            guiHandler.playerTurnGui(message, playerTurnController1);
            guiHandler.removePlayer1Car(playerTurnController1);
            square.newSquare(playerTurnController1.roll(diceCup), playerTurnController1.getPosition(), playerTurnController1);
            square.squareImpact(playerTurnController1, diceCup);
            guiHandler.player1TurnUpdate(playerTurnController1, diceCup.getRef(0),diceCup.getRef(1));
            /*if (player1.getWon()){
                break;
            }*/

            guiHandler.playerTurnGui(message, playerTurnController2);
            guiHandler.removePlayer2Car(playerTurnController2);
            square.newSquare(playerTurnController2.roll(diceCup),
                    playerTurnController1.getPosition(), playerTurnController2 );
            square.squareImpact(playerTurnController2, diceCup);
            guiHandler.player2TurnUpdate(playerTurnController2, diceCup.getRef(0),diceCup.getRef(1));
            /*if (player2.getWon()){
                break;
            }*/
        }
        //End the game when one of the players get 40 and a double - or to double 6.
        while(!playerTurnController1.getWon() || !playerTurnController2.getWon());
    }
}
