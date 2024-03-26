package service.strategy.spotCalculationStrategy;

import exception.ParkingSpotNotFoundForVehicleException;
import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingSpot;
import model.Vehicle;
import model.enums.ParkingSpotStatus;

import java.util.List;

public class LinearSpotCalculationStrategy implements SpotAllocationStrategy{

    @Override
    public ParkingSpot getSpotForVehicle(ParkingLot parkingLot, Vehicle vehicle) {
        List<ParkingFloor> parkingFloors= parkingLot.getFloors();
        for(ParkingFloor parkingFloor:parkingFloors){
            for(ParkingSpot parkingSpot:parkingFloor.getParkingSpots()){
                if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)&&
                        parkingSpot.getVehicleType().equals(vehicle.getVehicleType())
                ){
                    return parkingSpot;
                }
            }
        }
        throw new ParkingSpotNotFoundForVehicleException("Go to Home and rest !");

    }
}
