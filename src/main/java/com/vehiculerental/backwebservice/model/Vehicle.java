package com.vehiculerental.backwebservice.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
public class Vehicle {


    /**
     * id of the vehicle
     */
    private String id;

    /**
     * Brand of the vehicle
     */
    @NotNull(message = "Ce champ ne peut être null.")
    @Size(min = 1, max = 30, message = "Le nombre de caractère de la marque doit être compris entre 1 et 30.")
    private String brand;

    /**
     * Type of the vehicle
     */
    @NotNull(message = "Ce champ ne peut être null.")
    @Size(min = 1, max = 30, message = "Le nombre de caractère du type doit être compris entre 1 et 30.")
    private String type;

    /**
     * Color of the Vehicle
     */
    @NotNull(message = "Ce champ ne peut être null.")
    @Size(min = 1, max = 30, message = "Le nombre de caractère du type doit être compris entre 1 et 30.")
    private String color;

    /**
     * Base price for rent the Vehicle
     */
    @NotNull(message = "Ce champ ne peut être null.")
    private Float basePrice;

    /**
     * Price for each Km of the vehicle
     */
    @NotNull(message = "Ce champ ne peut être null.")
    private Float kmPrice;

    /**
     * Fiscal Power of the vehicle
     */
    @NotNull(message = "Ce champ ne peut être null.")
    private Integer horsePower;

    /**
     *
     */
    public Vehicle() {}

    /**
     * @param id
     * @param brand
     * @param type
     * @param color
     * @param basePrice
     * @param kmPrice
     * @param horsePower
     */
    public Vehicle(String id, String brand, String type, String color, Float basePrice, Float kmPrice, Integer horsePower) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.color = color;
        this.basePrice = basePrice;
        this.kmPrice = kmPrice;
        this.horsePower = horsePower;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Float basePrice) {
        this.basePrice = basePrice;
    }

    public Float getKmPrice() {
        return kmPrice;
    }

    public void setKmPrice(Float kmPrice) {
        this.kmPrice = kmPrice;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }


}
