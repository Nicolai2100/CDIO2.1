package Model;

public class Die {
    private int MAX;
    private int faceValue;

    public Die(int noFaces) {
        this.MAX = noFaces;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }
    public void setMax(int value){this.MAX = value;}
    public int getMax() {
        return MAX;
    }
}
