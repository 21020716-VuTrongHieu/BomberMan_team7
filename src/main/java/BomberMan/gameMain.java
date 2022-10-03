package BomberMan;

import BomberMan.Map.Map;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import BomberMan.entities.Entity;
import BomberMan.entities.Wall;
import BomberMan.graphics.Sprite;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class gameMain extends Application {

    public static final int WIDTH = 29;
    public static final int HEIGHT = 13;

    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();

    private GraphicsContext graphicsContextMap;
    private Canvas canvasMap;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        canvasMap = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        graphicsContextMap = canvasMap.getGraphicsContext2D();

        Group root = new Group();
        root.getChildren().add(canvasMap);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        Image icon = new Image("file:src/main/resources/icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Perry");
        stage.setFullScreen(false);
        stage.setResizable(false); // khoá kích thước cửa sổ
        stage.show();

        Map map = new Map();

        map.LoadMap(1);
        map.render(graphicsContextMap, canvasMap);

    }
}