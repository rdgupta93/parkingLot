package model;

import model.enums.PaymentMode;
import model.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Payment extends BaseModel{

    private double amount;
    private String transactionRefNumber;
    private PaymentStatus paymentStatus;
    private Bill bill;
    private LocalDateTime time;
    private PaymentMode paymentMode;

    public Payment() {
    }

    public Payment(double amount, String transactionRefNumber, PaymentStatus paymentStatus, Bill bill, LocalDateTime time, PaymentMode paymentMode) {
        this.amount = amount;
        this.transactionRefNumber = transactionRefNumber;
        this.paymentStatus = paymentStatus;
        this.bill = bill;
        this.time = time;
        this.paymentMode = paymentMode;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionRefNumber() {
        return transactionRefNumber;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public Bill getBill() {
        return bill;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTransactionRefNumber(String transactionRefNumber) {
        this.transactionRefNumber = transactionRefNumber;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
