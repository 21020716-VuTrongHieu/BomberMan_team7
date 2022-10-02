package BomberMan;

import BomberMan.Entity.Entity;
import BomberMan.Map.Map;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class gameMain extends Application {

    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();
    private GraphicsContext gc;

    private Canvas canvas;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        canvas = new Canvas(1280, 720);
        gc = canvas.getGraphicsContext2D();

        Group root = new Group();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, Color.BLACK);

        stage.setScene(scene);
        Image icon = new Image("file:src/main/resources/icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Perry");
        stage.setFullScreen(false);
        stage.setResizable(false); // khoá kích thước cửa sổ
        stage.show();

        Map a = new Map();

        a.LoadMap(1);
        a.DrawMap(gc);
    }
}
