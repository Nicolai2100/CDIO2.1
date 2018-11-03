package Controller;

public class SquareController {

    public void squareImpact(PlayerTurnController player, DiceCupController diceCup) {
        int newSquare = player.getPosition();
        switch (newSquare) {
            case 1:
                break;
            case 2:
                player.setAccountBalance(250);
                player.won();
                break;
            case 3:
                player.setAccountBalance(-100);
                break;
            case 4:
                player.setAccountBalance(100);
                player.won();
                break;
            case 5:
                player.setAccountBalance(-20);
                break;
            case 6:
                player.setAccountBalance(180);
                player.won();
                break;
            case 7:
                break;
            case 8:
                player.setAccountBalance(-70);
                break;
            case 9:
                player.setAccountBalance(60);
                player.won();
                break;
            case 10:
                player.setAccountBalance(-80);
                player.roll(diceCup, player);
                break;
            case 11:
                player.setAccountBalance(-50);
                break;
            case 12:
                player.setAccountBalance(650);
                player.won();
                break;
        }
    }
}
