/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WallyLandVacationPlanner.Model;

/**
 * Represents an activity in the WallyLand theme park.
 */
public class Activity {
    private int id;
    private String name;
    private String description;
    private String timeSlot;
    private boolean available;

    /**
     * Constructor to create an Activity object.
     * 
     * @param id          the unique identifier of the activity
     * @param name        the name of the activity
     * @param description a brief description of the activity
     * @param timeSlot    the time slot during which the activity takes place
     * @param available   the availability status of the activity
     */
    public Activity(int id, String name, String description, String timeSlot, boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timeSlot = timeSlot;
        this.available = available;
    }

    /**
     * Gets the unique identifier of the activity.
     * 
     * @return the activity ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the activity.
     * 
     * @return the activity name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the activity.
     * 
     * @return the activity description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the time slot of the activity.
     * 
     * @return the activity time slot
     */
    public String getTimeSlot() {
        return timeSlot;
    }

    /**
     * Checks if the activity is available.
     * 
     * @return true if the activity is available, false otherwise
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the availability status of the activity.
     * 
     * @param available the new availability status
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
