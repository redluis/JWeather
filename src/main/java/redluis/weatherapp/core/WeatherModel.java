package redluis.weatherapp.core;

import org.json.JSONObject;

public class WeatherModel {
    private double temperature;
    private double feelsLike;
    private double minimal;
    private double maximal;
    private double pressure;

    public WeatherModel() {}

    public WeatherModel(JSONObject json) {
        this.temperature = json.getDouble("temp");
        this.feelsLike = json.getDouble("feels_like");
        this.minimal = json.getDouble("temp_min");
        this.maximal = json.getDouble("temp_max");
        this.pressure = json.getDouble("pressure");
    }

    public double getTemperature() {
        return temperature;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public double getMinimal() {
        return minimal;
    }

    public double getMaximal() {
        return maximal;
    }

    public double getPressure() {
        return pressure;
    }
}
