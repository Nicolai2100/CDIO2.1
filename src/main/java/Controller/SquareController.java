package Controller;

import View.Gui_Handler;

public class SquareController {

    public void squareImpact(Gui_Handler gui, DiceCupController diceCup, PlayerController playerC, int i) {
        int newSquare = playerC.getRef(i).getPosition();
        switch (newSquare) {
            case 1:
                gui.boardUpdate(playerC, diceCup.getRef(0), diceCup.getRef(1), i);
                gui.messageSquareGui(playerC.getPosition(i), playerC, i);
                break;
            case 2:
                playerC.updatePlayerBalance(250, i);
                gui.boardUpdate(playerC, diceCup.getRef(0), diceCup.getRef(1), i);
                gui.messageSquareGui(playerC.getPosition(i), playerC, i);
                playerC.won(i);
                break;
            case 3:
                playerC.updatePlayerBalance(-100, i);
                gui.boardUpdate(playerC, diceCup.getRef(0), diceCup.getRef(1), i);
                gui.messageSquareGui(playerC.getPosition(i), playerC, i);

                break;
            case 4:
                playerC.updatePlayerBalance(100, i);
                gui.boardUpdate(playerC, diceCup.getRef(0), diceCup.getRef(1), i);
                gui.messageSquareGui(playerC.getPosition(i), playerC, i);

                playerC.won(i);
                break;
            case 5:
                playerC.updatePlayerBalance(-20,i);
                gui.boardUpdate(playerC, diceCup.getRef(0), diceCup.getRef(1), i);
                gui.messageSquareGui(playerC.getPosition(i), playerC, i);

                break;
            case 6:
                playerC.updatePlayerBalance(180,i);
                gui.boardUpdate(playerC, diceCup.getRef(0), diceCup.getRef(1), i);
                gui.messageSquareGui(playerC.getPosition(i), playerC, i);
                playerC.getWon(i);

                break;
            case 7:
                gui.boardUpdate(playerC, diceCup.getRef(0), diceCup.getRef(1), i);
                gui.messageSquareGui(playerC.getPosition(i), playerC, i);

                break;
            case 8:
                playerC.updatePlayerBalance(-70,i);
                gui.boardUpdate(playerC, diceCup.getRef(0), diceCup.getRef(1), i);
                gui.messageSquareGui(playerC.getPosition(i), playerC, i);

                break;
            case 9:
                playerC.updatePlayerBalance(60,i);
                gui.boardUpdate(playerC, diceCup.getRef(0), diceCup.getRef(1), i);
                gui.messageSquareGui(playerC.getPosition(i), playerC, i);

                playerC.won(i);
                break;
            case 10:
                playerC.updatePlayerBalance(-80,i);
                gui.boardUpdate(playerC, diceCup.getRef(0), diceCup.getRef(1), i);
                gui.messageSquareGui(playerC.getPosition(i), playerC, i);

                gui.playerTurnGui(playerC, i);

                gui.removeSpecificCar();
                playerC.roll(diceCup, i);
                break;
            case 11:
                playerC.updatePlayerBalance(-50, i);
                gui.boardUpdate(playerC, diceCup.getRef(0), diceCup.getRef(1), i);
                gui.messageSquareGui(playerC.getPosition(i), playerC, i);

                break;
            case 12:
                playerC.updatePlayerBalance(650, i);
                gui.boardUpdate(playerC, diceCup.getRef(0), diceCup.getRef(1), i);
                gui.messageSquareGui(playerC.getPosition(i), playerC, i);

                playerC.won(i);

                break;
        }
    }
}
