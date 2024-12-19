module com.marwan.weather.monitoring.system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.json;
    
    opens com.marwan.weather.monitoring.system to javafx.fxml;
    exports com.marwan.weather.monitoring.system;
    
}
