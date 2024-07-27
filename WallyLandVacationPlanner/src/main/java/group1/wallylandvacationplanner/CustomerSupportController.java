package group1.wallylandvacationplanner;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.util.*;

public class CustomerSupportController {
    private static final int MAX_TICKETS = 100;
    private Set<Integer> usedTicketNumbers = new HashSet<>();
    private Map<Integer, String> tickets = new HashMap<>();
    private Random rand = new Random();

    @FXML
    private TextArea complaintTextArea;

    @FXML
    private Label ticketNumberLabel;

    @FXML
    private void reviewIssue() {
        String complaint = complaintTextArea.getText();
        if (!complaint.isEmpty()) {
            Integer ticketNumber = generateUniqueTicketNumber();
            if (ticketNumber != null) {
                handleUI(complaint, ticketNumber);
            } else {
                showAlert(AlertType.ERROR, "All ticket numbers have been used.");
            }
        } else {
            showAlert(AlertType.ERROR, "Please Enter a Complaint Before Reviewing.");
        }
    }

    @FXML
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
                    showAlert(AlertType.INFORMATION, "Ticket#: " + ticketNumber + "\n\nIssue: \n" + complaint);
                } else {
                    showAlert(AlertType.ERROR, "No ticket found with number: " + ticketNumber);
                }
            } catch (NumberFormatException ex) {
                showAlert(AlertType.ERROR, "Invalid ticket number.");
            }
        }
    }

    @FXML
    private void showUsedTickets() {
        StringBuilder usedTickets = new StringBuilder();
        for (int ticketNumber : usedTicketNumbers) {
            usedTickets.append(ticketNumber).append("\n");
        }
        showAlert(AlertType.INFORMATION, "Used Ticket Numbers:\n" + usedTickets.toString());
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

    private void handleUI(String complaint, int ticketNumber) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Review Complaint");
        alert.setHeaderText("Issue: \n" + complaint + "\n\nTicket Number: " + ticketNumber);
        alert.setContentText("Submit This Issue?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ticketNumberLabel.setText("Ticket#: " + ticketNumber);
            usedTicketNumbers.add(ticketNumber);
            tickets.put(ticketNumber, complaint);
            complaintTextArea.setText("");
            showAlert(AlertType.INFORMATION, "Complaint Submitted With Ticket#: " + ticketNumber);
        }
    }

    private void showAlert(AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
}