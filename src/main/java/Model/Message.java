package Model;

public class Message {
    private String rules="Rules of the game\n" +
            "Players switch 2 dice and land on a field with numbers from 2 to 12.\n" +
            "To land on each of these fields has a positive or negative effect on the players' money.\n" +
            "Players start with a cash of 1000. The game is over when a player reaches 3000.";

    private String square1=" passed start";
    private String square2=" have found the tower, inside there was 250 gold coins";
    private String square3=" fell into the crater and dropped 100 gold coins";
    private String square4=" have reached the palace gates and have been granted 100 gold coins";
    private String square5=" were freezing in the cold desert and spent 20 gold coins on firewood";
    private String square6=" got into the walled city and found 180 gold coins in the street";
    private String square7=" stopped to rest at the monastery";
    private String square8=" were robbed for 70 gold coins in the black cave";
    private String square9=" found 60 gold coins in some huts in the mountains";
    private String square10=" 80 gold coins you bought an extra turn, at the werewall";
    private String square11=" avoid conscription for work in the pit, it cost you 50 gold coins to bribe a civil servant";
    private String square12=" have found gold in the mountains and have sold it for 650 gold coins";

    public String getRules() {return rules;}
    public String getSquare1() {return square1;}
    public String getSquare2() {return square2;}
    public String getSquare3() {return square3;}
    public String getSquare4() {return square4;}
    public String getSquare5() {return square5;}
    public String getSquare6() {return square6;}
    public String getSquare7() {return square7;}
    public String getSquare8() {return square8;}
    public String getSquare9() {return square9;}
    public String getSquare10() {return square10;}
    public String getSquare11() {return square11;}
    public String getSquare12() {return square12;}

}
