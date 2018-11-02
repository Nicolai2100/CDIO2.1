package Model;

public class Player {

    private String name = "";
    private boolean won = false;
    private int position = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
*/
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

}
