package com.vehiculerental.backwebservice.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {
    /**
     * id of the user
     */
    private String id;

    /**
     * first name of the user
     */
    @NotNull(message = "Ce champ ne peut être null.")
    @Size(min = 1, max = 60, message = "Le nombre de caractère du nom doit être compris entre 1 et 60.")
    private String firstName;

    /**
     * lastname of the user
     */
    @NotNull(message = "Ce champ ne peut être null.")
    @Size(min = 1, max = 60, message = "Le nombre de caractère du prénom doit être compris entre 1 et 60.")
    private String lastName;

    /**
     * birth date of the user
     */
    @NotNull(message = "Ce champ ne peut être null.")
    private Date birthDate;

    /**
     * license date of the user
     */
    @NotNull(message = "Ce champ ne peut être null.")
    private Date licenseDate;

    /**
     * license number of the user
     */
    @NotNull(message = "Ce champ ne peut être null.")
    private String licenseNumber;

    /**
     * email of the user
     */
    @NotNull(message = "Ce champ ne peut être null.")
    private String email;

    /**
     * password of the user
     */
    @NotNull(message = "Ce champ ne peut être null.")
    private String password;

    public User(String id, String firstName, String lastName, Date birthDate, Date licenseDate, String licenseNumber, String email,  String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.licenseDate = licenseDate;
        this.licenseNumber = licenseNumber;
        this.email = email;
        this.password = password;
    }

    public  User() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getLicenseDate() {
        return licenseDate;
    }

    public void setLicenseDate(Date licenseDate) {
        this.licenseDate = licenseDate;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
