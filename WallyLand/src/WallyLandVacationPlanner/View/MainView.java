/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WallyLandVacationPlanner.View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Provides the main view with navigation options.
 */
public class MainView {
    private Stage stage;

    public MainView(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        Button viewActivitiesButton = new Button("View Available Activities");
        viewActivitiesButton.setOnAction(event -> {
            ActivityRepository repository = new ActivityRepository();
            ActivityService service = new ActivityService(repository);
            ActivityController controller = new ActivityController(service);
            ActivityView activityView = new ActivityView(controller, stage);
            activityView.show();
        });

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> stage.close());

        root.getChildren().addAll(viewActivitiesButton, exitButton);

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.setTitle("WallyLand Vacation Planner");
        stage.show();
    }
}

