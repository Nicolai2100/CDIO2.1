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
    private GUI_Player guiPlayer1, guiPlayer2;

    //Construktor
    public Gui_Handler() {
        fields = new  GUI_Field[12];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = new GUI_Street("" + i, "", "", "", Color.YELLOW, Color.BLACK);
        }
        gui = new GUI(fields);
        message = new MessageHandler();
    }

    public void setGameUpGui(PlayerController player1, PlayerController player2) {
        fieldsAttributes();
        //GUI_Player
        GUI_Car[] car = new GUI_Car[2];
        for (int i = 0; i < car.length; i++) {
            car[i] = new GUI_Car();
        }
        //Car objects
        car[0].setPrimaryColor(Color.BLACK);
        car[1].setPrimaryColor(Color.BLUE);
        //Gui_Player objects
        guiPlayer1 = new GUI_Player(player1.getName(), player1.getBalance(), car[0]);
        guiPlayer2 = new GUI_Player(player2.getName(), player2.getBalance(), car[1]);
        fields[player1.getPosition()-1].setCar(guiPlayer1, true);
        fields[player2.getPosition()-1].setCar(guiPlayer2, true);
    }

    public GUI_Player getGuiPlayer(PlayerController player){
        GUI_Player guiPlayer;
        if (player.getObjectNumb() == 1){
            guiPlayer = guiPlayer1;
        }
        else{
            guiPlayer = guiPlayer2;
        }
        return guiPlayer;
    }

    public void startGameGui() {
        gui.showMessage(message.startGame());
    }

    public void enterNamePlayer(PlayerController player1, PlayerController player2) {
        gui.showMessage(message.setPlayerName1());
        player1.setName(gui.getUserString(""));
        gui.showMessage(message.setPlayerName2());
        player2.setName(gui.getUserString(""));
    }
    public void setDiceGui(DieController die1, DieController die2) {
        gui.setDice(die1.getFaceValue(), die2.getFaceValue());
    }
    public void playerTurnGui(PlayerController player)
    {
        gui.showMessage(message.playerTurn(player));
    }

    public void setPlayerCar(PlayerController player) {
       fields[player.getPosition()-1].setCar(getGuiPlayer(player), true);
    }
    public void showScore(PlayerController player) {
        gui.showMessage(message.playerEndTurn(player));
    }

    public void removeCar(PlayerController player) {

        fields[(player.getPosition()-1)].removeAllCars();
    }
    //Only used for field 10
    public void removeSpecificCar() {
        fields[(9)].removeAllCars();
    }

    public void guiBoardUpdate(PlayerController player, DieController die1, DieController die2) {
        setDiceGui(die1, die2);
        setPlayerCar(player);
    }

    public void playerWonGuiMessage(PlayerController player1, PlayerController player2){
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

    public void messageSquareGui(int position, PlayerController player){
        gui.showMessage(message.messageSquare(position, player));
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


    public DiceCupController setDieFaces() {
        int dieFaces;
        String input;
        input = gui.getUserString("What sided die do you wish to play with?");
        do {
            if (input.charAt(0) < 49 || input.charAt(0) > 54){
                input = gui.getUserString("Wrong input! Please insert a number between 1 and 6");
                dieFaces = Integer.parseInt(input);
            } else {
                dieFaces = Integer.parseInt(input);
            }
        }while((dieFaces < 1) || (dieFaces > 6));

        return new DiceCupController(2, dieFaces);
    }
}

