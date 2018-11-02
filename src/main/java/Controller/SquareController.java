package Controller;

import Model.Square;

public class SquareController {
    Square model = new Square();

    public SquareController(){}

    public int newSquare(int rollsum, int getSqaure, PlayerTurnController player){
        if (rollsum + getSqaure > 12) {
            model.setSquare((rollsum + getSqaure) % 12);
        player.setPosition(model.getSquare());
        }
        else{
            model.setSquare(rollsum + getSqaure);
            player.setPosition(model.getSquare());
        }
        return model.getSquare();
    }

    public void squareImpact(PlayerTurnController player, DiceCupController diceCup){
        int newSquare = player.getPosition();
        switch (newSquare){
            case 1:
                // account
                break;
            case 2:
                player.setAccountBalance(250);
                // account 250
                break;
            case 3:
                player.setAccountBalance(-100);
                // account -100
                break;
            case 4:
                player.setAccountBalance(100);
                // account 100
                break;
            case 5:
                player.setAccountBalance(-20);
                // account -20
                break;
            case 6:
                player.setAccountBalance(180);
                // account 180
                break;
            case 7:
                // account 0
                break;
            case 8:
                player.setAccountBalance(-70);
                // account -70
                break;
            case 9:
                player.setAccountBalance(60);
                // account 60
                break;
            case 10:
                player.setAccountBalance(-80);
                // account -80
                player.roll(diceCup);
                break;
            case 11:
                player.setAccountBalance(-50);
                // account -50
                break;
            case 12:
                player.setAccountBalance(650);
                // account 650
                break;

        }
    }
}
