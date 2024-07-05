/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WallyLandVacationPlanner.View;

import WallyLandVacationPlanner.Model.Activity;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class ActivityCell extends ListCell<Activity> {
    @Override
    protected void updateItem(Activity activity, boolean empty) {
        super.updateItem(activity, empty);

        if (empty || activity == null) {
            setText(null);
            setGraphic(null);
        } else {
            HBox hBox = new HBox();
            Text id = new Text("ID: " + activity.getId());
            Text name = new Text("Name: " + activity.getName());
            Text timeSlot = new Text("Time Slot: " + activity.getTimeSlot());

            hBox.getChildren().addAll(id, name, timeSlot);
            hBox.setSpacing(10);

            setGraphic(hBox);
        }
    }
}

