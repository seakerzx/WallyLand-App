package group1.wallylandvacationplanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.*;

public class CustomerSupport extends Application {
    private static final int MAX_TICKETS = 100;
    private Set<Integer> usedTicketNumbers = new HashSet<>();
    private Map<Integer, String> tickets = new HashMap<>();
    private TextArea complaintTextArea;
    private Label ticketNumberLabel;
    private Random rand = new Random();

    @Override
    public void start(Stage primaryStage) {
        // Setup the frame
        primaryStage.setTitle("Customer Service");

        // Create components
        BorderPane panel = new BorderPane();
        panel.setPadding(new Insets(10, 20, 10, 20));

        complaintTextArea = new TextArea();
        complaintTextArea.setWrapText(true);

        Button reviewButton = new Button("Review Issue");
        reviewButton.setOnAction(e -> reviewIssue());

        Button viewTicketButton = new Button("View Ticket");
        viewTicketButton.setOnAction(e -> viewTicket());

        Button showUsedTicketsButton = new Button("Show Used Tickets");
        showUsedTicketsButton.setOnAction(e -> showUsedTickets());

        ticketNumberLabel = new Label("Ticket Number: ");

        // Create a panel for the buttons and add them to it
        HBox buttonPanel = new HBox(10);
        buttonPanel.getChildren().addAll(reviewButton, viewTicketButton, showUsedTicketsButton);

        // Add components to panel
        panel.setCenter(complaintTextArea);
        panel.setBottom(buttonPanel);
        panel.setTop(ticketNumberLabel);

        // Add panel to frame
        primaryStage.setScene(new Scene(panel, 400, 300));
        primaryStage.show();
    }

    private void reviewIssue() {
        String complaint = complaintTextArea.getText();
        if (!complaint.isEmpty()) {
            Integer ticketNumber = generateUniqueTicketNumber();
            if (ticketNumber != null) {
                handleUI(complaint, ticketNumber);
            } else {
                showAlert(Alert.AlertType.ERROR, "All ticket numbers have been used.");
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Please Enter a Complaint Before Reviewing.");
        }
    }

    private void handleUI(String complaint, int ticketNumber) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Review Complaint");
        alert.setHeaderText("Issue: \n" + complaint + "\n\nTicket Number: " + ticketNumber);
        alert.setContentText("Submit This Issue?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ticketNumberLabel.setText("Ticket#: " + ticketNumber);
            usedTicketNumbers.add(ticketNumber);
            tickets.put(ticketNumber, complaint);
            complaintTextArea.setText("");
            showAlert(Alert.AlertType.INFORMATION, "Complaint Submitted With Ticket#: " + ticketNumber);
        }
    }

    private void viewTicket() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("View Ticket");
        dialog.setHeaderText("Enter the ticket number:");
        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            try {
                int ticketNumber = Integer.parseInt(result.get());
                String complaint = tickets.get(ticketNumber);
                if (complaint != null) {
                    showAlert(Alert.AlertType.INFORMATION, "Ticket#: " + ticketNumber + "\n\nIssue: \n" + complaint);
                } else {
                    showAlert(Alert.AlertType.ERROR, "No ticket found with number: " + ticketNumber);
                }
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Invalid ticket number.");
            }
        }
    }

    private void showUsedTickets() {
        StringBuilder usedTickets = new StringBuilder();
        for (int ticketNumber : usedTicketNumbers) {
            usedTickets.append(ticketNumber).append("\n");
        }
        showAlert(Alert.AlertType.INFORMATION, "Used Ticket Numbers:\n" + usedTickets.toString());
    }

    private Integer generateUniqueTicketNumber() {
        if (usedTicketNumbers.size() == MAX_TICKETS) {
            return null;
        }
        int ticketNumber;
        do {
            ticketNumber = rand.nextInt(MAX_TICKETS) + 1;
        } while (usedTicketNumbers.contains(ticketNumber));
        return ticketNumber;
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
}