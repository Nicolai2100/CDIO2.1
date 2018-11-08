package Controller;

import View.Gui_Handler;

public class SquareController {

    public void squareImpact(Gui_Handler gui, PlayerController player, DiceCupController diceCup) {
        int newSquare = player.getPosition();
        switch (newSquare) {
            case 1:
                gui.guiBoardUpdate(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.messageSquareGui(player.getPosition(), player);
                break;
            case 2:
                player.updateAccountBalance(250);
                gui.guiBoardUpdate(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.messageSquareGui(player.getPosition(), player);
                player.won();
                break;
            case 3:
                player.updateAccountBalance(-100);
                gui.guiBoardUpdate(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.messageSquareGui(player.getPosition(), player);

                break;
            case 4:
                player.updateAccountBalance(100);
                gui.guiBoardUpdate(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.messageSquareGui(player.getPosition(), player);

                player.won();
                break;
            case 5:
                player.updateAccountBalance(-20);
                gui.guiBoardUpdate(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.messageSquareGui(player.getPosition(), player);

                break;
            case 6:
                player.updateAccountBalance(180);
                gui.guiBoardUpdate(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.messageSquareGui(player.getPosition(), player);

                player.won();
                break;
            case 7:
                gui.guiBoardUpdate(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.messageSquareGui(player.getPosition(), player);

                break;
            case 8:
                player.updateAccountBalance(-70);
                gui.guiBoardUpdate(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.messageSquareGui(player.getPosition(), player);

                break;
            case 9:
                player.updateAccountBalance(60);
                gui.guiBoardUpdate(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.messageSquareGui(player.getPosition(), player);

                player.won();
                break;
            case 10:
                player.updateAccountBalance(-80);
                gui.guiBoardUpdate(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.messageSquareGui(player.getPosition(), player);

                gui.playerTurnGui(player);

                gui.removeSpecificCar();
                player.roll(gui, diceCup, player);
                break;
            case 11:
                player.updateAccountBalance(-50);
                gui.guiBoardUpdate(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.messageSquareGui(player.getPosition(), player);

                break;
            case 12:
                player.updateAccountBalance(650);
                gui.guiBoardUpdate(player, diceCup.getRef(0), diceCup.getRef(1));
                gui.messageSquareGui(player.getPosition(), player);

                player.won();

                break;
        }
    }
}
