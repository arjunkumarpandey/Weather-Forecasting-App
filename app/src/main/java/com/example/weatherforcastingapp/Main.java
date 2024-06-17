package com.example.weatherforcastingapp;

import java.util.Objects;

public class Main {
    private double feels_like;
    private int humidity;
    private int pressure;
    private double temp;
    private double temp_max;
    private double temp_min;

    public Main(double feels_like, int humidity, int pressure, double temp, double temp_max, double temp_min) {
        this.feels_like = feels_like;
        this.humidity = humidity;
        this.pressure = pressure;
        this.temp = temp;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    @Override
    public String toString() {
        return "Main{" +
                "feels_like=" + feels_like +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", temp=" + temp +
                ", temp_max=" + temp_max +
                ", temp_min=" + temp_min +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Main main = (Main) o;
        return Double.compare(main.feels_like, feels_like) == 0 &&
                humidity == main.humidity &&
                pressure == main.pressure &&
                Double.compare(main.temp, temp) == 0 &&
                Double.compare(main.temp_max, temp_max) == 0 &&
                Double.compare(main.temp_min, temp_min) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feels_like, humidity, pressure, temp, temp_max, temp_min);
    }
}
