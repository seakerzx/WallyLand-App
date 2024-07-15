package group1.wallylandvacationplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SigninController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private void onClickSignin(ActionEvent event) throws IOException {
        //String firstName = firstNameField.getText();
        //String lastName = lastNameField.getText();

        // Load the next page (mainpage.fxml)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainpage.fxml"));
        Parent root = loader.load();

        // Optionally pass data to the next controller
        //MainpageController mainpageController = loader.getController();
        //mainpageController.initData(firstName, lastName);

        // Switch to the next scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

