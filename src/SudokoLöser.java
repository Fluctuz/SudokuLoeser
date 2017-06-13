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
            System.out.println("Gebe deine Zahlen. Drücke Enter ohne eine Zahl um zu Lösen");
            while (true){

                System.out.println("X Position:");
                String input = scanner.nextLine();
                if (input.isEmpty()){
                    feld.print(feld.getFeld());
                    break;
                }
                int x = Integer.valueOf(input);
                System.out.println("Y Position:");
                input = scanner.nextLine();
                if (input.isEmpty()){
                    feld.print(feld.getFeld());
                    break;
                }
                int y = Integer.valueOf(input);
                System.out.println("Wert:");
                int value = Integer.valueOf(scanner.nextLine());
                feld.setValueAt(y-1,x-1,value);


            }
            feld.saveToStartFeld();
            feld.solve();
        }


    }

