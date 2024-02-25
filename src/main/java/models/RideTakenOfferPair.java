package models;

import lombok.Data;

@Data
public class RideTakenOfferPair {

    private int taken;
    private int offered;

    public RideTakenOfferPair() {
        this.taken = 0;
        this.offered = 0;
    }

    public void incrementTaken(){
        taken++;
    }

    public void incrementOffered(){
        offered++;
    }
}
