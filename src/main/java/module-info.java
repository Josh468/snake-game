module com.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.Snake to javafx.fxml;
    exports com.Snake;
    exports com.Snake.model;
    opens com.Snake.model to javafx.fxml;
    exports com.Snake.scene;
    opens com.Snake.scene to javafx.fxml;
}