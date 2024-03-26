package repository;

import exception.ParkingLotNotFoundException;
import model.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    private Map<Integer, ParkingLot> parkingLotMap;

    private static int idCounter =0;

    public ParkingLotRepository() {
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLot get(int parkingLotId){
        ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
        if(parkingLot==null){
            throw new ParkingLotNotFoundException("Parking Lot not found for id : "+ parkingLotId);
        }
        return parkingLot;
    }
    public void put(ParkingLot parkingLot){
        parkingLot.setId(++idCounter);
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        System.out.println("Parking lot has been added successfully");
    }
}
