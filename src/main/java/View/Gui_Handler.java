package View;

import Controller.*;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import java.awt.*;

public class Gui_Handler {
    private static GUI gui;
    private static GUI_Field[] felter;
    private GUI_Player guiPlayer1, guiPlayer2;

    public Gui_Handler() {
        felter = new  GUI_Field[12];
        for (int i = 0; i < felter.length; i++) {
            felter[i] = new GUI_Street("" + i, "", "", "", Color.YELLOW, Color.BLACK);
        }
        gui = new GUI(felter);
/*
        this.message = message;
        this.diceCup = diceCup;
        this.diceController1 = diceController1;
        this.diceController2 = diceController2;
*/
    }

    public static void guiCreator() {
        felter[0].setTitle("Start");
        felter[0].setDescription("Start");
        felter[1].setTitle("Tower");
        felter[1].setDescription("+250");
        felter[2].setTitle("Crater");
        felter[2].setDescription("-100");
        felter[3].setTitle("Palace Gates");
        felter[3].setDescription("+100");
        felter[4].setTitle("Cold Desert");
        felter[4].setDescription("-20");
        felter[5].setTitle("Walled City");
        felter[5].setDescription("+180");
        felter[6].setTitle("Monastery");
        felter[6].setDescription("0");
        felter[7].setTitle("Black Cave");
        felter[7].setDescription("-70");
        felter[8].setTitle("Huts in the mountain");
        felter[8].setDescription("+60");
        felter[9].setTitle("The Werewall");
        felter[9].setDescription("-80 - ekstra tur!");
        felter[10].setTitle("The Pit");
        felter[10].setDescription("-50");
        felter[11].setTitle("Goldmine");
        felter[11].setDescription("+650");
    }

    public void setGameUpGui() {
        guiCreator();
        //GUI_Player
        GUI_Car[] car = new GUI_Car[2];
        for (int i = 0; i < car.length; i++) {
            car[i] = new GUI_Car();
        }
        //Type.RACECAR; hvordan sættes typen af bil?

        car[0].setPrimaryColor(Color.BLACK);
        car[1].setPrimaryColor(Color.BLUE);

        guiPlayer1 = new GUI_Player(player1.getName(), player1.getBalance(), car[0]);
        guiPlayer2 = new GUI_Player(player2.getName(), player2.getBalance(), car[1]);

        //    felter[0].hasCar(guiPlayer1);
        felter[player1.getSum()].setCar(guiPlayer1, true);
        felter[player2.getSum()].setCar(guiPlayer2, true);
    }

    public void startGameGui() {
        gui.showMessage(message.startGame());
    }

    public void enterNamePlayer1() {
        gui.showMessage(message.enterNamePlayer1());
        player1.setName(gui.getUserString(""));
    }

    public void enterNamePlayer2() {
        gui.showMessage(message.enterNamePlayer2());
        player2.setName(gui.getUserString(""));
    }

    public void setDiceGui() {
        gui.setDice(diceController1.getFaceValue(), diceController2.getFaceValue());
    }

    public void player1TurnGui() {
        gui.showMessage(message.player1sTurn());
    }

    public void player2TurnGui() {
        gui.showMessage(message.player2sTurn());
    }

    public void setPlayer1Car() {
        felter[player1.getSum()].setCar(guiPlayer1, true);
    }

    public void setPlayer2Car() {
        felter[player2.getSum()].setCar(guiPlayer2, true);
    }

    public void showScore(PlayerTurnController player) {
        gui.showMessage(player.getName() + " har nu " + player.getSumSofar() + "point");
    }

    public void player1TurnUpdate(PlayerTurnController player) {
        setDiceGui();
        setPlayer1Car();
        showScore(player);
    }

    public void player2TurnUpdate(PlayerTurnController player) {
        setDiceGui();
        setPlayer2Car();
        showScore(player);
    }
    public void playerWonGui(){
        gui.showMessage(message.playerHasWon());
    }
    public void playAgain(){
        String svar = gui.getUserString("Vil du spille igen? tast ja/nej");
        if (svar.equals("ja"))
            GameEngine.playGame();
        else{
            gui.showMessage("Farvel");
            System.exit(1);
        }
    }

    /* int noPlayers = guiHandler.askForNoPlayers();
        //LOOP and make players
        gui.askForPlayerName();
        gui.setupGUI;*/

}
