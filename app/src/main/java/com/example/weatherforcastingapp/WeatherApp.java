package com.example.weatherforcastingapp;

import java.util.List;

public class WeatherApp {

    private Main main;
    private Wind wind;
    private Sys sys;
    private List<Weather> weather;

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Sys getSys() {
        return sys;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public static class Main {
        private double temp;
        private int humidity;
        private int pressure;
        private double temp_max;
        private double temp_min;

        public double getTemp() {
            return temp;
        }

        public int getHumidity() {
            return humidity;
        }

        public int getPressure() {
            return pressure;
        }

        public double getTempMax() {
            return temp_max;
        }

        public double getTempMin() {
            return temp_min;
        }
    }

    public static class Wind {
        private double speed;

        public double getSpeed() {
            return speed;
        }
    }

    public static class Sys {
        private long sunrise;
        private long sunset;

        public long getSunrise() {
            return sunrise;
        }

        public long getSunset() {
            return sunset;
        }
    }

    public static class Weather {
        private String main;

        public String getMain() {
            return main;
        }
    }
}