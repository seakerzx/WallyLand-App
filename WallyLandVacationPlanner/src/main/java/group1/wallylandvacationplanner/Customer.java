package group1.wallylandvacationplanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer in the WallyLand Vacation Planner system.
 */
public class Customer {
    private int id;
    private String name;
    private String email;
    private List<UserActivity> scheduledActivities;

    /**
     * Constructor to create a Customer object.
     * 
     * @param id    the unique identifier of the customer
     * @param name  the name of the customer
     * @param email the email address of the customer
     */
    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.scheduledActivities = new ArrayList<>();
    }

    /**
     * Gets the unique identifier of the customer.
     * 
     * @return the customer ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the customer.
     * 
     * @return the customer name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the email address of the customer.
     * 
     * @return the customer email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the list of scheduled activities for the customer.
     * 
     * @return the list of scheduled activities
     */
    public List<UserActivity> getScheduledActivities() {
        return scheduledActivities;
    }

    /**
     * Adds an activity to the customer's scheduled activities.
     * 
     * @param activity the activity to be added
     */
    public void addActivity(UserActivity activity) {
        scheduledActivities.add(activity);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", scheduledActivities=" + scheduledActivities +
                '}';
    }
}

