package javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller {

    @FXML
    private TextField L41;

    @FXML
    private TextField L31;

    @FXML
    private TextField L11;

    @FXML
    private GridPane firstSquare;

    @FXML
    void L21(ActionEvent event) {
        System.out.println("L21 EVENT");
    }

}
