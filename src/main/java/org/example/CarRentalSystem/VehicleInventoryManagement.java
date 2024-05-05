package org.example.CarRentalSystem;

import java.util.List;

public class VehicleInventoryManagement {
    List<Vehicle> vehicles;

    VehicleInventoryManagement(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return vehicles.stream().filter(it -> it.vehicleType == vehicleType).toList();
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
