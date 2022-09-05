module com.example.universitymanagementlibrary {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.universitymanagementlibrary to javafx.fxml;
    exports com.example.universitymanagementlibrary;
}