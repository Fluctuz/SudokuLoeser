/**
 * Created by Jerk on 13.06.2017.
 */
public class Sudokufeld {
    private int[][] feld = new int[9][9];
    private int[][] startFeld;
    private Valuechecker valuechecker = new Valuechecker(this);
    private int[][] solvedFeld = new int[11][];


    public int[][] solve() {
        boolean allValuesLegal = true;
        feld = copy2DArray(startFeld);

        for (int x = 0; feld.length > x; x++) {
            int[] row = feld[x];
            for (int y = 0; row.length > y; y++) {
                if (feld[x][y] == 0) {
                    int rightValue = valuechecker.findLegalNumber(x, y);
                    if (rightValue == 99) {
                        allValuesLegal = false;
                    }
                    feld[x][y] = rightValue;
                }
            }
        }

        if (allValuesLegal) {
            System.out.println("Solved Array : ");
            System.out.println();
            print(feld);
            solvedFeld = feld;
            return solvedFeld;
        } else {
            //next try
            solve();
        }
        return solvedFeld;
    }

    public void saveStartFeld() {
        startFeld = copy2DArray(feld);
    }


    public void saveStartFeld(int[][] feld) {
        startFeld = copy2DArray(feld);
    }

    //Funktion überladen in java kann man 2 Funktion mit gleichen Namen aber verschiedener Argumnte haben
    public void print() {
        print(feld);
    }

    public void print(int[][] feld) {
        int i = 1;
        for (int[] row : feld) {
            System.out.println(row[0] + " " + row[1] + " " + row[2] + "  " + row[3] + " " + row[4] + " " + row[5] + "  " + row[6] + " " + row[7] + " " + row[8]);
            if (i % 3 == 0) {
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

    public int[] getSquareArrayByCoordinate(int x, int y) {

        if (x <= 2 && y <= 2) {
            return getSquareArrayOf(0, 0);
        } else if (x <= 5 && y <= 2) {
            return getSquareArrayOf(3, 0);
        } else if (x <= 8 && y <= 2) {
            return getSquareArrayOf(6, 0);
        } else if (x <= 2 && y <= 5) {
            return getSquareArrayOf(0, 3);
        } else if (x <= 5 && y <= 5) {
            return getSquareArrayOf(3, 3);
        } else if (x <= 8 && y <= 5) {
            return getSquareArrayOf(6, 3);
        } else if (x <= 2 && y <= 8) {
            return getSquareArrayOf(0, 6);
        } else if (x <= 4 && y <= 8) {
            return getSquareArrayOf(3, 6);
        } else {
            return getSquareArrayOf(6, 6);
        }
    }

    private int[] getSquareArrayOf(int x, int y) {
        int[] squareArray = new int[9];
        int l = 0;
        for (int i = 0; 2 >= i; i++) {
            for (int j = 0; 2 >= j; j++) {
                squareArray[l] = getValueAt(x + i, y + j);
                l++;
            }
        }
        return squareArray;
    }

    private int[][] copy2DArray(int[][] array) {
        int[][] copyedArray = new int[9][9];
        for (int x = 0; 9 > x; x++) {
            for (int y = 0; 9 > y; y++) {
                copyedArray[x][y] = array[x][y];
            }
        }
        return copyedArray;
    }

    private int getValueAt(int x, int y) {
        return (x <= 8 && x >= 0 && y <= 8 && y >= 0) ? feld[x][y] : 0;
    }


    public void setValueAt(int x, int y, int value) {
        //Check if value in sudokufeld
        if (x <= 8 && x >= 0 && y <= 8 && y >= 0) {
            feld[x][y] = value;
        }
    }

}
