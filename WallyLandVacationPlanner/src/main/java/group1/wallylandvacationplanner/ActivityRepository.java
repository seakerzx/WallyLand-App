package group1.wallylandvacationplanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides data access for activities.
 */
public class ActivityRepository {
    private List<Activity> activities;

    /**
     * Constructor to create an ActivityRepository object and initialize the activity list.
     */
    public ActivityRepository() {
        activities = new ArrayList<>();
        activities.add(new Activity(1, "Roller Coaster", "A thrilling roller coaster ride.", "10:00 AM - 11:00 AM", true));
        activities.add(new Activity(2, "Magic Show", "A magical performance for all ages.", "11:00 AM - 12:00 PM", true));
        activities.add(new Activity(3, "Lunch Buffet", "A variety of delicious foods.", "12:00 PM - 1:00 PM", true));
    }

    /**
     * Finds all available activities.
     * 
     * @return a list of available activities
     */
    public List<Activity> findAllAvailable() {
        List<Activity> availableActivities = new ArrayList<>();
        for (Activity activity : activities) {
            if (activity.isAvailable()) {
                availableActivities.add(activity);
            }
        }
        return availableActivities;
    }

    /**
     * Books an activity for a user.
     * 
     * @param activityId the ID of the activity to book
     * @return true if the booking is successful, false otherwise
     */
    public boolean bookActivity(int activityId) {
        for (Activity activity : activities) {
            if (activity.getId() == activityId && activity.isAvailable()) {
                activity.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    /**
     * Finds an activity by its ID.
     * 
     * @param activityId the ID of the activity to find
     * @return the activity if found, null otherwise
     */
    public Activity findActivityById(int activityId) {
        for (Activity activity : activities) {
            if (activity.getId() == activityId) {
                return activity;
            }
        }
        return null;
    }
}
