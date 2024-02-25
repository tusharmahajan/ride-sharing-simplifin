package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RideRequest {

    private String username;
    private String originCity;
    private String destinationCity;
    private int requestSeats;
    private String vehicleName;
}
