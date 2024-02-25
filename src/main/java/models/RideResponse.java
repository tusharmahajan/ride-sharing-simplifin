package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RideResponse {

    private String offeredUser;
    private String vehicleName;
    private String vehicleNumber;

}
