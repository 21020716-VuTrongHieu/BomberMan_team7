package BomberMan;

import BomberMan.Map.Map;
import BomberMan.constValue.State;
import BomberMan.constValue.constValue;
import BomberMan.entities.Bomber;
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
import BomberMan.graphics.Sprite;
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

    private boolean isQuit = false;



    @Override
    public void start(Stage stage) throws IOException {

        root = new Group();
        mainCanvas = new Canvas(constValue.ENTITY_SIZE * 29, constValue.ENTITY_SIZE * 13);
        mainGc = mainCanvas.getGraphicsContext2D();
        mainScene =new Scene(root);
        mainState[0] = State.STOP;
        ///////////////////////////////////////////////////////////////////////////////
        //      tao NV            //
        Map map = new Map();


        Bomber man = new Bomber(Sprite.player_down.getFxImage());
        man.setPosition(constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);



        mainScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent_down) {

                if (keyEvent_down.getCode() == KeyCode.DOWN) {
                    mainState[0] = State.DOWN;
                    man.setIsMoving(true);
                } else if (keyEvent_down.getCode() == KeyCode.UP) {
                    man.setIsMoving(true);
                    mainState[0] = State.UP;
                } else if (keyEvent_down.getCode() == KeyCode.LEFT) {
                    man.setIsMoving(true);
                    mainState[0] = State.LEFT;
                } else if (keyEvent_down.getCode() == KeyCode.RIGHT) {
                    man.setIsMoving(true);
                    mainState[0] = State.RIGHT;
                } else if (keyEvent_down.getCode() == KeyCode.Q) {
                    isQuit = true;

                } else {
                    man.setIsMoving(false);

                }


            }

        });

        mainScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent_up) {
                if ( keyEvent_up.getCode() != null  ) {
                    man.setIsMoving(false);
                    //mainState[0] = State.STOP;
                }
            }

        });


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                mainGc.setFill(Color.GREEN);
                //mainGc.fillRect(0,0, constValue.GAME_WIDTH,constValue.GAME_HEIGHT);
                mainGc.fillRect(0,0, 1392,624);

                try {
                    map.LoadMap(0);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                map.DrawMap(mainGc);
                man.drawBomMan(mainGc);
                man.update(mainState[0]);
                if (isQuit) {
                    mainStage.close();
                }
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