/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amaye
 */
package WallyLandVacationPlanner;

import WallyLandVacationPlanner.View.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class to run the WallyLand Vacation Planner application.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainView mainView = new MainView(primaryStage);
        mainView.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
