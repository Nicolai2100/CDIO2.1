package Model;

public class Die {

    private final int MAX;
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
    public int getMAX() {
        return MAX;
    }
}
