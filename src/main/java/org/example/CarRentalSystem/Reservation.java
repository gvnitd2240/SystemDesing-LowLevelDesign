package org.example.CarRentalSystem;

import java.sql.Date;

public class Reservation {
    int id;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Location bookedFrom;
    Date bookedTill;
    ReservationStatus status;

    public int createReserve(User user, Vehicle vehicle){
        this.id = 12232;
        this.user=user;
        this.vehicle=vehicle;
        this.status = ReservationStatus.SCHEDULED;
        return this.id;
    }

    public void setStatus(ReservationStatus status){
        this.status = status;
    }

}

