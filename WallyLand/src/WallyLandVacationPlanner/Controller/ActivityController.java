/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WallyLandVacationPlanner.Controller;

import WallyLandVacationPlanner.Service.ActivityService;
import WallyLandVacationPlanner.Model.Activity;

import java.util.List;

/**
 * Handles user requests for planning activities.
 */
public class ActivityController {
    private ActivityService activityService;

    /**
     * Constructor to create an ActivityController object.
     * 
     * @param activityService the service to manage activities
     */
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
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
     * @param activityId the ID of the activity to book
     * @return true if the booking is successful, false otherwise
     */
    public boolean bookActivity(int activityId) {
        return activityService.bookActivity(activityId);
    }
}
