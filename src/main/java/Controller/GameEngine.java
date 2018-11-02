package Controller;

import Model.Message;
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

        guiHandler.setGameUpGui(playerTurnController1, playerTurnController2);

        //guiHandler.startGameGui();

        //Set player names
        //guiHandler.enterNamePlayer1();
        //guiHandler.enterNamePlayer2();

     //Start the main game
        do {
            guiHandler.playerTurnGui(message, playerTurnController1);
            playerTurnController1.roll(diceCup, player1);
            guiHandler.player1TurnUpdate(playerTurnController1, diceCup.getRef(0),diceCup.getRef(1));
            /*if (player1.getWon()){
                break;
            }*/

            guiHandler.playerTurnGui(message, playerTurnController2);
            playerTurnController2.roll(diceCup, player2);
            guiHandler.player2TurnUpdate(playerTurnController2, diceCup.getRef(0),diceCup.getRef(1));
            /*if (player2.getWon()){
                break;
            }*/
        }
        //End the game when one of the players get 40 and a double - or to double 6.
        while(!player1.getWon() || !player2.getWon());
    }

}
