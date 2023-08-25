module com.example.tunglv27javafis {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tunglv27javafis to javafx.fxml;
    exports com.example.tunglv27javafis;
}