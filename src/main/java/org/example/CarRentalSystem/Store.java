package org.example.CarRentalSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Store {
    int id;
    VehicleInventoryManagement inventoryManagement;
    Location location;
    List<Reservation> reservations = new ArrayList<>();

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return inventoryManagement.getVehicles(vehicleType);
    }


    public void setVehicles(List<Vehicle> vehicles) {
        inventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle, User user){
        Reservation reservation = new Reservation();
        reservation.createReserve(user,vehicle);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationID) {
        Reservation res = reservations.stream()
                .filter(it -> it.id == reservationID)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No reservation found with ID: " + reservationID));
        res.setStatus(ReservationStatus.COMPLETED);
        return true;
    }
}
