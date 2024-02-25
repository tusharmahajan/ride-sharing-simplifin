package service;

import models.Vehicle;
import repository.VehicleRepository;

public class VehicleService {


    public String addVehicle(Vehicle vehicle) {
        if(vehicle == null){
            return "Vehicle details not entered";
        }
        // more validation can be written
        return VehicleRepository.addVehicle(vehicle);
    }
}
