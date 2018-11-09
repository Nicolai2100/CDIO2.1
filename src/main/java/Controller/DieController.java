package Controller;

import Model.Die;

public class DieController {
    private Die model;

    public DieController(int noFaces) {
        this.model = new Die(noFaces);
    }

    //The method generates an integer between 1 and 6.
    public void roll() {
        model.setFaceValue((int) ((Math.random() * model.getMAX()) + 1));
    }

    public int getFaceValue() {
        return model.getFaceValue();
    }
    public int getMax(){
       return model.getFaceValue();
    }
}
