package service;

import models.RideDetails;
import models.RideStats;
import models.RideTakenOfferPair;
import repository.RideRepository;

import java.util.List;
import java.util.Map;

public class RideService {

    public String offerRide(RideDetails rideDetails) {
        if(rideDetails == null){
            return "No ride details entered";
        }
        int availableSeats = rideDetails.getAvailableSeats();
        if(availableSeats <= 0) return "Available seats cant be zero or negative";

        boolean canOfferRide = checkIfAlreadyRideOffered(rideDetails);
        if(!canOfferRide){
            return "Ride has already been offered by this user for this vehicle: " + rideDetails.getVehicleName();
        }
        return RideRepository.storeRideDetails(rideDetails);
    }

    private boolean checkIfAlreadyRideOffered(RideDetails rideDetails) {
        List<RideDetails> offeredRides = RideRepository.getRideDetailsForUser(rideDetails.getUserName());

        if(offeredRides == null) return true;

        for(RideDetails offerRide : offeredRides){
            String vehicleName = offerRide.getVehicleName();
            String vehicleNumber = offerRide.getVehicleNumber();
            if(vehicleName.equals(rideDetails.getVehicleName()) && vehicleNumber.equals(rideDetails.getVehicleNumber())){
                return false;
            }
        }
        return true;
    }

    public void printRideStats() {
        RideStats rideStats = RideRepository.getRideStats();
        Map<String, RideTakenOfferPair> rideTakenOfferPairMap = rideStats.getRideTakenOffer();
        for(Map.Entry<String, RideTakenOfferPair> rideTakenOfferPairEntry: rideTakenOfferPairMap.entrySet()){
            int taken = rideTakenOfferPairEntry.getValue().getTaken();
            int offered = rideTakenOfferPairEntry.getValue().getOffered();
            System.out.println(rideTakenOfferPairEntry.getKey() + ": " + taken + " Taken, " + offered + " Offered");
        }
    }

    public String endRide(String userName, String vehicleNumber) {
        return RideRepository.endRide(userName, vehicleNumber);
    }
}
