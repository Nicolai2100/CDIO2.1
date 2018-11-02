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
        assertEquals(diceCup.getSum(), 0);
        rollAllDice();
        DieController die1 = diceCup.getRef(0);
        DieController die2 = diceCup.getRef(1);
        assertEquals(diceCup.getSum(),die1.getFaceValue() + die2.getFaceValue());
    }

    @Test
    public void rollAndGetSum() {
        assertEquals(diceCup.getSum(), 0);
        diceCup.rollAndGetSum();
        DieController die1 = diceCup.getRef(0);
        DieController die2 = diceCup.getRef(1);
        int sum = die1.getFaceValue()+die2.getFaceValue();
        assertEquals(diceCup.rollAndGetSum(), sum);
        assertTrue(2 <= sum && sum <= 12);

    }
}