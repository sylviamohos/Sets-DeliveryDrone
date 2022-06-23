package com.amazon.ata.hashingset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A fleet of Delivery Drones.
 */
public class DroneFleet {

    Set<DeliveryDrone> drones;
    
    /**
     * Construct an object representing a fleet of Delivery Drones.  The fleet will start empty, but new
     * `DeliveryDrones` can be added.
     */
    public DroneFleet() {
        drones = new HashSet<>();
    }

    /**
     * Add a Delivery Drone to the fleet.
     *
     * @param drone a Delivery drone object.
     *
     * @return true if the drone was not already a member of the fleet, and false if it was already a member.
     */
    public boolean addDrone(DeliveryDrone drone) {
        return drones.add(drone);
    }

    /**
     * Remove a Delivery Drone from the fleet.
     *
     * @param drone a Delivery drone object.
     *
     * @return true if the drone was part of the fleet and was therefore removed, and false if it was not a member.
     */
    public boolean removeDrone(DeliveryDrone drone) {
        return drones.remove(drone);
    }

    /**
     * Return the number of drones in this fleet.
     *
     * @return the number of drones in this fleet.
     */
    public int getSize() {
        return drones.size();
    }

    /**
     * Check all drones and see if there are any from a particular locationCode.
     * 
     * @param locationCode the location code for a specific jurisdiction that grants drone licenses
     *
     * @return true if this fleet contains a drone from the supplied location.
     */ 
    public boolean containsDroneFromLocation(String locationCode) {
        for (DeliveryDrone deliveryDrone : drones) {
            if (deliveryDrone.getLocationCode().equals(locationCode)) {
                return true;
            }
        }

        return false;
    }
}
