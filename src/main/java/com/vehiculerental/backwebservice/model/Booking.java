package com.vehiculerental.backwebservice.model;

import java.util.Date;

public class Booking {

    private String id;

    private Integer basePrice;

    private Date confirmationDate;

    private Date endDate;

    private Integer estimatedKm;

    private Integer kmPrice;

    private Boolean orderIsConfirmed;

    private  Date startDate;

    private String userId;

    private String vehicleId;

    public Booking(String id, Integer basePrice, Date confirmationDate, Date endDate, Integer estimatedKm, Integer kmPrice, Boolean orderIsConfirmed, Date startDate, String userId, String vehicleId) {
        this.id = id;
        this.basePrice = basePrice;
        this.confirmationDate = confirmationDate;
        this.endDate = endDate;
        this.estimatedKm = estimatedKm;
        this.kmPrice = kmPrice;
        this.orderIsConfirmed = orderIsConfirmed;
        this.startDate = startDate;
        this.userId = userId;
        this.vehicleId = vehicleId;
    }

    public Booking() {}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public Date getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getEstimatedKm() {
        return estimatedKm;
    }

    public void setEstimatedKm(Integer estimatedKm) {
        this.estimatedKm = estimatedKm;
    }

    public Integer getKmPrice() {
        return kmPrice;
    }

    public void setKmPrice(Integer kmPrice) {
        this.kmPrice = kmPrice;
    }

    public Boolean getOrderIsConfirmed() {
        return orderIsConfirmed;
    }

    public void setOrderIsConfirmed(Boolean orderIsConfirmed) {
        this.orderIsConfirmed = orderIsConfirmed;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
}
