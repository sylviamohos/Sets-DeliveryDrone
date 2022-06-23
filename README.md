# Sets-DeliveryDrone
Implement a Set to prohibit duplicate drones, and to search for a drone in a fleet using a drone's key-value pairing.

OVERVIEW

Amazong Fresh is adding a new service that offers fresh fruit delivery.  A drone picks fruit fresh from the tree or vine and flies it straight from the orchard to the hungry customer who ordered it.
We are working on the system that manages the fleet of drones used for this service.  Every drone in the fleet is assigned a registration number by a local jurisdiction.  
We are going to try to address three different issues your team is facing.

GOALS

* There have been bugs related to duplicate drone information in the fleet.
* As the fleet has expanded to tens of thousands of drones, there have been performance issues adding and removing drones from the fleet system.
* Add a feature that checks whether the fleet contains any drone from a particular location.

SPECIFICATIONS

The DeliveryDrone class includes a registrationNumber attribute representing the registration id for this drone. It also includes a locationCode which is a code identifying the jurisdiction where this drone is registered. Every combo of locationCode and registrationNumber are globally unique – they identify a single drone.
The DroneFleet class contains any number of DeliveryDrone objects.  It is currently a basic wrapper around a collection of DeliveryDrone objects, supporting simple operations such as addDrone().


MILESTONES

* Performance and duplicate drones

To correct the performance issues of adding and removing drones from the fleet, as well as resolving the issue of duplicate drone information, we must first modify the DroneFleet and DeliveryDrone classes so that our drone fleet cannot contain drones with the same registrationNumber from the same locationCode.  
1. In DroneFleet, we need to change the return type of drones from a List to a Set of type DeliveryDrone:
      
      Set< DeliveryDrone > drones;
      
      We now know that our DroneFleet class is taking in a Set of DeliveryDrone type.  In the constructor we will instantiate the drones as a new HashSet<>():
          Drones = new HashSet<>();
          
2. Update class DeliveryDrone to implement equals and hashCode methods so that the DeliveryDrone object can be checked against another object of the same type.  This will rule out duplicates, as Sets do not allow for duplicate information, and will enable the add and remove methods to function properly since the hashCode() method checks to see if the registrationNumber / locationCode of one object matches that of another object. 
Implement DroneFleet’s containsDroneFromLocation() method
We know that if we need to check if a Set contains an element that matches a specific attribute, and not on all the attributes that make two objects equal we can, but we cannot use our constant time lookup of using the contains() method in this case.  Contains() will allow us to check if a particular element is present in a Set and will look at the element itself, not its attributes.
In this case, the containsDroneFromLocation() method takes in a String locationCode.  So containsDroneFromLocation() wants to know if there are any DeliveryDrones in our DroneFleet that have the same locationCode as another DeliveryDrone object in the fleet.  The way to implement this method is by creating a for-loop to iterate through the DeliveryDrone Set, and say that if one locationCode matches another to return true, else return false.
