package Controller;

import Model.Player;

public class PlayerTurnController {


    public void roll(DiceCupController diceCup, Player player, SquareController square){
        square.newSquare(player.getPosition(),diceCup.rollAndGetSum());
    }


}
