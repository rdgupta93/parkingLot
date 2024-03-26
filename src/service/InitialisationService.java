package service;

import model.Gate;
import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingSpot;
import model.enums.*;
import repository.GateRepository;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;

public class InitialisationService {

    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingFloorRepository parkingFloorRepository;

    public InitialisationService(GateRepository gateRepository, ParkingLotRepository parkingLotRepository, ParkingSpotRepository parkingSpotRepository, ParkingFloorRepository parkingFloorRepository) {
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
    }

    public ParkingLot init(){
        System.out.println("*****Starting Inilialisation***");

        // Creating a parking Lot object
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("Shree Ram Parking Centre");
        parkingLot.setAddress("Inside the Orion Mall Mumbai ");
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setCapacity(100);
        parkingLot.setVehicleTypesSupported(List.of(VehicleType.TWO_WHEELER, VehicleType.FOUR_WHEELER));
        List<ParkingFloor> floors = new ArrayList<>();
        // running a loop to create 10 parking floor object
        for(int i=1;i<=10;i++){
            // Creating a parking floor object
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(i);
            parkingFloor.setFloorNumber(i);
            parkingFloor.setParkingFloorStatus(ParkingFloorStatus.AVAILABLE);
            List<ParkingSpot> spots = new ArrayList<>();
            // for each floor creating 10 parking spot objects
            for(int j=1;j<=10;j++){
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setId(j);
                parkingSpot.setNumber((i*100)+j);
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
                parkingSpot.setVehicleType(VehicleType.FOUR_WHEELER);
                spots.add(parkingSpot);
                parkingSpotRepository.put(parkingSpot);
            }
            parkingFloor.setParkingSpots(spots);
            // creating entry gate object
            Gate entrygate = new Gate();
            entrygate.setId((i*1000)+1);
            entrygate.setGateNumber(i*100 +1);
            entrygate.setGateStatus(GateStatus.OPEN);
            entrygate.setOperatorName("Operator: " +i + 1);
            parkingFloor.setEntryGate(entrygate);
            gateRepository.put(entrygate);

            // Creating exits gate object
            Gate exitgate= new Gate();
            exitgate.setId((i*1000)+2);
            exitgate.setGateNumber(i*100 +2);
            exitgate.setGateStatus(GateStatus.OPEN);
            exitgate.setGateType(GateType.EXIT);
            exitgate.setOperatorName("Operator:" +i +2);
            parkingFloor.setExitGate(exitgate);
            gateRepository.put(exitgate);

            floors.add(parkingFloor); // adding the floor to floor List
            parkingFloorRepository.put(parkingFloor);//saving floor to repository
        }
        parkingLot.setFloors(floors); //adding floor list to parking lot
        parkingLotRepository.put(parkingLot);
        return parkingLotRepository.get(1);
    }
}
