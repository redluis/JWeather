package redluis.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import redluis.weatherapp.core.RXWeather;
import redluis.weatherapp.core.WeatherModel;

public class JWeatherController {
    @FXML
    private Label outTemperature;
    @FXML
    private Label outFeels;
    @FXML
    private Label outMaximal;
    @FXML
    private Label outMinimal;
    @FXML
    private Label outPressure;
    @FXML
    private Button getResult;
    @FXML
    private TextField inputCity;

    @FXML
    void initialize() {
        getResult.setOnAction( event -> {
            RXWeather rxWeather = new RXWeather();
            WeatherModel weatherModel = rxWeather.receiveWeather(
                    inputCity.getText()
            );

            outTemperature.setText(String.valueOf(weatherModel.getTemperature()) + "°C");
            outFeels.setText(String.valueOf(weatherModel.getFeelsLike()) + "°C");
            outMaximal.setText(String.valueOf(weatherModel.getMaximal()) + "°C");
            outMinimal.setText(String.valueOf(weatherModel.getMinimal()) + "°C");
            outPressure.setText(String.valueOf(weatherModel.getPressure()));
        });
    }
}