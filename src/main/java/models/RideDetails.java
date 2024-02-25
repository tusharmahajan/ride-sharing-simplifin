package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RideDetails {

    private String userName;
    private String originCity;
    private int availableSeats;
    private String vehicleName;
    private String vehicleNumber;
    private String destinationCity;

}
