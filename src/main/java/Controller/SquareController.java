package Controller;

public class SquareController {

    public void squareImpact(PlayerTurnController player, DiceCupController diceCup) {
        int newSquare = player.getPosition();
        switch (newSquare) {
            case 1:
                break;
            case 2:
                player.updateAccountBalance(250);
                player.won();
                break;
            case 3:
                player.updateAccountBalance(-100);
                break;
            case 4:
                player.updateAccountBalance(100);
                player.won();
                break;
            case 5:
                player.updateAccountBalance(-20);
                break;
            case 6:
                player.updateAccountBalance(180);
                player.won();
                break;
            case 7:
                break;
            case 8:
                player.updateAccountBalance(-70);
                break;
            case 9:
                player.updateAccountBalance(60);
                player.won();
                break;
            case 10:
                player.updateAccountBalance(-80);

                player.roll(diceCup, player);
                break;
            case 11:
                player.updateAccountBalance(-50);
                break;
            case 12:
                player.updateAccountBalance(650);
                player.won();
                break;
        }
    }
}
