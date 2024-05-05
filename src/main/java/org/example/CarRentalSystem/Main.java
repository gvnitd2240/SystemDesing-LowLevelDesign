package org.example.CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Throwable {
        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);

        User user = users.get(0);

        //search with locations - stores
        Location location = new Location(1, 283203, "firozabad", "up", "firozabad");

        Store filteredStores = rentalSystem.getStores(location).get(0);

        List<Vehicle> storeVehicles = filteredStores.getVehicles(VehicleType.CAR);

        Reservation reservation = filteredStores.createReservation(storeVehicles.get(0), user);

        Bill bill = new Bill();
        bill.setReservation(reservation);

        Payment payment = new Payment();
        payment.payBill(bill);


        filteredStores.completeReservation(reservation.id);

    }

    public static List<User> addUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(1, "vivekgarg", 10));
        users.add(new User(2, "keshav", 11));
        users.add(new User(3, "nayak", 12));
        users.add(new User(4, "nagi", 13));
        users.add(new User(5, "yash", 14));

        return users;
    }

    public static List<Vehicle> addVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleID(1);
        vehicle1.setVehicleType(VehicleType.CAR);

        Vehicle vehicle2 = new Vehicle();
        vehicle1.setVehicleID(2);
        vehicle1.setVehicleType(VehicleType.CAR);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;

    }

    public static List<Store> addStores(List<Vehicle> vehicles){

        List<Store> stores = new ArrayList<>();
        Store store1 = new Store();
        store1.id=1;
        store1.setVehicles(vehicles);

        stores.add(store1);
        return stores;
    }

}
