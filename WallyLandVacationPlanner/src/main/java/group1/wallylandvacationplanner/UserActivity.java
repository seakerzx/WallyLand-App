package group1.wallylandvacationplanner;

/**
 * Represents a user's scheduled activity.
 */
public class UserActivity {
    private Activity activity;
    
    /**
     * Constructor to create a UserActivity object.
     * 
     * @param activity the activity that the user has scheduled
     */
    public UserActivity(Activity activity) {
        this.activity = activity;
    }

    /**
     * Gets the activity.
     * 
     * @return the activity
     */
    public Activity getActivity() {
        return activity;
    }

    @Override
    public String toString() {
        return activity.toString();
    }
}

