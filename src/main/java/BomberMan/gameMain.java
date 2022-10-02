package BomberMan;

import Entity.Entity;
import Map.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import static BomberMan.constValue.constValue.*;

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

        canvas = new Canvas(1080, 720);
        gc = canvas.getGraphicsContext2D();

        Group root = new Group();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, Color.LIGHTSKYBLUE);

        stage.setScene(scene);
        stage.setTitle("Perry");
        stage.show();

        Map a = new Map();

        a.LoadMap(1);
        a.DrawMap(gc);
    }
}
