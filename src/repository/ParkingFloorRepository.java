package repository;

import exception.ParkingFloorNotFoundException;
import model.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {

    private Map<Integer, ParkingFloor> parkingFloorMap;

    public ParkingFloorRepository() {
        this.parkingFloorMap = new HashMap<>();
    }

    public ParkingFloor get(int parkingFloorid){
        ParkingFloor parkingFloor = parkingFloorMap.get(parkingFloorid);
        if(parkingFloor==null){
            throw new ParkingFloorNotFoundException("Parking Floor not found for id : "+ parkingFloorid);
        }
        return parkingFloor;
    }
    public void put(ParkingFloor parkingFloor){
        parkingFloorMap.put(parkingFloor.getId(), parkingFloor);
        System.out.println(" has been added successfully");
    }
}
