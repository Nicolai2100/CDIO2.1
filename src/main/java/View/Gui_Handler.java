package View;

import Controller.*;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import java.awt.*;

public class Gui_Handler {
    private MessageHandler message;
    private static GUI gui;
    private static GUI_Field[] fields;
    GUI_Player [] gui_Players;

    //Construktor
    public Gui_Handler() {
        fields = new  GUI_Field[12];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = new GUI_Street("" + i, "", "", "", Color.YELLOW, Color.BLACK);
        }
        gui = new GUI(fields);
        message = new MessageHandler();
    }
    public int choseNumOfPlayers(){
        int players = gui.getUserInteger("How many players is participating in the game?");
        return players;
    }
    public void setGameUpGui(int numOfPlayers, PlayerTurnController playerC) {
        fieldsAttributes();
        //GUI_Car
        GUI_Car[] car = new GUI_Car[numOfPlayers];
        for (int i = 0; i < car.length; i++) {
            car[i] = new GUI_Car();
        }
        //Car objects get color
        for (int i = 0; i < car.length; i++) {
            car[i].setPrimaryColor(Color.YELLOW);
        }

        /*car[0].setPrimaryColor(Color.BLACK);
        car[1].setPrimaryColor(Color.BLUE);
        */
        ///GUI_Player
        gui_Players = new GUI_Player[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            gui_Players[i]= new GUI_Player(playerC.getPC().getName(i), 0, car[i]);
        }

/*
        guiPlayer1 = new GUI_Player(player1.getName(), player1.getBalance(), car[0]);
        guiPlayer2 = new GUI_Player(player2.getName(), player2.getBalance(), car[1]);
*/
        for (int i = 0; i < numOfPlayers; i++) {
            fields[0].setCar(gui_Players[i], true);
        }
        /*fields[player1.getPosition()-1].setCar(guiPlayer1, true);
        fields[player2.getPosition()-1].setCar(guiPlayer2, true);*/
    }

    public GUI_Player getGuiPlayer(int i){
        GUI_Player guiPlayer = gui_Players[i];
        return guiPlayer;
    }

    public void startGameGui() {
        gui.showMessage(message.startGame());
    }

    public void enterNamePlayer(PlayerTurnController playerTC) {

        for (int i = 0; i < playerTC.getNumOfPlayers(); i++) {
            gui.showMessage(message.setPlayerName(i));
            playerTC.getPC().getRef(i).setName(gui.getUserString(""));
        }

/*
        gui.showMessage(message.setPlayerName2());
        player2.setName(gui.getUserString(""));
*/
    }
    public void setDiceGui(DieController die1, DieController die2) {
        gui.setDice(die1.getFaceValue(), die2.getFaceValue());
    }
    public void playerTurnGui(PlayerController player, int i)
    {
        gui.showMessage(message.playerTurn(player, i));
    }

    public void setPlayerCar(PlayerController player, int i) {
       fields[player.getPosition(i)-1].setCar(getGuiPlayer(i), true);
    }
    public void showScore(PlayerController player, int i) {
        gui.showMessage(message.playerEndTurn(player, i));
    }

    public void removeCar(PlayerController player, int i) {

        fields[(player.getPosition(i)-1)].removeAllCars();
    }
    //Only used for field 10
    public void removeSpecificCar() {
        fields[(9)].removeAllCars();
    }

    public void boardUpdate(PlayerController player, DieController die1, DieController die2, int i) {
        setDiceGui(die1, die2);
        setPlayerCar(player, i);
    }
/*
    public void playerWonGui(PlayerController player1, int i){
        gui.showMessage(message.playerWon(player1.won(i));
        if (player1.getWon()){
            gui.showMessage("Congratulations "+ player1.getName() + " You are victorius!!!");
        }
        else
            gui.showMessage("Congratulations "+ player2.getName() + " You are victorius!!!");
    }*/

    public void messageSquareGui(int position, PlayerController player, int i){
        gui.showMessage(message.messageSquare(position, player, i));
    }

    public int setDieFaces() {
        int dieFaces;
        String input;
        while(true){
            input = gui.getUserString("What sided die do you wish to play with?");
            if (input.matches("^[0-9]*$") && input.length() > 0){
                if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 6 ){
                    gui.showMessage("Wrong input! Please insert a number between 1 and 6");
                } else {
                    dieFaces = Integer.parseInt(input);
                    break;
                }
            }
        }
        return dieFaces;
    }

    public static void fieldsAttributes() {
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
        fields[9].setDescription("-80 - extra turn!");
        fields[10].setTitle("The Pit");
        fields[10].setDescription("-50");
        fields[11].setTitle("Goldmine");
        fields[11].setDescription("+650");
    }
    /* int noPlayers = guiHandler.askForNoPlayers();
    //LOOP and make players
    gui.askForPlayerName();
    gui.setupGUI;

    public String playAgainGui(){
        String svar = gui.getUserString("Vil I spille igen? tast ja/nej");
        return svar;
    }
    */
}

