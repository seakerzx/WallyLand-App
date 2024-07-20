package group1.wallylandvacationplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the initial FXML file (signin.fxml)
        Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
        primaryStage.setTitle("WallyLand Vacation Planner APP");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
