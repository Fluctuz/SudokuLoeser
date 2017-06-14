import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jerk on 13.06.2017.
 */

public class Valuechecker {
    private Sudokufeld feld;

    public Valuechecker(Sudokufeld feld) {
        this.feld = feld;
    }

    public int findLegalNumber(int x, int y){
        ArrayList<Integer> possibleNumbers = new ArrayList<>();

        for (int i = 1; 10 > i ; i++) {
            if (isNotInRow(i,x) && isNotInColumn(i,y) && isNotInSquare(x,y,i)){
                possibleNumbers.add(i);
            }
        }

        if (!possibleNumbers.isEmpty()){
            //Pick a random legal Number
            return possibleNumbers.get(new Random().nextInt(possibleNumbers.size()));
        }
        //No Legal Number exits
        return 99;
    }

    private boolean isNumberInArray(int number, int[] array){
        for (int num : array){
            if (num == number){
                return false;
            }
        }
        return true;
    }

    private boolean isNotInSquare(int x, int y, int i) {
       return isNumberInArray(i,feld.getSquareArrayByCoordinate(x,y));
    }

    private boolean isNotInRow(int i, int x) {
       return isNumberInArray(i, feld.getRow(x));

    }
    private boolean isNotInColumn(int i, int y) {
        return isNumberInArray(i,feld.getColumn(y));
    }
}