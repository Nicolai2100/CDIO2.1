package Controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiceCupControllerTest {
    DieController die = new DieController(6);
    DiceCupController diceCup = new DiceCupController(2,6);

    @Test
    public void rollAllDice() {
        assertEquals(die.getFaceValue(), 0);
        diceCup.rollAllDice();
        assertTrue(diceCup.getSum() != 0);
    }

    @Test
    public void getSum() {
        rollAllDice();
        die.getFaceValue();


        assertEquals(diceCup.getSum(),);
    }

    @Test
    public void rollAndGetSum() {
    }
}