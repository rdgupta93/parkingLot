package service;

import model.Bill;
import service.strategy.billCalculationStrategy.BillCalculationStrategy;
import service.strategy.billCalculationStrategy.BillCalculationStrategyFactory;

public class BillService {

    public Bill generateBill(int ticketId, int exitGateid){
        BillCalculationStrategy billCalculationStrategy = BillCalculationStrategyFactory.getBill();
        Bill bill = new Bill();
        return bill;
    }
}
