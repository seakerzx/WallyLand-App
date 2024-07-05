/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WallyLandVacationPlanner.View;

import WallyLandVacationPlanner.Model.Activity;
import WallyLandVacationPlanner.Controller.ActivityController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * Provides the user interface for viewing and booking activities.
 */
public class ActivityView {
    private ActivityController controller;
    private Stage stage;

    public ActivityView(ActivityController controller, Stage stage) {
        this.controller = controller;
        this.stage = stage;
    }

    public void show() {
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        List<Activity> activities = controller.getAvailableActivities();
        ObservableList<Activity> items = FXCollections.observableArrayList(activities);

        ListView<Activity> listView = new ListView<>(items);
        listView.setCellFactory(param -> new ActivityCell());

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            MainView mainView = new MainView(stage);
            mainView.show();
        });

        root.getChildren().addAll(listView, backButton);

        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Available Activities");
        stage.show();
    }
}
