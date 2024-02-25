package strategy;

import models.RideResponse;

public interface RideSelectionStrategy {

    RideResponse searchAndSelectRide();
}
