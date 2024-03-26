import controller.InitController;
import controller.TicketController;
import model.ParkingLot;
import model.Ticket;
import model.Vehicle;
import model.enums.VehicleType;
import repository.*;
import service.InitialisationService;
import service.TicketService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();


        InitialisationService initialisationService = new InitialisationService(
                gateRepository,
                parkingLotRepository,
                parkingSpotRepository,
                parkingFloorRepository
        );
        TicketService ticketService = new TicketService(
                ticketRepository,
                parkingLotRepository,
                gateRepository,
                parkingSpotRepository
        );

        TicketController ticketController = new TicketController(ticketService);

        InitController initController = new InitController(initialisationService);
        System.out.println("***Parking Lot Data Initialisation- Start");
        ParkingLot parkingLot =initController.init();
        System.out.println("***Parking Lot Data Initialisation- End");
        System.out.println("Please enter an option -->1. Enter Parking Lot, 2.Exit Parking Lot, 3.Exit");
        int option =sc.nextInt();
        while(true){
            if(option==1){
                Vehicle vehicle = new Vehicle();
                System.out.println("Welcome to our parking lot");
                System.out.println("Please Enter the vehicle details");
                System.out.println("Please enter the vehicle number");
                String number = sc.next();
                vehicle.setVehicleNumber(number);
                System.out.println("Please enter the vehicle color");
                String color = sc.next();
                vehicle.setColor(color);
                System.out.println("Please choose the vehicle type-->1. Car ");
                int vehicleType = sc.nextInt();
                if(vehicleType==1){
                    vehicle.setVehicleType(VehicleType.FOUR_WHEELER);
                }
                System.out.println("Please Enter the ParkingLot ID");
                int parkingLotId = sc.nextInt();
                System.out.println("Please Enter the gate ID");
                int gateId = sc.nextInt();
                Ticket ticket = ticketController.generateTicket(vehicle,gateId,parkingLotId);
                System.out.println("Ticket details :" + ticket);

            }else if(option==2){
                System.out.println("Thanks, Please Visit Again");
                break;
            }else{
                System.out.println("Thanks");
                break;
            }
        }
    }

    }
