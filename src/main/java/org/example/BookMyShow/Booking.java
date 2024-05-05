package org.example.BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    int id;
    Show show;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(List<Seat> seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    List<Seat> seatsBooked = new ArrayList<>();
    Payment payment;
}
