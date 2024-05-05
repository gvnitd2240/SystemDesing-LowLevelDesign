package org.example.CarRentalSystem;

import java.math.BigDecimal;

public class Bill {
    int id;
    boolean isPaid = false;
    Reservation reservation;
    BigDecimal amount;

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    public Bill(){

    }

    public Bill(int id, boolean isPaid, Reservation reservation, BigDecimal amount) {
        this.id = id;
        this.isPaid = isPaid;
        this.reservation = reservation;
        this.amount = amount;
    }

}

