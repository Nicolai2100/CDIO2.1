package Controller;

import Model.Message;
import Model.Player;

public class MessageController {
    Message message;
    String returnString;

    public MessageController() {
        message = new Message();
    }
    public String square2() {
        String returnString = message.getSquare2();
        return returnString;
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
        String returnString = message.regler();
        return returnString;
    }
    public String playerTurn(PlayerTurnController player) {
        returnString = "It is" + player.getName() + "'s turn! Press Enter to roll!";
        return returnString;
    }

    public String setPlayerName(PlayerTurnController player) {
        returnString = "Enter the name of " + player.getName() + ": ";
        return returnString;
    }

    public String playerWon(PlayerTurnController player) {
        returnString = player.getName() + "has won the game, by having 3000 or more gold coins.";
        return returnString;
    }
    public String playerEndTurn(PlayerTurnController player){
        returnString = player.getName() + "now has "+player.getBalance()+" gold coins.";
        return returnString;
    }
    public String startGame(){
        return message.regler();
    }

}
