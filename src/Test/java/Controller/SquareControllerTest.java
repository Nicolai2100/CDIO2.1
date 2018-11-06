package Controller;

import View.Gui_Handler;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareControllerTest {

    SquareController square = new SquareController();

    DiceCupController diceCup = new DiceCupController(2,6);
    PlayerTurnController player = new PlayerTurnController(1, square);
    MessageController message = new MessageController();
    Gui_Handler gui = new Gui_Handler();

    @Test
    public void squareImpact() {
        int[] position = {1,2,3,4,5,6,7,8,9,11,12};
        int[] fieldList = {0,250,-100,100,-20,180,0,-70,60,-50,650};

        for (int i = 0; i < position.length; i++) {
            int initialBalance = player.getBalance();
            player.setPosition(position[i]);
            square.squareImpact(message, gui, player, diceCup);
            int balancePostImpact = player.getBalance();
            assertEquals(balancePostImpact, initialBalance+fieldList[i]);
        }
    }
}