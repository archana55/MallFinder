package org.launchcode.mallfinder.models;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private int zip;
    private double latitude;
    private double longitude;

    public Address() {
    }

    public Address(String streetAddress, String city, String state, int zip, double latitude, double longitude) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String street_address) {
        this.streetAddress = street_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLogitude(double longitude) {
        this.longitude = longitude;
    }
}
