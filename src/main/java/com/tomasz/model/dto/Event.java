package com.tomasz.model.dto;


import java.time.LocalDateTime;


public class Event {

    private String id;

    private String name;

    private String place;

    private LocalDateTime date;

    public Event() {
    }

    public Event(String name, String place, LocalDateTime date) {
        this.name = name;
        this.place = place;
        this.date = date;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
