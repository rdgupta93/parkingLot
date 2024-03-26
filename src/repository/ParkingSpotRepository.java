package repository;

import exception.ParkingSpotNotFoundException;
import model.ParkingSpot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotRepository {


    private Map<Integer, ParkingSpot> parkingSpotMap;

    public ParkingSpotRepository() {
        this.parkingSpotMap = new HashMap<>();
    }

    public ParkingSpot get(int parkingSpotId){
        ParkingSpot parkingSpot = parkingSpotMap.get(parkingSpotId);
        if(parkingSpot==null){
            throw new ParkingSpotNotFoundException("Parking Spot not found for id : "+ parkingSpotId);
        }
        return parkingSpot;
    }
    public void put(ParkingSpot parkingSpot){
        parkingSpotMap.put(parkingSpot.getId(), parkingSpot);
        System.out.println("Parking spot has been added successfully");
    }
}
