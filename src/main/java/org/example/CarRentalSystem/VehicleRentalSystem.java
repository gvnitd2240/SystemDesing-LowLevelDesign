package org.example.CarRentalSystem;

import java.util.List;

public class VehicleRentalSystem {
    List<User> userList;
    List<Store> storeList;


    VehicleRentalSystem(List<Store> stores, List<User> users) {
        this.storeList = stores;
        this.userList = users;
    }

    public List<Store> getStores(Location location) throws Throwable{
        List<Store> stores = this.storeList.stream().filter(it -> it.location.pincode == location.pincode).toList();
        if (stores.size() ==0) throw new Exception("Not Store exist in this location");
        return stores;
    }

}
