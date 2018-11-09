package Controller;

import View.Gui_Handler;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceCupControllerTest {
    Gui_Handler gui = new Gui_Handler();
    DiceCupController diceCup = new DiceCupController(2,gui);

    @Test
    public void rollAllDice() {
        int die1 = diceCup.getRef(0).getFaceValue();
        int die2 = diceCup.getRef(1).getFaceValue();
        assertEquals(0, die1);
        assertEquals(0, die2);
        diceCup.rollAllDice();
        die1 = diceCup.getRef(0).getFaceValue();
        die2 = diceCup.getRef(1).getFaceValue();
        assertTrue(1 <= die1 && die1 <= 6);
        assertTrue(1 <= die2 && die2 <= 6);
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
        int metodeSum = diceCup.rollAndGetSum();
        int sum = diceCup.getRef(0).getFaceValue() + diceCup.getRef(1).getFaceValue();
        assertEquals(metodeSum, sum);
        assertTrue(2 <= metodeSum && metodeSum <= 12);

    }
}