
package Controller;

import Model.Player;
import View.Gui_Handler;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTurnControllerTest {
    Player player = new Player(1);
    SquareController square = new SquareController();
    DiceCupController diceCup = new DiceCupController(2,6);
    PlayerTurnController playerTurnController = new PlayerTurnController(1, square);
    MessageController message = new MessageController();
    Gui_Handler gui = new Gui_Handler();
    @org.junit.Test
    public void roll() {
        int currentPosition = playerTurnController.getPosition();
        assertEquals(currentPosition, 1);
        playerTurnController.roll(message, gui, diceCup, playerTurnController);
        int sum = diceCup.getSum();
        assertEquals(playerTurnController.getPosition(), (sum % 12) + currentPosition);
    }

    @Test
    public void newSquare() {
        assertEquals(playerTurnController.getPosition(), 1);

        playerTurnController.newSquare(12,12);
        assertEquals(playerTurnController.getPosition(), 12);

        playerTurnController.newSquare(11,3);
        assertEquals(playerTurnController.getPosition(), 2);

        playerTurnController.newSquare(2,3);
        assertEquals(playerTurnController.getPosition(), 5);

        for (int roll = 1; roll <= 1000; roll++){
            int rollSum = diceCup.rollAndGetSum();
            playerTurnController.newSquare(rollSum, playerTurnController.getPosition());
            int newPlayerPosition = player.getPosition();
            assertTrue(1 <= newPlayerPosition && newPlayerPosition <= 12 );
        }
    }

    @Test
    public void won() {
        assertEquals(playerTurnController.getBalance(), 1000);
        assertFalse(playerTurnController.getWon());
        playerTurnController.updateAccountBalance(3000);
        playerTurnController.won();
        assertTrue(playerTurnController.getWon());
    }

    @Test
    public void updateAccountBalance() {
    assertEquals(playerTurnController.getBalance(), 1000);

    playerTurnController.updateAccountBalance(500);
    assertEquals(playerTurnController.getBalance(), 1500);

    playerTurnController.updateAccountBalance(-100000);
    assertEquals(playerTurnController.getBalance(), 0);
    }

    @Test
    public void getBalance() {
        assertEquals(playerTurnController.getBalance(), 1000);
        playerTurnController.setPosition(12);
        square.squareImpact(message, gui, playerTurnController, diceCup);
        assertEquals(1650, playerTurnController.getBalance());
    }
}
