module com.marwan.weather.monitoring.system {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.marwan.weather.monitoring.system to javafx.fxml;
    exports com.marwan.weather.monitoring.system;
}
