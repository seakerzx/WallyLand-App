package group1.wallylandvacationplanner;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainpageController {

    @FXML
    private Label welcomeLabel;
    @FXML
    private ComboBox<String> menuButton;

    private ActivityController activityController;
    private Customer currentCustomer;

    public void initialize() {
        activityController = ActivityController.getInstance();
        currentCustomer = new Customer(1, "John Doe", "john.doe@example.com");
        activityController.addCustomer(currentCustomer);

        welcomeLabel.setText("Welcome to WallyLand Vacation Planner");

        menuButton.getItems().addAll(
            "Main Page",
            "Available Activities",
            "Scheduled Activities",
            "Customer Service"
        );
    }

    public void initData(String firstName, String lastName) {
        welcomeLabel.setText("Welcome, " + firstName + " " + lastName + " to WallyLand Vacation Planner");
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

    @FXML
    private void handleExitButtonAction(ActionEvent event) {
        //Get Current Stage
        Stage stage = (Stage) menuButton.getScene().getWindow();
        //Close the window
        stage.close();
    }
}
