module com.example.binangbang_javafx1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.binangbang_javafx1 to javafx.fxml;
    exports com.example.binangbang_javafx1;
}