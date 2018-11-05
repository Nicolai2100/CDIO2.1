package Model;

public class Player {

    private String name = "";
    private boolean won = false;
    private int position = 1;
    private int objectNumber;

    public Player(int objectNumber){
        this.objectNumber = objectNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public boolean getWon() {
        return won;
    }

    public int getObjectNumber() {
        return objectNumber;
    }
}
