package com.example.weatherforcastingapp;

import java.util.Objects;

public class Sys {
    private String country;
    private int id;
    private int sunrise;
    private int sunset;
    private int type;

    public Sys(String country, int id, int sunrise, int sunset, int type) {
        this.country = country;
        this.id = id;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Sys{" +
                "country='" + country + '\'' +
                ", id=" + id +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sys sys = (Sys) o;
        return id == sys.id &&
                sunrise == sys.sunrise &&
                sunset == sys.sunset &&
                type == sys.type &&
                Objects.equals(country, sys.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, id, sunrise, sunset, type);
    }
}
