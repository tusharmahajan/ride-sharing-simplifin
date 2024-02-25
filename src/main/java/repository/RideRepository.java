package repository;

import models.RideDetails;
import models.RideStats;

import java.util.*;

public class RideRepository {

    // username is the key. Unique identifier
    private static final Map<String, List<RideDetails>> userOfferedRides = new HashMap<>();
    private static final RideStats rideStats = new RideStats();
    private static final Set<RideDetails> bookedRides = new HashSet<>();

    public static String storeRideDetails(RideDetails rideDetails) {
        String username = rideDetails.getUserName();
        userOfferedRides.putIfAbsent(username, new ArrayList<>());
        userOfferedRides.get(username).add(rideDetails);
        return "Successfully added ride details for user: " + rideDetails.getUserName() + " for vehicle " + rideDetails.getVehicleName();
    }

    public static List<RideDetails> getRideDetailsForUser(String userName) {
        return userOfferedRides.get(userName);
    }

    public static RideDetails getPreferredRideDetails(String username, String originCity, String destinationCity,
                                                      int requiredSeats, String vehicleName){
        List<RideDetails> rideDetails = getRideDetails(username, originCity, destinationCity, requiredSeats, vehicleName);
        if(rideDetails.size() == 0) return null;

        RideDetails rideDetails1 = rideDetails.get(0);
        rideDetails1.setAvailableSeats(rideDetails1.getAvailableSeats()-1);

        storeBookedRideDetails(rideDetails1);
        updateRideOfferedAndTakenDetails(username, rideDetails1);
        return rideDetails1;
    }

    public static RideDetails getAndUpdateMostVacantRide(String username, String originCity, String destinationCity,
                                                         int requiredSeats){

        List<RideDetails> rideDetails = getRideDetails(username, originCity, destinationCity, requiredSeats, null);
        if(rideDetails.size() == 0) return null;

        rideDetails.sort(Comparator.comparingInt(RideDetails::getAvailableSeats).reversed());
        RideDetails rideDetails1 = rideDetails.get(0);
        rideDetails1.setAvailableSeats(rideDetails1.getAvailableSeats()-1);

        storeBookedRideDetails(rideDetails1);
        updateRideOfferedAndTakenDetails(username, rideDetails1);
        return rideDetails1;
    }


    private static List<RideDetails> getRideDetails(String username, String originCity, String destinationCity,
                                                    int requiredSeats, String vehicleName){

        List<RideDetails> rideDetailsArrayList = new ArrayList<>();
        for(Map.Entry<String, List<RideDetails>> rd: userOfferedRides.entrySet()){
            List<RideDetails> rideDetailsList = rd.getValue();
            for(RideDetails rideDetails :rideDetailsList){
                String user = rideDetails.getUserName();
                String oc = rideDetails.getOriginCity();
                String dc = rideDetails.getDestinationCity();
                int availableSeats = rideDetails.getAvailableSeats();
                String vn = rideDetails.getVehicleName();

                if(!user.equals(username) && oc.equals(originCity) && dc.equals(destinationCity)
                        && availableSeats >= requiredSeats
                        && (vehicleName == null || vehicleName.equals(vn))){
                    rideDetailsArrayList.add(rideDetails);
                }
            }
        }
        return rideDetailsArrayList;
    }

    public static void storeBookedRideDetails(RideDetails rideDetails) {
        bookedRides.add(rideDetails);
    }

    private static void updateRideOfferedAndTakenDetails(String rideTaker, RideDetails rideDetails) {
        rideStats.incrementRideTakenByUser(rideTaker);
        rideStats.incrementRideOfferByUser(rideDetails.getUserName());
    }


    public static String endRide(String userName, String vehicleNumber) {

        RideDetails rideDetails = null;

        for(RideDetails bookedRide : bookedRides){
            if(bookedRide.getUserName().equals(userName) && bookedRide.getVehicleNumber().equals(vehicleNumber)){
                rideDetails = bookedRide;
                break;
            }
        }
        if(rideDetails == null){
            return "Ride not found with: " + userName;
        }
        bookedRides.remove(rideDetails);
        rideDetails.setAvailableSeats(rideDetails.getAvailableSeats()+1);
        return "Ride successfully ended with: " + userName;
    }

    public static RideStats getRideStats() {
        return rideStats;
    }

    public static void initializeRideStatsForUser(String name) {
        rideStats.addUserRideDetails(name);
    }
}
