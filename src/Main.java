
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Jerk on 13.06.2017.
 */
public class Main extends Application {

    public static void main(String... args) {
        SudokoLöser sudokoLöser = new SudokoLöser();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("guifile.fxml"));
        Parent root = (Parent) loader.load();
        primaryStage.setTitle("Sudokulöser");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}