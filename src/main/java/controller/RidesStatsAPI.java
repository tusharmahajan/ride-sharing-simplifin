package controller;

import service.RideService;

public class RidesStatsAPI {

    private final RideService rideService;

    public RidesStatsAPI(RideService rideService) {
        this.rideService = rideService;
    }

    public void printRideStats(){
        rideService.printRideStats();
    }
}
