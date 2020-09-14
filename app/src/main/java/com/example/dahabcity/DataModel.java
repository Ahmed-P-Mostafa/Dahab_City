package com.example.dahabcity;

class DataModel {
    String title;
    String description;
    int imageResourceId;
    String loation;

    public DataModel(String title, String description, int imageResourceId, String location) {
        this.title = title;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.loation = location;
    }

    public DataModel(String title, String description, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getLoation() {
        return loation;
    }



    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public int getImageResourceId() {
        return imageResourceId;
    }

}
