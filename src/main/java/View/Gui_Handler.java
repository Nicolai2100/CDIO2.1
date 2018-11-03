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
    private static GUI_Field[] fields;
    private GUI_Player guiPlayer1, guiPlayer2;
    public Gui_Handler() {
        fields = new  GUI_Field[12];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = new GUI_Street("" + i, "", "", "", Color.YELLOW, Color.BLACK);
        }
        gui = new GUI(fields);
    }
    public void setGameUpGui(PlayerTurnController player1, PlayerTurnController player2) {
        guiCreator();
        //GUI_Player
        GUI_Car[] car = new GUI_Car[2];
        for (int i = 0; i < car.length; i++) {
            car[i] = new GUI_Car();
        }
        car[0].setPrimaryColor(Color.BLACK);
        car[1].setPrimaryColor(Color.BLUE);

        guiPlayer1 = new GUI_Player(player1.getName(), player1.getBalance(), car[0]);
        guiPlayer2 = new GUI_Player(player2.getName(), player2.getBalance(), car[1]);
        fields[player1.getPosition()-1].setCar(guiPlayer1, true);
        fields[player2.getPosition()-1].setCar(guiPlayer2, true);
    }

    public void startGameGui(MessageController message) {
        gui.showMessage(message.startGame());
    }

    public void enterNamePlayer(MessageController message, PlayerTurnController player1, PlayerTurnController player2) {
        gui.showMessage(message.setPlayerName1());
        player1.setName(gui.getUserString(""));
        gui.showMessage(message.setPlayerName2());
        player2.setName(gui.getUserString(""));
    }
    public void setDiceGui(DieController die1, DieController die2) {
        gui.setDice(die1.getFaceValue(), die2.getFaceValue());
    }
    public void playerTurnGui(MessageController message, PlayerTurnController player)
    {
        gui.showMessage(message.playerTurn(player));
    }
    public void setPlayer1Car(PlayerTurnController player) {

        fields[player.getPosition()-1].setCar(guiPlayer1, true);
    }
    public void setPlayer2Car(PlayerTurnController player) {

        fields[player.getPosition()-1].setCar(guiPlayer2, true);
    }
    public void showScore(MessageController message, PlayerTurnController player) {
        gui.showMessage(message.playerEndTurn(player));
    }
    public void removePlayer1Car(PlayerTurnController player) {

        fields[(player.getPosition()-1)].removeAllCars();
    }
    public void removePlayer2Car(PlayerTurnController player) {

        fields[(player.getPosition()-1)].removeAllCars();
    }
    public void player1TurnUpdate(String str, MessageController message, PlayerTurnController player, DieController die1, DieController die2) {
        setDiceGui(die1, die2);
        setPlayer1Car(player);
        gui.showMessage(str);
        showScore(message, player);
    }
    public void player2TurnUpdate(String str, MessageController message, PlayerTurnController player, DieController die1, DieController die2) {
        setDiceGui(die1, die2);
        setPlayer2Car(player);
        gui.showMessage(str);
        showScore(message, player);
    }
    public void playerWonGui(MessageController message, PlayerTurnController player1, PlayerTurnController player2){
        gui.showMessage(message.playerWon(player1, player2));
        if (player1.getWon()){
            gui.showMessage("Congratulations "+ player1.getName() + " You are victorius!!!");
        }
        else
            gui.showMessage("Congratulations "+ player2.getName() + " You are victorius!!!");
    }

    public String playAgainGui(){
        String svar = gui.getUserString("Vil I spille igen? tast ja/nej");
        return svar;
    }

    /* int noPlayers = guiHandler.askForNoPlayers();
        //LOOP and make players
        gui.askForPlayerName();
        gui.setupGUI;*/

    public static void guiCreator() {
        fields[0].setTitle("Start");
        fields[0].setDescription("Start");
        fields[1].setTitle("Tower");
        fields[1].setDescription("+250");
        fields[2].setTitle("Crater");
        fields[2].setDescription("-100");
        fields[3].setTitle("Palace Gates");
        fields[3].setDescription("+100");
        fields[4].setTitle("Cold Desert");
        fields[4].setDescription("-20");
        fields[5].setTitle("Walled City");
        fields[5].setDescription("+180");
        fields[6].setTitle("Monastery");
        fields[6].setDescription("0");
        fields[7].setTitle("Black Cave");
        fields[7].setDescription("-70");
        fields[8].setTitle("Huts in the mountain");
        fields[8].setDescription("+60");
        fields[9].setTitle("The Werewall");
        fields[9].setDescription("-80 - ekstra tur!");
        fields[10].setTitle("The Pit");
        fields[10].setDescription("-50");
        fields[11].setTitle("Goldmine");
        fields[11].setDescription("+650");
    }

    public DiceCupController setDieFaces() {
        String svar = gui.getUserString("What sided cube do you wish to play with?");
        int dieFaces = Integer.parseInt(svar);
        return new DiceCupController(2, dieFaces);
    }
}
