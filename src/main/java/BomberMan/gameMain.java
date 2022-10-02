package BomberMan;

import javafx.application.Application;
import javafx.stage.Stage;

import static BomberMan.constValue.constValue.*;

public class gameMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Bomber Man");
        stage.show();
    }
}
