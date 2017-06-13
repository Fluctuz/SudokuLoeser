import java.util.Arrays;

/**
 * Created by Jerk on 13.06.2017.
 */
    public class Sudokufeld {
        private int[][] feld = new int[9][9];
        private  int[][] startFeld;
        private Valuechecker valuechecker = new Valuechecker(this);

        public int getValueAt(int x, int y) {
            return (x <= 8 && x >= 0 && y <= 8 && y >= 0) ? feld[x][y] : 0;

        }


    public void setValueAt(int x, int y, int value) {
        if (x <= 8 && x >= 0 && y <= 8 && y >= 0) {
            feld[x][y] = value;
        }

    }
    public void saveToStartFeld(){
       startFeld = Arrays.stream(feld).map(int[]::clone).toArray(int[][]::new);

    }

    public void solve() {
        feld = Arrays.stream(startFeld).map(int[]::clone).toArray(int[][]::new);

        for (int x = 0; feld.length > x; x++) {
            int[] row = feld[x];
            for (int y = 0; row.length > y; y++) {
                if (feld[x][y] == 0) {
                    int rightValue = valuechecker.findRightNumber(x,y);
                    if (rightValue == 99){
                        solve();
                    }
                    feld[x][y] = rightValue;
                }
            }
        }
        System.out.println("Solved Array : ");
        print(feld);
        System.exit(1);
    }


    public void print(int[][] feld) {
        int i = 1;
        for (int[] row : feld) {
            System.out.println(row[0] + " " + row[1] + " " + row[2] + "  " + row[3] + " " + row[4] + " " + row[5] + "  " + row[6] + " " + row[7] + " " + row[8]);
            if(i%3 == 0) {
                System.out.println();
            }
            i++;
        }
    }

    public int[] getRow(int row) {
        return feld[row];
    }

    public int[] getColumn(int column) {
        int[] col = new int[9];
        int i = 0;
        for (int[] row : feld) {
            col[i] = row[column];
            i++;
        }
        return col;
    }

    public int[] getSquare(int x, int y) {

        if (x <= 2 && y <= 2) {
            return getSquareArray(0,0);
        } else if (x <= 5 && y <= 2) {
            return getSquareArray(3,0);
        } else if (x <= 8 && y <= 2) {
            return getSquareArray(6,0);
        } else if (x <= 2 && y <= 5) {
            return getSquareArray(0,3);
        } else if (x <= 5 && y <= 5) {
            return getSquareArray(3,3);
        } else if (x <= 8 && y <= 5) {
            return getSquareArray(6,3);
        } else if (x <= 2 && y <= 8) {
            return getSquareArray(0,6);
        } else if (x <= 4 && y <= 8) {
            return getSquareArray(3,6);
        } else{
            return getSquareArray(6,6);
        }
    }
    private int[] getSquareArray(int x, int y){
        int[] squareArray = new int[9];
        int l = 0;
        for (int i= 0 ; 2 >=  i; i++ ){
            for (int j = 0 ; 2 >= j; j++){
                squareArray[l] = getValueAt(x+i,y+j);
                l++;
            }
        }
        return squareArray;

    }

    public int[][] getFeld() {
        return feld;
    }
}
