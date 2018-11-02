import Controller.DiceCupController;
import Controller.PlayerTurnController;
import Controller.SquareController;
import Model.Player;

import static org.junit.Assert.*;

public class PlayerTurnControllerTest {

    DiceCupController dicecup = new DiceCupController(2, 6);
    SquareController square = new SquareController();
    Player model = new Player();
    PlayerTurnController player1 = new PlayerTurnController(model, square);


    @org.junit.Test
    public void roll() {
        assertEquals(player1.getPosition(), 0);
        player1.roll(dicecup, model);
        assertTrue(player1.getPosition() != 0);

    }
}