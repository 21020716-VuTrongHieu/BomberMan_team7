package BomberMan;

import BomberMan.Map.Map;
import BomberMan.constValue.State;
import BomberMan.constValue.constValue;
import BomberMan.entities.Bomber;
import com.almasb.fxgl.app.GameApplication;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import BomberMan.entities.Entity;
import BomberMan.entities.Wall;
import BomberMan.graphics.Sprite;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class gameMain extends Application {

    public static final int WIDTH = 29;
    public static final int HEIGHT = 13;

    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();

    private Canvas mainCanvas;
    private GraphicsContext mainGc;
    private Scene mainScene;
    private Group root;
    private Stage mainStage;
    private State[] mainState = new State[1];



    @Override
    public void start(Stage stage) throws IOException {

        root = new Group();
        mainCanvas = new Canvas(constValue.GAME_WIDTH,constValue.GAME_HEIGHT);
        mainGc = mainCanvas.getGraphicsContext2D();
        mainScene =new Scene(root);
        mainState[0] = State.STOP;
        ///////////////////////////////////////////////////////////////////////////////
        //      tao NV            //
        Map map = new Map();


        Bomber man = new Bomber(Sprite.player_down.getFxImage());
        man.setPosition(30,50);



        mainScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.DOWN) {
                    mainState[0] = State.DOWN;
                } else if (keyEvent.getCode() == KeyCode.UP) {
                    mainState[0] = State.UP;
                } else if (keyEvent.getCode() == KeyCode.LEFT) {
                    mainState[0] = State.LEFT;
                } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                    mainState[0] = State.RIGHT;
                } else {
                    mainState[0] = State.STOP;
                }
            }

        });

        mainScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if ( keyEvent.getCode() != null ) {
                    mainState[0] = State.STOP;
                }
            }

        });



        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {


                mainGc.setFill(Color.GREEN);
                mainGc.fillRect(0,0, constValue.GAME_WIDTH,constValue.GAME_HEIGHT);
                try {
                    map.LoadMap(0);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                map.DrawMap(mainGc);


                man.drawBomMan(mainGc);
                man.upDate(mainState[0]);


            }

        }; timer.start();


        root.getChildren().addAll(mainGc.getCanvas());

        mainScene.setFill(Color.GREEN);
        mainStage =new Stage();
        mainStage.setScene(mainScene);
        mainStage.setTitle(constValue.GAME_TITLE);
        mainStage.show();




        /*root.getChildren().add(canvasMap);

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
        map.render(graphicsContextMap, canvasMap);*/

    }
    public static void main(String[] args) {
        launch();
    }
}