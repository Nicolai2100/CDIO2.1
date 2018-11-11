package Controller;

import Model.Player;
import View.Gui_Handler;

public class GameEngine {
    private Gui_Handler guiHandler;
    private SquareController square;
    private DiceCupController diceCup;
    private PlayerController playerC;
    private PlayerTurnController playerTurnC;

    public GameEngine() {
        guiHandler = new Gui_Handler();
        square = new SquareController();
    }

    public void start() {
        setUpGame();
        playGame();
    }

    public void setUpGame() {
        //guiHandler.startGameGui();

        playerC = new PlayerController(guiHandler.choseNumOfPlayers());
        playerTurnC = new PlayerTurnController(playerC.getNumOfPlayers());

        guiHandler.setGameUpGui(playerC.getNumOfPlayers(), playerC);
        //Set player names
        guiHandler.enterNamePlayer(playerC);
        // ask for dice max value
        diceCup = new DiceCupController(2, guiHandler);
    }

    //Start the main game
    public void playGame() {
        int j = 0;
        int i;

        do {
            i = playerTurnC.calcTurn(j);
            playerTurnC.setTurn(i);
            //message
            guiHandler.playerTurnGui(playerC, i);
            //Move the player's car
            //guiHandler.removeCar(playerC, i);
            guiHandler.setPlayerCar(playerC, i);
            //roll
            playerC.roll(playerC.getRef(i), diceCup, i);
            //Square method
            square.squareImpact(playerC.getRef(i), guiHandler, diceCup, playerC, i);

            //Status
            guiHandler.showScore(playerC, i);
            /*if (playerTC1.getWon()) {
                break;
            }*/
            j++;

        }
        //End the game when one of the players get 40 and a double - or to double 6.
        while (!playerC.getWon(i));

        //guiHandler.playerWonGui(playerTC1, playerTC2);

        /*
        int noPlayers = guiHandler.askForNoPlayers();
        LOOP and make players
        guiHandler.askForPlayerNames();

        playAgain();
        public void playAgain() {
            String svar = guiHandler.playAgainGui();
            if (svar.equals("ja")) {
                guiHandler.removeCar(playerTC1);
                guiHandler.removeCar(playerTC2);
                start();
            } else {
                System.exit(1);
            }
            Taget fra discord serveren
            if (gui.getUserLeftButtonPressed("Spil igen?", "Nej", "Jo")){
                System.exit(1);
            }*/
    }

}

