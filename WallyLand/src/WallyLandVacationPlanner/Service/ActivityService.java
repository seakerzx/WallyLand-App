/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WallyLandVacationPlanner.Service;

import WallyLandVacationPlanner.Repository.ActivityRepository;
import WallyLandVacationPlanner.Model.Activity;

import java.util.List;

/**
 * Provides services for managing activities.
 */
public class ActivityService {
    private ActivityRepository activityRepository;

    /**
     * Constructor to create an ActivityService object.
     * 
     * @param activityRepository the repository to access activity data
     */
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
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
     * @param activityId the ID of the activity to book
     * @return true if the booking is successful, false otherwise
     */
    public boolean bookActivity(int activityId) {
        return activityRepository.bookActivity(activityId);
    }
}
