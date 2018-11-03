package Controller;

import Model.Message;
import Model.Player;

public class MessageController {
    Message message;
    String returnString;

    public MessageController() {
        message = new Message();
    }
    public String messageSquare(int position, PlayerTurnController player){

        switch (position){
            case 1: returnString = player.getName() + square1();
                    break;
            case 2: returnString = player.getName() + square2();
                    break;
            case 3: returnString = player.getName() + square3();
                    break;
            case 4: returnString = player.getName() + square4();
                    break;
            case 5: returnString = player.getName() + square5();
                    break;
            case 6: returnString = player.getName() + square6();
                    break;
            case 7: returnString = player.getName() + square7();
                    break;
            case 8: returnString = player.getName() + square8();
                    break;
            case 9: returnString = player.getName() + square9();
                    break;
            case 10: returnString = player.getName() + square10();
                    break;
            case 11: returnString = player.getName() + square11();
                    break;
            case 12: returnString = player.getName() + square12();
                    break;
        }
        return returnString;
    }
    public String square1(){
        return message.getSquare1();
    }
    public String square2() {
        return message.getSquare2();
    }

    public String square3() {
        return message.getSquare3();
    }

    public String square4() {
        return message.getSquare4();
    }

    public String square5() {
        return message.getSquare5();
    }

    public String square6() {
        return message.getSquare6();
    }

    public String square7() {
        return message.getSquare7();
    }

    public String square8() {
        return message.getSquare8();
    }

    public String square9() {
        return message.getSquare9();
    }

    public String square10() {
        return message.getSquare10();
    }

    public String square11() {
        return message.getSquare11();
    }

    public String square12() {
        return message.getSquare12();
    }
    public String regler() {
        return message.regler();
    }
    public String playerTurn(PlayerTurnController player) {
        returnString = "It is " + player.getName() + "'s turn! Press Enter to roll!";
        return returnString;
    }

    public String setPlayerName1(PlayerTurnController player) {
        returnString = "Enter the name of player1: ";
        return returnString;
    }
    public String setPlayerName2(PlayerTurnController player) {
        returnString = "Enter the name of player2: ";
        return returnString;
    }

    public String playerWon(PlayerTurnController player1, PlayerTurnController player2) {
        if (player1.getWon()){
           return returnString = player1.getName() + " has won the game, by having 3000 or more gold coins.";
        }
        else {
            return returnString = player2.getName() + " has won the game, by having 3000 or more gold coins.";
        }
    }
    public String playerEndTurn(PlayerTurnController player){
        returnString = player.getName() + " now has "+player.getBalance()+" gold coins.";
        return returnString;
    }
    public String startGame(){
        return message.regler();
    }

}
