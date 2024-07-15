package group1.wallylandvacationplanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides services for managing activities.
 */
public class ActivityService {
    private ActivityRepository activityRepository;
    private List<UserActivity> scheduledActivities;
    private List<Customer> customers;

    /**
     * Constructor to create an ActivityService object.
     * 
     * @param activityRepository the repository to access activity data
     */
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
        this.scheduledActivities = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    /**
     * Retrieves a list of available activities.
     * 
     * @return a list of available activities
     */
    public List<Activity> getAvailableActivities() {
        return activityRepository.findAllAvailable();
    }

    /**
     * Books an activity for a user.
     * 
     * @param customerId the ID of the customer booking the activity
     * @param activityId the ID of the activity to book
     * @return true if the booking is successful, false otherwise
     */
    public boolean bookActivity(int customerId, int activityId) {
        boolean isBooked = activityRepository.bookActivity(activityId);
        if (isBooked) {
            Activity bookedActivity = activityRepository.findActivityById(activityId);
            if (bookedActivity != null) {
                UserActivity userActivity = new UserActivity(bookedActivity);
                getCustomerById(customerId).addActivity(userActivity);
                scheduledActivities.add(userActivity);
            }
        }
        return isBooked;
    }

    /**
     * Retrieves a list of scheduled activities.
     * 
     * @return a list of scheduled activities
     */
    public List<UserActivity> getScheduledActivities() {
        return scheduledActivities;
    }

    /**
     * Retrieves a list of customers.
     * 
     * @return a list of customers
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * Adds a new customer.
     * 
     * @param customer the customer to be added
     */
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * Finds a customer by their ID.
     * 
     * @param customerId the ID of the customer to find
     * @return the customer if found, null otherwise
     */
    public Customer getCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }
}
