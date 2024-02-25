package controller;

import models.Vehicle;
import service.VehicleService;

public class AddVehicleAPI {

    private final VehicleService vehicleService;

    public AddVehicleAPI(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public String addVehicle(Vehicle vehicle){
        return vehicleService.addVehicle(vehicle);
    }
}
