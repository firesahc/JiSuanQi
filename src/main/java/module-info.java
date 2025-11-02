module org.example.jisuanqi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens org to javafx.fxml;
    exports org;
}