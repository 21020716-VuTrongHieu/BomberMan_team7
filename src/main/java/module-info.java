module com.example.bomberman_team7 {
    requires javafx.controls;
    requires javafx.fxml;
            
                                requires com.almasb.fxgl.all;
    
    opens com.example.bomberman_team7 to javafx.fxml;
    exports com.example.bomberman_team7;
}