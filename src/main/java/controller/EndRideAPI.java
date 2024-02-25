package controller;

import service.RideService;

public class EndRideAPI {

    private final RideService rideService;

    public EndRideAPI(RideService rideService) {
        this.rideService = rideService;
    }

    public String endRide(String userName, String vehicleNumber){
        return rideService.endRide(userName, vehicleNumber);
    }
}
