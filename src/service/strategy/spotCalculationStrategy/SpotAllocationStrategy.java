package service.strategy.spotCalculationStrategy;

import model.ParkingLot;
import model.ParkingSpot;
import model.Vehicle;

public interface SpotAllocationStrategy {

    ParkingSpot getSpotForVehicle(ParkingLot parkingLot, Vehicle vehicle);
}
