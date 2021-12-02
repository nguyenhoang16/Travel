package com.example.traveldemo.ui.home.tabhome.list_tourist.adapter;

public class ContactTopFavorites {
    private String id;
    private String name;
    private String map;
    private String famousPlace;
    private String placeName;
    private String details;

    public ContactTopFavorites() {
    }

    public ContactTopFavorites(String id, String name, String map, String famousPlace, String placeName, String details) {
        this.id = id;
        this.name = name;
        this.map = map;
        this.famousPlace = famousPlace;
        this.placeName = placeName;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getFamousPlace() {
        return famousPlace;
    }

    public void setFamousPlace(String famousPlace) {
        this.famousPlace = famousPlace;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void getPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}