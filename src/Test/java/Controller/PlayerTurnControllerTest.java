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
        System.out.println(playerTurnController.getPosition());
        square.newSquare(playerTurnController.roll(diceCup),playerTurnController.getPosition(), playerTurnController);
        square.squareImpact(playerTurnController, diceCup);
        System.out.println(playerTurnController.getPosition());
        System.out.println(playerTurnController.getBalance());
        //assertTrue(playerTurnController.getBalance() != 1000);

    }
}