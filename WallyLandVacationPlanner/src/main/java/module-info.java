module group1.wallylandvacationplanner {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens group1.wallylandvacationplanner to javafx.fxml;
    exports group1.wallylandvacationplanner;
}
