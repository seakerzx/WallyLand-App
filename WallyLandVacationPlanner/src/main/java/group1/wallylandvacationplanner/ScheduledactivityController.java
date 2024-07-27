package group1.wallylandvacationplanner;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class ScheduledactivityController implements Initializable {

    @FXML
    private Label userActivity1;
    @FXML
    private Label userTimeActivity1;
    @FXML
    private Label userActivity2;
    @FXML
    private Label userTimeActivity2;
    @FXML
    private Label userActivity3;
    @FXML
    private Label userTimeActivity3;
    @FXML
    private ComboBox<String> menuButton;

    private ActivityController activityController;
    private Customer currentCustomer;
    private List<UserActivity> scheduledActivities;

    public ScheduledactivityController() {
        // Default constructor required by FXML
    }

    public void setActivityController(ActivityController activityController) {
        this.activityController = activityController;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        activityController = ActivityController.getInstance();
        currentCustomer = activityController.getCustomers().get(0);
        scheduledActivities = activityController.getScheduledActivities();
        displayScheduledActivities();

        // Populate the ComboBox with items
        menuButton.getItems().addAll(
            "Main Page",
            "Available Activities",
            "Scheduled Activities",
            "Customer Service"
        );
    }

    private void displayScheduledActivities() {
        if (scheduledActivities.size() > 0) {
            userActivity1.setText(scheduledActivities.get(0).getActivity().getName());
            userTimeActivity1.setText(scheduledActivities.get(0).getActivity().getTimeSlot());
        }
        if (scheduledActivities.size() > 1) {
            userActivity2.setText(scheduledActivities.get(1).getActivity().getName());
            userTimeActivity2.setText(scheduledActivities.get(1).getActivity().getTimeSlot());
        }
        if (scheduledActivities.size() > 2) {
            userActivity3.setText(scheduledActivities.get(2).getActivity().getName());
            userTimeActivity3.setText(scheduledActivities.get(2).getActivity().getTimeSlot());
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
        Stage stage = (Stage) menuButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
