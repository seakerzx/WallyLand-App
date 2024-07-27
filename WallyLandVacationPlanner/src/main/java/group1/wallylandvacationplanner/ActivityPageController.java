package group1.wallylandvacationplanner;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class ActivityPageController implements Initializable {

    @FXML
    private ComboBox<String> menuButton;
    @FXML
    private Label activityField1;
    @FXML
    private Label activityTimeSlot1;
    @FXML
    private Label activityField2;
    @FXML
    private Label activityTimeSlot2;
    @FXML
    private Label activityField3;
    @FXML
    private Label activityTimeSlot3;
    @FXML
    private Button selectButton1;
    @FXML
    private Button selectButton2;
    @FXML
    private Button selectButton3;
    @FXML
    private Label isAvailable1;
    @FXML
    private Label isAvailable2;
    @FXML
    private Label isAvailable3;

    private ActivityController activityController;
    private Customer currentCustomer;
    private List<Activity> availableActivities;

    public ActivityPageController() {
        // Default constructor required by FXML
    }

    public void setActivityController(ActivityController activityController) {
        this.activityController = activityController;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        activityController = ActivityController.getInstance();
        currentCustomer = activityController.getCustomers().get(0);
        availableActivities = activityController.getAvailableActivities();
        displayActivities();

        // Populate the ComboBox with items
        menuButton.getItems().addAll(
            "Main Page",
            "Available Activities",
            "Scheduled Activities",
            "Customer Service"
        );
    }

    private void displayActivities() {
        if (availableActivities.size() > 0) {
            activityField1.setText(availableActivities.get(0).getName());
            activityTimeSlot1.setText(availableActivities.get(0).getTimeSlot());
            isAvailable1.setText(availableActivities.get(0).isAvailable() ? "Yes" : "No");
            selectButton1.setVisible(true);
        } else {
            activityField1.setText("");
            activityTimeSlot1.setText("");
            isAvailable1.setText("");
            selectButton1.setVisible(false);
        }
        
        if (availableActivities.size() > 1) {
            activityField2.setText(availableActivities.get(1).getName());
            activityTimeSlot2.setText(availableActivities.get(1).getTimeSlot());
            isAvailable2.setText(availableActivities.get(1).isAvailable() ? "Yes" : "No");
            selectButton2.setVisible(true);
        } else {
            activityField2.setText("");
            activityTimeSlot2.setText("");
            isAvailable2.setText("");
            selectButton2.setVisible(false);
        }
        
        if (availableActivities.size() > 2) {
            activityField3.setText(availableActivities.get(2).getName());
            activityTimeSlot3.setText(availableActivities.get(2).getTimeSlot());
            isAvailable3.setText(availableActivities.get(2).isAvailable() ? "Yes" : "No");
            selectButton3.setVisible(true);
        } else {
            activityField3.setText("");
            activityTimeSlot3.setText("");
            isAvailable3.setText("");
            selectButton3.setVisible(false);
        }
    }

    @FXML
    private void onClickSelectActivity(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        int activityIndex = -1;

        if (sourceButton == selectButton1) {
            activityIndex = 0;
        } else if (sourceButton == selectButton2) {
            activityIndex = 1;
        } else if (sourceButton == selectButton3) {
            activityIndex = 2;
        }

        if (activityIndex != -1 && activityIndex < availableActivities.size()) {
            Activity selectedActivity = availableActivities.get(activityIndex);
            boolean booked = activityController.bookActivity(currentCustomer.getId(), selectedActivity.getId());
            if (booked) {
                System.out.println("Activity booked successfully");
                availableActivities.remove(activityIndex);
                displayActivities();
            } else {
                System.out.println("Failed to book activity.");
            }
        }
    }

    @FXML
    private void handleMenuButtonAction(ActionEvent event) throws IOException {
        String selectedPage = menuButton.getValue();
        String fxmlFile = "";

        switch (selectedPage) {
            case "Main Page":
                fxmlFile = "mainpage.fxml";
                break;
            case "Available Activities":
                fxmlFile = "activitypage.fxml";
                break;
            case "Scheduled Activities":
                fxmlFile = "scheduledactivity.fxml";
                break;
            case "Customer Service":
                fxmlFile = "customerservice.fxml";
                break;
            default:
                return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        if (selectedPage.equals("Available Activities")) {
            ActivityPageController controller = loader.getController();
            controller.setActivityController(activityController);
        } else if (selectedPage.equals("Scheduled Activities")) {
            ScheduledactivityController controller = loader.getController();
            controller.setActivityController(activityController);
        }

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
