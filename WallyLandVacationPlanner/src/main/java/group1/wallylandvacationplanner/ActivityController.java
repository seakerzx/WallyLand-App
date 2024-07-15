package group1.wallylandvacationplanner;

import java.util.List;

/**
 * Handles user requests for planning activities.
 */
public class ActivityController {
    private static ActivityController instance;
    private ActivityService activityService;

    private ActivityController() {
        this.activityService = new ActivityService(new ActivityRepository());
    }

    public static ActivityController getInstance() {
        if (instance == null) {
            instance = new ActivityController();
        }
        return instance;
    }

    /**
     * Retrieves a list of available activities.
     * 
     * @return a list of available activities
     */
    public List<Activity> getAvailableActivities() {
        return activityService.getAvailableActivities();
    }

    /**
     * Books an activity for the user.
     * 
     * @param customerId the ID of the customer booking the activity
     * @param activityId the ID of the activity to book
     * @return true if the booking is successful, false otherwise
     */
    public boolean bookActivity(int customerId, int activityId) {
        return activityService.bookActivity(customerId, activityId);
    }

    /**
     * Retrieves a list of scheduled activities.
     * 
     * @return a list of scheduled activities
     */
    public List<UserActivity> getScheduledActivities() {
        return activityService.getScheduledActivities();
    }

    /**
     * Retrieves a list of customers.
     * 
     * @return a list of customers
     */
    public List<Customer> getCustomers() {
        return activityService.getCustomers();
    }

    /**
     * Adds a new customer.
     * 
     * @param customer the customer to be added
     */
    public void addCustomer(Customer customer) {
        activityService.addCustomer(customer);
    }
}
