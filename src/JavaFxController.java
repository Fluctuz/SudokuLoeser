import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class JavaFxController implements Initializable {
    @FXML
    private Button solveBtn;

    @FXML//Dont delete this lines !!!
    private TextField T0,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22,T23,T24,T25,T26,T27,T28,T29,T30,T31,T32,T33,T34,T35,T36,T37,T38,T39,T40,T41,T42,T43,T44,T45,T46,T47,T48,T49,T50,T51,T52,T53,T54,T55,T56,T57,T58,T59,T60,T61,T62,T63,T64,T65,T66,T67,T68,T69,T70,T71,T72,T73,T74,T75,T76,T77,T78,T79,T80;

    private ArrayList<TextField> sudokuFields = new ArrayList<>();


    @FXML
    void onPressed(Event event) {
        int[][] sudokuFeld = fetchValuesFromFeld();
        SudokoLöser löser = new SudokoLöser(true);
        setAllValues(löser.solveSudokuFeld(sudokuFeld));
    }

    private void setAllValues(int[][] feld) {
        int counter = 0;
        for (TextField field : sudokuFields) {
            field.setText(String.valueOf(feld[counter / 9][counter % 9]));
            counter++;
        }
    }


    private int[][] fetchValuesFromFeld() {
        int[][] sudokuFeld = new int[9][9];
        int counter = 0;
        for (TextField field : sudokuFields) {
            String stringValue = field.getText();
            if (!stringValue.isEmpty()) {
                sudokuFeld[counter / 9][counter % 9] = Integer.valueOf(stringValue);
            } else {
                sudokuFeld[counter / 9][counter % 9] = 0;
            }
            counter++;
        }
        return sudokuFeld;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        collectAllFields();
        setMaxCharacterForTextField();
    }


    private void  collectAllFields(){
        for (int i = 0; 81 > i; i++) {
            sudokuFields.add(getTextFieldByName("T" + i));
        }
    }

    private void setMaxCharacterForTextField() {
        ChangeListener<String> maxLimitChar = new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (newValue.length() > 1) {
                    StringProperty textProperty = (StringProperty) ov;
                    TextField textField = (TextField) textProperty.getBean();
                    textField.setText(oldValue);
                }
            }
        };
        for (TextField field : sudokuFields) {
           field.textProperty().addListener(maxLimitChar);
        }
    }

    private TextField getTextFieldByName(String name) {
        try {
            return (TextField) JavaFxController.class.getDeclaredField(name).get(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return new TextField();

    }
}
