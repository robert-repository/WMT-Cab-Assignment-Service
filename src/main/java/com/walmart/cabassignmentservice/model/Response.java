package com.walmart.cabassignmentservice.model;

public class Response {

    private String cabId;

    public Response(String value) {
        this.cabId = value;
    }

    public String getCabId() {
        return cabId;
    }

    public void setCabId(String key) {
        this.cabId = key;
    }


}
