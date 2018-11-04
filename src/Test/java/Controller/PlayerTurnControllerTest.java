
package Controller;

import Model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTurnControllerTest {
    Player player = new Player();
    SquareController square = new SquareController();
    DiceCupController diceCup = new DiceCupController(2,6);
    PlayerTurnController playerTurnController = new PlayerTurnController(player, square);

    @Test
    public void newSquare() {
        assertEquals(playerTurnController.getPosition(), 1);

        playerTurnController.newSquare(12,12);
        assertEquals(playerTurnController.getPosition(), 12);

        playerTurnController.newSquare(11,3);
        assertEquals(playerTurnController.getPosition(), 2);

        playerTurnController.newSquare(2,3);
        assertEquals(playerTurnController.getPosition(), 5);
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
        square.squareImpact(playerTurnController, diceCup);
        assertEquals(1650, playerTurnController.getBalance());
    }
}
