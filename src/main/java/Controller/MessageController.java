package Controller;

import Model.Message;

public class MessageController {
    private Message message;
    private String returnString;

    public MessageController() {
        message = new Message();
    }
    public String messageSquare(int position, PlayerTurnController player){

        switch (position){
            case 1: returnString = player.getName() + getSquare1();
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
    public String getSquare1(){
        returnString = message.getSquare1();
        return returnString;
    }
    public String square2() {
        return message.getSquare2();
    }

    public String square3() {
        String returnString = message.getSquare3();
        return returnString;
    }

    public String square4() {
        String returnString = message.getSquare4();
        return returnString;
    }

    public String square5() {
        String returnString = message.getSquare5();
        return returnString;
    }

    public String square6() {
        String returnString = message.getSquare6();
        return returnString;
    }

    public String square7() {
        String returnString = message.getSquare7();
        return returnString;
    }

    public String square8() {
        String returnString = message.getSquare8();
        return returnString;
    }

    public String square9() {
        String returnString = message.getSquare9();
        return returnString;
    }

    public String square10() {
        String returnString = message.getSquare10();
        return returnString;
    }

    public String square11() {
        String returnString = message.getSquare11();
        return returnString;
    }

    public String square12() {
        String returnString = message.getSquare12();
        return returnString;
    }
    public String regler() {
        String returnString = message.getRules();
        return returnString;
    }
    public String playerTurn(PlayerTurnController player) {
        returnString = "It is " + player.getName() + "'s turn! Press Enter to roll!";
        return returnString;
    }

    public String setPlayerName1() {
        returnString = "Enter the name of player1: ";
        return returnString;
    }
    public String setPlayerName2() {
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
        return message.getRules();
    }

}
