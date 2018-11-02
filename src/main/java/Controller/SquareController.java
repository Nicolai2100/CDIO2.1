package Controller;

import Model.Player;
import Model.Square;

public class SquareController {
    Square model = new Square();

    public SquareController(){}

    public int newSquare(int rollsum, int getSqaure){
        if (rollsum + getSqaure > 12)
            model.setSquare((rollsum + getSqaure) % 12);
//            newSquare = (rollsum + getSqaure) % 12;
        else{
            model.setSquare(rollsum + getSqaure);
//            newSquare = rollsum + getSqaure;
        }
//        return newSquare;
        return model.getSquare();
    }

    public void squareImpact(PlayerTurnController player, DiceCupController diceCup){
        int newSquare = player.getPosition();
        switch (newSquare){
            case 1:
                // account
                break;
            case 2:
                // account 250
                break;
            case 3:
                // account -100
                break;
            case 4:
                // account 100
                break;
            case 5:
                // account -20
                break;
            case 6:
                // account 180
                break;
            case 7:
                // account 0
                break;
            case 8:
                // account -70
                break;
            case 9:
                // account 60
                break;
            case 10:
                // account -80
                player.roll(diceCup, player);
                break;
            case 11:
                // account -50
                break;
            case 12:
                // account 650
                break;
            default: ;
        }
    }




}
