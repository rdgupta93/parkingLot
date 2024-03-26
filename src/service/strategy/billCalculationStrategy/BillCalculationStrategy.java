package service.strategy.billCalculationStrategy;

import model.Bill;
import model.Ticket;

public interface BillCalculationStrategy {

    Bill generateBill(Ticket ticket);
}
