
package Controller;

import View.Gui_Handler;
import View.MessageHandler;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTurnControllerTest {
    SquareController square = new SquareController();
    DiceCupController diceCup = new DiceCupController(2,6);
    PlayerController ptc1 = new PlayerController(1, square);
    PlayerController ptc2 = new PlayerController(2, square);
    MessageHandler message = new MessageHandler();
    Gui_Handler gui = new Gui_Handler();
    @Test
    public void roll() {
        gui.setGameUpGui(ptc1, ptc2);
        int currentPosition = ptc2.getPosition();
        assertEquals(currentPosition, 1);
        ptc2.roll(message, gui, diceCup, ptc2);
        int sum = diceCup.getSum();
        assertEquals(ptc2.getPosition(), (sum % 12) + currentPosition);
    }

    @Test
    public void newSquare() {
        assertEquals(ptc2.getPosition(), 1);

        ptc2.newSquare(12,12);
        assertEquals(ptc2.getPosition(), 12);

        ptc2.newSquare(11,3);
        assertEquals(ptc2.getPosition(), 2);

        ptc2.newSquare(2,3);
        assertEquals(ptc2.getPosition(), 5);

        for (int roll = 1; roll <= 1000; roll++){
            int rollSum = diceCup.rollAndGetSum();
            ptc2.newSquare(rollSum, ptc2.getPosition());
            int newPlayerPosition = ptc2.getPosition();
            assertTrue(1 <= newPlayerPosition && newPlayerPosition <= 12 );
        }
    }

    @Test
    public void won() {
        assertEquals(ptc2.getBalance(), 1000);
        assertFalse(ptc2.getWon());
        ptc2.updateAccountBalance(3000);
        ptc2.won();
        assertTrue(ptc2.getWon());
    }

    @Test
    public void updateAccountBalance() {
    assertEquals(ptc2.getBalance(), 1000);

    ptc2.updateAccountBalance(500);
    assertEquals(ptc2.getBalance(), 1500);

    ptc2.updateAccountBalance(-100000);
    assertEquals(ptc2.getBalance(), 0);
    }

    @Test
    public void getBalance() {
        assertEquals(ptc2.getBalance(), 1000);
        gui.setGameUpGui(ptc1, ptc2);
        ptc2.setPosition(12);
        gui.setPlayerCar(ptc2);

        square.squareImpact(message, gui, ptc2, diceCup);
        assertEquals(1650, ptc2.getBalance());
    }
}
