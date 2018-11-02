package Controller;

import Model.Square;

public class SquareController {
    int newSquare;

    public SquareController(){}

    public int curSquare(int rollsum, int getSquare){
        return rollsum + getSquare;
    }

    public int newSquare(int rollsum, int getSqaure){
        if (curSquare(rollsum, getSqaure) > 12)
            newSquare = curSquare(rollsum, getSqaure) % 12;
        else{
            newSquare = curSquare(rollsum, getSqaure);
        }
        return newSquare;
    }




}
