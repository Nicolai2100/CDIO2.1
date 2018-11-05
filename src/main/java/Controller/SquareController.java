package Controller;

import View.Gui_Handler;

public class SquareController {

    public void squareImpact(MessageController message, Gui_Handler gui, PlayerTurnController player, DiceCupController diceCup) {
        int newSquare = player.getPosition();
        switch (newSquare) {
            case 1:
                gui.playerUpdateGUI(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.fieldFeedback(message.messageSquare(player.getPosition(), player));
                break;
            case 2:
                player.updateAccountBalance(250);
                gui.playerUpdateGUI(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.fieldFeedback(message.messageSquare(player.getPosition(), player));
                player.won();
                break;
            case 3:
                player.updateAccountBalance(-100);
                gui.playerUpdateGUI(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.fieldFeedback(message.messageSquare(player.getPosition(), player));
                break;
            case 4:
                player.updateAccountBalance(100);
                gui.playerUpdateGUI(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.fieldFeedback(message.messageSquare(player.getPosition(), player));
                player.won();
                break;
            case 5:
                player.updateAccountBalance(-20);
                gui.playerUpdateGUI(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.fieldFeedback(message.messageSquare(player.getPosition(), player));
                break;
            case 6:
                player.updateAccountBalance(180);
                gui.playerUpdateGUI(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.fieldFeedback(message.messageSquare(player.getPosition(), player));
                player.won();
                break;
            case 7:
                gui.playerUpdateGUI(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.fieldFeedback(message.messageSquare(player.getPosition(), player));
                break;
            case 8:
                player.updateAccountBalance(-70);
                gui.playerUpdateGUI(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.fieldFeedback(message.messageSquare(player.getPosition(), player));
                break;
            case 9:
                player.updateAccountBalance(60);
                gui.playerUpdateGUI(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.fieldFeedback(message.messageSquare(player.getPosition(), player));
                player.won();
                break;
            case 10:
                player.updateAccountBalance(-80);
                gui.playerUpdateGUI(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.fieldFeedback(message.messageSquare(player.getPosition(), player));
                gui.playerTurnGui(message, player);
                gui.removeSpecificCar(player);

                player.roll(message, gui, diceCup, player);
                break;
            case 11:
                player.updateAccountBalance(-50);
                gui.playerUpdateGUI(player, diceCup.getRef(0), diceCup.getRef(1));

                gui.fieldFeedback(message.messageSquare(player.getPosition(), player));
                break;
            case 12:
                player.updateAccountBalance(650);
                gui.playerUpdateGUI(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.fieldFeedback(message.messageSquare(player.getPosition(), player));
                player.won();

                break;
        }
    }
}
