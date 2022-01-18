module redluis.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens redluis.weatherapp to javafx.fxml;
    exports redluis.weatherapp;
}