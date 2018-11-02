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
       // guiHandler.askForPlayerNames();
        //guiHandler.setGameUpGui();

    }
    public static void playGame() {

        Message message = new Message();

        //Controller
        //DiceCupController diceCupController = new DiceCupController(2,6);
        //PlayerTurnController playerTurnController1 = new PlayerTurnController(player1, diceCupController, diceController1,
        //        diceController2);
        //PlayerTurnController playerTurnController2 = new PlayerTurnController(player2, diceCupController, diceController1,
        //        diceController2);
        //MessageController messageController = new MessageController(player1, player2);


        //guiHandler.setGameUpGui();

        //guiHandler.startGameGui();

        //Set player names
        //guiHandler.enterNamePlayer1();
        //guiHandler.enterNamePlayer2();

    /* //Start the main game
        do {
            changePlayer();
            gui.showPlayerTurn(currentPLayer);
            PlayerTurnController.takeTurn(currentPlayer, gui);
            gui.showPlayerTurnEnd(currentPlayer)
            gui.player1TurnGui();
            playerTurnController1.playerRoll();
            gui.player1TurnUpdate(playerTurnController1);
            if (player1.getWon()){
                break;
            }
            gui.player2TurnGui();
            playerTurnController2.playerRoll();
            gui.player2TurnUpdate(playerTurnController2);
            if (player2.getWon()){
                break;
            }
        }
        //End the game when one of the players get 40 and a double - or to double 6.
        while(!player1.getWon() || !player2.getWon());*/
    }

}
