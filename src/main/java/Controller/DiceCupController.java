package Controller;

import View.Gui_Handler;

public class DiceCupController {
    private final DieController[] dice;
    private Gui_Handler gui;

    //Constructor
    public DiceCupController(int noDice, Gui_Handler gui) {
        this.gui = gui;
        dice = new DieController[noDice];
        int noFaces = setDieFaces();
        for (int i = 0; i < noDice; i++) {
            dice[i] = new DieController(noFaces);
        }
    }
    public int setDieFaces(){
        int noFaces = gui.setDieFaces();
        return noFaces;
    }
    public DieController getRef(int i) {
        return dice[i];
    }

    //The method rolls two dice and returns their value as an integer.
    public void rollAllDice() {
        for (DieController dieController : dice) {
            dieController.roll();
        }
    }

    public int getSum() {
        int sum = 0;
        for (DieController dieController : dice) {
            sum += dieController.getFaceValue();
        }
        return sum;
    }

    public int rollAndGetSum() {
        rollAllDice();
        return getSum();
    }


}
