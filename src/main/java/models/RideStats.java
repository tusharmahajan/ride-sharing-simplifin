package models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class RideStats {

    private Map<String, RideTakenOfferPair> rideTakenOffer;

    public RideStats() {
        this.rideTakenOffer = new HashMap<>();
    }

    public void addUserRideDetails(String username){
        rideTakenOffer.put(username, new RideTakenOfferPair());
    }

    public void incrementRideOfferByUser(String username){
        rideTakenOffer.get(username).incrementOffered();
    }

    public void incrementRideTakenByUser(String username){
        rideTakenOffer.get(username).incrementTaken();
    }
}
