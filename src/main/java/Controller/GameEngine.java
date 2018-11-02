package Controller;

import View.Gui_Handler;

public class GameEngine {
    private final Gui_Handler guiHandler;
    private final PlayerTurnController playerTurnController;

    public GameEngine(){
        guiHandler = new Gui_Handler();
        playerTurnController = new PlayerTurnController();

    }
    /*public void start(){
        setUpGame();
        playGame();
    }

    private void setUpGame() {
        int noPlayers = guiHandler.askForNoPlayers();
        //LOOP and make players
        gui.askForPlayerName();
        gui.setupGUI;
    }
    */
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
