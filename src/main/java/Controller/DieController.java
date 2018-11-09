package Controller;

import Model.Die;

public class DieController {
    private Die model;

    public DieController(int value) {
        this.model = new Die(value);
    }
    //The method generates an integer between 1 and 6.
    public void roll() {
        model.setFaceValue((int) ((Math.random() * model.getMax()) + 1));
    }

    public int getFaceValue() {
        return model.getFaceValue();
    }
    public void setMax(int value){
        model.setMax(value);
    }
    public int getMax(){
       return model.getFaceValue();
    }
}
