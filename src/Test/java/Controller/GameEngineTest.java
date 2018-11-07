package Controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameEngineTest {
    GameEngine gameEngine = new GameEngine();

    @Test
    public void playGame() {
        gameEngine.setUpGame();
        assertEquals(PlayerTurnController.getNumOfPlayers(), 2);
    }
}