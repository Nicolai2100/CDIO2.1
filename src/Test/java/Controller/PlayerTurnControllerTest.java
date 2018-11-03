
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
    public void setAccountBalance() {
    assertEquals(playerTurnController.getBalance(), 1000);

    playerTurnController.setAccountBalance(500);
    assertEquals(playerTurnController.getBalance(), 1500);

    playerTurnController.setAccountBalance(-100000);
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
