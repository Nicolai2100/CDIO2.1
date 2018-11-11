package Controller;

import View.Gui_Handler;

public class GameEngine {
    private Gui_Handler guiHandler;
    private SquareController square;
    private DiceCupController diceCup;
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
        int j = 0;
        //int i = 0;

        do {
            int i = playerTurnC.calcTurn(j);
            playerTurnC.setTurn(i);
            //message
            guiHandler.playerTurnGui(playerTurnC.getPC(), i);
            //Move the player's car
            guiHandler.removeCar(playerTurnC.getPC(), i);
            guiHandler.setPlayerCar(playerTurnC.getPC(), i);
            //roll
            playerTurnC.getPC().roll(diceCup, i);
            //Square method
            square.squareImpact(guiHandler, diceCup, playerTurnC.getPC(), i);

            //Status
            guiHandler.showScore(playerTurnC.getPC(), i);
            /*if (playerTC1.getWon()) {
                break;
            }*/
            j++;

        }
        //End the game when one of the players get 40 and a double - or to double 6.
        while (!playerTurnC.getPC().getWon(j));

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

