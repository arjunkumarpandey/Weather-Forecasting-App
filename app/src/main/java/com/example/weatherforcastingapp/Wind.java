package com.example.weatherforcastingapp;

import java.util.Objects;

public class Wind {
    private int deg;
    private double speed;

    public Wind(int deg, double speed) {
        this.deg = deg;
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "deg=" + deg +
                ", speed=" + speed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wind wind = (Wind) o;
        return deg == wind.deg &&
                Double.compare(wind.speed, speed) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deg, speed);
    }
}
