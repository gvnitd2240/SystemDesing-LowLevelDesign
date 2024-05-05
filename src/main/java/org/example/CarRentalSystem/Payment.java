package org.example.CarRentalSystem;

public class Payment {
    int id;
    PaymentStatus status;
    Bill bill;

    public void payBill(Bill bill){
        this.status = PaymentStatus.PAID;
        bill.setPaid(true);
    }
}

