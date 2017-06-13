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

    public int findRightNumber(int x, int y){
        ArrayList<Integer> possibleNumbers = new ArrayList<>();
        for (int i = 1; 10 > i ; i++) {
            if (isNotInRow(i,x,y) && isNotInColumn(i,x,y) && isNotInSquare(x,y,i)){
                possibleNumbers.add(i);
            }

        }
        if (!possibleNumbers.isEmpty()){
            return possibleNumbers.get(new Random().nextInt(possibleNumbers.size()));
        }
        return 99;
    }

    private boolean isNotInSquare(int x, int y, int i) {
        for (int num : feld.getSquare(x,y)){
            if (num == i){
                return false;
            }
        }
        return true;
    }

    private boolean isNotInRow(int i, int x, int y) {
        for (int num : feld.getRow(x)){
            if (num == i){
                return false;
            }
        }
        return true;
    }
    private boolean isNotInColumn(int i, int x, int y) {
        for (int num : feld.getColumn(y)){
            if (num == i){
                return false;
            }
        }
        return true;
    }
}