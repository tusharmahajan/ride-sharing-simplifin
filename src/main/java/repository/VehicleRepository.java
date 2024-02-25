package repository;

import models.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleRepository {

    //  key is Username. Unique identifier
    private static final Map<String, List<Vehicle>> vehicleStore = new HashMap<>();

    public static String addVehicle(Vehicle vehicle) {
        vehicleStore.putIfAbsent(vehicle.getUserName(), new ArrayList<>());
        vehicleStore.get(vehicle.getUserName()).add(vehicle);
        return "Successfully added vehicle: " + vehicle.getVehicleName() + " for user: " + vehicle.getUserName();
    }

    public static List<Vehicle> getVehicleDetails(String userName){
        return vehicleStore.get(userName);
    }
}
