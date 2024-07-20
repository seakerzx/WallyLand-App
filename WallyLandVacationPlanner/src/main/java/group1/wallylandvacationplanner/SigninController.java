package group1.wallylandvacationplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.Button;

public class SigninController {

    @FXML
    private TextField firstNametext;

    @FXML
    private TextField lastNameText;

    @FXML
    private Button signinButton;

    @FXML
    private Label errorMessage;

    @FXML
    private void onClickSignin(ActionEvent event) throws IOException {
        String firstName = firstNametext.getText();
        String lastName = lastNameText.getText();

        if (firstName.isEmpty() || lastName.isEmpty()) {
            errorMessage.setText("The required fields are blank. Please enter your name.");
        } else {
            // Load the next page (mainpage.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainpage.fxml"));
            Parent root = loader.load();

            // Pass data to the next controller
            MainpageController mainpageController = loader.getController();
            mainpageController.initData(firstName, lastName);

            // Switch to the next scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
}
