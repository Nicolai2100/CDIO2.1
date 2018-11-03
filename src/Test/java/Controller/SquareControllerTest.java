package Controller;

import Model.Player;
import Model.Square;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareControllerTest {

    Square model = new Square();
    SquareController square = new SquareController();

    Player playerModel = new Player();
    DiceCupController diceCup = new DiceCupController(2,6);
    PlayerTurnController player = new PlayerTurnController(playerModel,square);

    @Test
    public void newSquare() {
        for (int roll = 1; roll <= 1000; roll++){
            int rollSum = diceCup.rollAndGetSum();
            player.newSquare(rollSum, player.getPosition());
            int newPlayerPosition = player.getPosition();
            assertTrue(1 <= newPlayerPosition && newPlayerPosition <= 12 );
        }





    }

    @Test
    public void squareImpact() {
        player.setPosition(2);
        square.squareImpact(player, diceCup);
        int x = player.getBalance();
        assertEquals(x, 1250);
    }
}