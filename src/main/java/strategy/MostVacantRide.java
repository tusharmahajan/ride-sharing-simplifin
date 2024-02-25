package strategy;

import models.RideDetails;
import models.RideRequest;
import models.RideResponse;
import repository.RideRepository;

public class MostVacantRide implements RideSelectionStrategy {

    private final RideRequest rideRequest;

    public MostVacantRide(RideRequest rideRequest) {
        this.rideRequest = rideRequest;
    }

    @Override
    public RideResponse searchAndSelectRide() {
        RideDetails rideDetails = RideRepository.getAndUpdateMostVacantRide(
                rideRequest.getUsername(),
                rideRequest.getOriginCity(), rideRequest.getDestinationCity(),
                rideRequest.getRequestSeats());

        if(rideDetails == null){
            return null;
        }

        return RideResponse.builder()
                .vehicleName(rideDetails.getVehicleName())
                .vehicleNumber(rideDetails.getVehicleNumber())
                .offeredUser(rideDetails.getUserName()).build();
    }
}
