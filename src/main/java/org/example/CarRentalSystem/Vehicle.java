package org.example.CarRentalSystem;

import java.sql.Date;

public class Vehicle {
    int vehicleID;
    int vehicleNumber;
    VehicleType vehicleType;
    String companyName;
    String modelName;
    int kmDriven;
    Date manufacturingDate;
    int average;
    int cc;
    int dailyRentalCost;

    public int getVehicleID() {
        return vehicleID;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getModelName() {
        return modelName;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public int getAverage() {
        return average;
    }

    public int getCc() {
        return cc;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public void setDailyRentalCost(int dailyRentalCost) {
        this.dailyRentalCost = dailyRentalCost;
    }

    public void setHourlyRentalCost(int hourlyRentalCost) {
        this.hourlyRentalCost = hourlyRentalCost;
    }

    public void setNoOfSeat(int noOfSeat) {
        this.noOfSeat = noOfSeat;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getDailyRentalCost() {
        return dailyRentalCost;
    }

    public int getHourlyRentalCost() {
        return hourlyRentalCost;
    }

    public int getNoOfSeat() {
        return noOfSeat;
    }

    public Status getStatus() {
        return status;
    }

    int hourlyRentalCost;
    int noOfSeat;
    Status status;
}


