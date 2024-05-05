package org.example.CarRentalSystem;

public class Location {
    int id;
    int pincode;
    String address;
    String state;
    String city;

    public Location(int id, int pincode, String address, String state, String city) {
        this.id = id;
        this.pincode = pincode;
        this.address = address;
        this.state = state;
        this.city = city;
    }
}
