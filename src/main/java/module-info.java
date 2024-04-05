module com.example.graphicproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.graphicproject to javafx.fxml;
    exports com.example.graphicproject;
}