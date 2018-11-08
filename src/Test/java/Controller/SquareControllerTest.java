package Controller;

import View.Gui_Handler;
import View.MessageHandler;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareControllerTest {

    SquareController square = new SquareController();
    DiceCupController diceCup = new DiceCupController(2,6);
    PlayerController player1 = new PlayerController(1, square);
    PlayerController player2 = new PlayerController(2, square);
    Gui_Handler gui = new Gui_Handler();

    @Test
    public void squareImpact() {
        gui.setGameUpGui(player1, player2);
        int[] position = {1,2,3,4,5,6,7,8,9,11,12};
        int[] fieldList = {0,250,-100,100,-20,180,0,-70,60,-50,650};

        for (int i = 0; i < position.length; i++) {
            int initialBalance = player1.getBalance();
            player1.setPosition(position[i]);
            square.squareImpact(gui, player1, diceCup);
            int balancePostImpact = player1.getBalance();
            assertEquals(balancePostImpact, initialBalance+fieldList[i]);
        }
    }
}