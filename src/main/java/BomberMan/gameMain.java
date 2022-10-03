package BomberMan;

import BomberMan.Map.Map;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class gameMain extends Application {
    private GraphicsContext graphicsContextMap;

    private Canvas canvasMap;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        canvasMap = new Canvas(1280, 720);
        graphicsContextMap = canvasMap.getGraphicsContext2D();

        Group root = new Group();
        root.getChildren().add(canvasMap);

        Scene scene = new Scene(root, Color.BLACK);

        stage.setScene(scene);
        Image icon = new Image("file:src/main/resources/icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Perry");
        stage.setFullScreen(false);
        stage.setResizable(false); // khoá kích thước cửa sổ
        stage.show();

        Map map = new Map();

        map.LoadMap(1);
        map.DrawMap(graphicsContextMap);
    }
}
