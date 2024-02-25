package factory;

import models.RideRequest;
import models.RideSelection;
import strategy.MostVacantRide;
import strategy.RideSelectionStrategy;
import strategy.VehiclePreferenceRide;

public class RideSelectionFactory {

    private RideSelectionFactory(){}

    public static RideSelectionStrategy getRideSelection(RideRequest rideRequest, RideSelection rideSelection) {

        if(rideSelection.equals(RideSelection.MOST_VACANT)){
            return new MostVacantRide(rideRequest);
        }
        else if(rideSelection.equals(RideSelection.VEHICLE_PREFERENCE)){
            return new VehiclePreferenceRide(rideRequest);
        }
        return null;
    }

}
