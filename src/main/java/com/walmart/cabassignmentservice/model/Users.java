package com.walmart.cabassignmentservice.model;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    private Long customerId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Location_id")
    private GeoLocation geoLocation;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }
}
