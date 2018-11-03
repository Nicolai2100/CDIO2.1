
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
    int x = playerTurnController.getBalance();
    assertEquals(x, 1000);

    playerTurnController.setAccountBalance(500);
    int y = playerTurnController.getBalance();
    assertEquals(y, 1500);

    }


    @Test
    public void getBalance() {
        assertEquals(playerTurnController.getBalance(), 1000);
        playerTurnController.setPosition(12);
        square.squareImpact(playerTurnController, diceCup);
        assertEquals(1650, playerTurnController.getBalance());
    }
}
