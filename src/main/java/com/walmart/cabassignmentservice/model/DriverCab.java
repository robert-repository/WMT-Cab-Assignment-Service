package com.walmart.cabassignmentservice.model;

import javax.persistence.*;

@Entity
public class DriverCab {

    public DriverCab() {
    }

    @Id
    @GeneratedValue
    private Long id;
    private String driverId;
    private String cabId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Location_id")
    private GeoLocation geoLocation;

    public DriverCab(Long id, String driverId, String cabId, GeoLocation geoLocation) {
        this.id = id;
        this.driverId = driverId;
        this.cabId = cabId;
        this.geoLocation = geoLocation;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCabId() {
        return cabId;
    }

    public void setCabId(String cabId) {
        this.cabId = cabId;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

//    @Override
//    public String toString() {
//        return "{\"driverId\":\""+driverId+"\", \"cabId\":\""+cabId+"\", \"geoLocataion\":{ \"latitude\":\""+geoLocation.getLatitude()+"\", \"longitude\":\""+geoLocation.getLongitude()+"\"}}";
//    }

    @Override
    public String toString() {
        return "DriverCab{" +
                "id=" + id +
                ", driverId='" + driverId + '\'' +
                ", cabId='" + cabId + '\'' +
                ", geoLocation=" + geoLocation +
                '}';
    }
}
