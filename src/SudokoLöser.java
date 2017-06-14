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
            System.out.println("Gebe deine Zahlen ein. Drücke nur Enter zum Lösen");


            while (true){

                System.out.println("X Position:");
                String input = scanner.nextLine();
                if (input.isEmpty()){
                    break;
                }
                int x = Integer.valueOf(input);
                System.out.println("Y Position:");
                input = scanner.nextLine();
                if (input.isEmpty()){
                    break;
                }
                int y = Integer.valueOf(input);
                System.out.println("Wert:");
                input = scanner.nextLine();
                if (input.isEmpty()){
                    break;
                }
                int value = Integer.valueOf(input);
                feld.setValueAt(y-1,x-1,value);
            }
            startSolving();
        }

        private void startSolving(){
            System.out.println("Start Sudokufeld : ");
            System.out.println();
            feld.print();
            feld.saveStartFeld();
            feld.solve();
        }
    }

