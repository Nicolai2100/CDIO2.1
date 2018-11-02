package Controller;

import Model.Square;

public class SquareController {
    int newSquare;

    public SquareController(){}


    public int newSquare(int rollsum, int getSqaure){
        if (rollsum + getSqaure > 12)
            newSquare = (rollsum + getSqaure) % 12;
        else{
            newSquare = rollsum + getSqaure;
        }
        return newSquare;
    }


    public void squareImpact(int newSquare){
        switch (newSquare){
            case 1:
                // beskeder(1)
                 // ekstra tur
                //Account(); // konto
                break;
            case 2:
                System.out.println();
                break;
            case 3:
                System.out.println();
                break;
            case 4:
                System.out.println();
                break;
            case 5:
                System.out.println();
                break;
            case 6:
                System.out.println();
                break;
            case 7:
                System.out.println();
                break;
            case 8:
                System.out.println();
                break;
            case 9:
                System.out.println();
                break;
            case 10:
                System.out.println();
                break;
            case 11:
                System.out.println();
                break;
            case 12:
                System.out.println();
                break;
            default: ;
        }
    }




}
