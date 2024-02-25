package controller;

import models.RideDetails;
import service.RideService;

public class OfferRideAPI {

    private final RideService rideService;

    public OfferRideAPI(RideService rideService) {
        this.rideService = rideService;
    }

    public String offerRide(RideDetails rideDetails){
        return rideService.offerRide(rideDetails);
    }
}
