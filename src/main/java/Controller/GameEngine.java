package Controller;

import View.Gui_Handler;

public class GameEngine {
    private Gui_Handler guiHandler;
    private SquareController square;
    private DiceCupController diceCup;
    private PlayerTurnController playerTurnC;
    int i = -1;

    public GameEngine() {
        guiHandler = new Gui_Handler();
        square = new SquareController();
    }

    public void start() {
        setUpGame();
        playGame();
    }

    public void setUpGame() {
        // ask for dice max value
        playerTurnC = new PlayerTurnController(guiHandler.choseNumOfPlayers());
        guiHandler.setGameUpGui(playerTurnC.getNumOfPlayers(), playerTurnC);
        guiHandler.startGameGui();
        //Set player names
        guiHandler.enterNamePlayer(playerTurnC);
        diceCup = new DiceCupController(2, guiHandler);
    }

    //Start the main game
    public void playGame() {
        do {
            i++;
            playerTurnC.setTurn(i);
            //message
            guiHandler.playerTurnGui(playerTurnC.getRef());
            //Move the player's car
            guiHandler.removeCar(playerTurnC.getRef());
            guiHandler.setPlayerCar(playerTurnC.getRef());
            //roll
            playerTurnC.getRef().roll(guiHandler, diceCup, i);
            //Square method
            square.squareImpact(guiHandler, diceCup, playerTurnC.getRef(), i);

            //Status
            guiHandler.showScore(playerTurnC.getRef());
            /*if (playerTC1.getWon()) {
                break;
            }*/

        }
        //End the game when one of the players get 40 and a double - or to double 6.
        while (!playerTurnC.getRef().getWon(i));

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

