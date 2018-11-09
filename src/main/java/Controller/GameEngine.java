package Controller;

import View.Gui_Handler;

public class GameEngine {
    private Gui_Handler guiHandler;
    private PlayerController playerTC1;
    private PlayerController playerTC2;
    private SquareController square;
    private DiceCupController diceCup;

    public GameEngine() {
        guiHandler = new Gui_Handler();
        square = new SquareController();
        playerTC1 = new PlayerController(1, square);
        playerTC2 = new PlayerController(2, square);
    }

    public void start() {
        setUpGame();
        playGame();
    }

    public void setUpGame() {
        //int noPlayers = guiHandler.askForNoPlayers();
        //LOOP and make players
        //guiHandler.askForPlayerNames();
        // ask for dice max value
        guiHandler.setGameUpGui(playerTC1, playerTC2);
        guiHandler.startGameGui();
        //Set player names
        guiHandler.enterNamePlayer(playerTC1, playerTC2);
        diceCup = guiHandler.setDieFaces();
    }

    public void playAgain() {
        String svar = guiHandler.playAgainGui();
        if (svar.equals("ja")) {
            guiHandler.removeCar(playerTC1);
            guiHandler.removeCar(playerTC2);
            start();
        } else {
            System.exit(1);
        }
//        Taget fra discord serveren
//        if (gui.getUserLeftButtonPressed("Spil igen?", "Nej", "Jo")){
//            System.exit(1);
//        }
    }
    //Start the main game
    public void playGame() {
        do {
            guiHandler.playerTurnGui(playerTC1);
            guiHandler.removeCar(playerTC1);
            guiHandler.setPlayerCar(playerTC2);
            playerTC1.roll(guiHandler, diceCup, playerTC1);
            guiHandler.showScore(playerTC1);
            if (playerTC1.getWon()) {
                break;
            }

            guiHandler.playerTurnGui(playerTC2);
            guiHandler.removeCar(playerTC2);
            guiHandler.setPlayerCar(playerTC1);
            playerTC2.roll(guiHandler, diceCup, playerTC2);
            guiHandler.showScore(playerTC2);
            if (playerTC2.getWon()) {
                break;
            }
        }
        //End the game when one of the players get 40 and a double - or to double 6.
        while (!playerTC1.getWon() || !playerTC2.getWon());

        guiHandler.playerWonGui(playerTC1, playerTC2);

        //playAgain();

    }

}

