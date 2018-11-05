package Controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiceCupControllerTest {
    DiceCupController diceCup = new DiceCupController(2,6);

    @Test
    public void rollAllDice() {
        int die1 = diceCup.getRef(0).getFaceValue();
        int die2 = diceCup.getRef(1).getFaceValue();
        assertEquals(die1 + die2, 0);
        diceCup.rollAllDice();
        die1 = diceCup.getRef(0).getFaceValue();
        die2 = diceCup.getRef(1).getFaceValue();
        assertEquals( die1 + die2, diceCup.getSum());
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
        int sum = diceCup.rollAndGetSum();
        DieController die1 = diceCup.getRef(0);
        DieController die2 = diceCup.getRef(1);
        assertEquals(sum, (die1.getFaceValue() + die2.getFaceValue()));
        assertTrue(2 <= sum && sum <= 12);

    }
}