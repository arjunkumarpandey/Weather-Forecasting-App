package com.example.weatherforcastingapp;

import java.util.Objects;

public class Weather {
    private String description;
    private String icon;
    private int id;
    private String main;

    public Weather(String description, String icon, int id, String main) {
        this.description = description;
        this.icon = icon;
        this.id = id;
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", id=" + id +
                ", main='" + main + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return id == weather.id &&
                Objects.equals(description, weather.description) &&
                Objects.equals(icon, weather.icon) &&
                Objects.equals(main, weather.main);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, icon, id, main);
    }
}
