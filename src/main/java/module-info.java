module com.example.airwar {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.airwar to javafx.fxml;
    exports com.example.airwar;
}