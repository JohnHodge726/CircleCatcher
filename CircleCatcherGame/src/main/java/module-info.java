module com.example.circlecatchergame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.circlecatchergame to javafx.fxml;
    exports com.example.circlecatchergame;
}