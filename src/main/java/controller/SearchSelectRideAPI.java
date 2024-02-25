package controller;

import factory.RideSelectionFactory;
import models.RideRequest;
import models.RideResponse;
import models.RideSelection;
import strategy.RideSelectionStrategy;

public class SearchSelectRideAPI {

    public String searchAndSelectRide(RideRequest rideRequest, RideSelection rideSelection){
        RideSelectionStrategy rideSelectionStrategy = RideSelectionFactory.getRideSelection(rideRequest, rideSelection);

        if(rideSelectionStrategy == null){
            return "Invalid ride strategy entered";
        }

        RideResponse rideResponse = rideSelectionStrategy.searchAndSelectRide();
        if(rideResponse == null){
            return "No ride available";
        }

        return "Successfully booked ride with: " + rideResponse.getOfferedUser()
                + " in vehicle " + rideResponse.getVehicleName()
                + " with vehicle number: " + rideResponse.getVehicleNumber();
    }
}
