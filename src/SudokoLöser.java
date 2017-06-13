/**
 * Created by Timonux on 13.06.2017.
 */
import java.util.Scanner;

    /**
     * Created by Jerk on 13.06.2017.
     */
    public class SudokoLöser {
        private Sudokufeld feld = new Sudokufeld();


        public SudokoLöser() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Geb deine Zahlen");
            while (true){

                System.out.println("X Position:");
                int x = Integer.valueOf(scanner.nextLine());
                System.out.println("Y Position:");
                int y = Integer.valueOf(scanner.nextLine());
                System.out.println("Wert:");
                int value = Integer.valueOf(scanner.nextLine());
                feld.setValueAt(y-1,x-1,value);
                System.out.println("Solve ? y/n");
                if (scanner.nextLine().equals("y"))
                {
                    feld.print();
                    break;
                }

            }
            feld.saveToStartFeld();
            feld.solve();
        }


    }

