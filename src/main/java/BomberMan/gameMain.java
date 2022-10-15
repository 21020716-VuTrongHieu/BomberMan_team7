package BomberMan;

import BomberMan.Item.Item;
import BomberMan.Item.ItemSpeed;
import BomberMan.Item.ItemSuperBom;
import BomberMan.Map.Map;
import BomberMan.constValue.State;
import BomberMan.constValue.constValue;
import BomberMan.entities.*;
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
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class gameMain extends Application {

    public static final int WIDTH = 29;
    public static final int HEIGHT = 13;


    private List<Entity> stillObjects = new ArrayList<>();



    private Canvas mainCanvas;
    private GraphicsContext mainGc;
    private Scene mainScene;
    private Group root;
    private Stage mainStage;
    private State[] mainState = new State[1];

    private boolean isQuit = false;

    private List<Brick> brickList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();



    @Override
    public void start(Stage stage) throws IOException {

        root = new Group();
        mainCanvas = new Canvas(constValue.ENTITY_SIZE * 29, constValue.ENTITY_SIZE * 13);
        mainGc = mainCanvas.getGraphicsContext2D();
        mainScene =new Scene(root);
        mainState[0] = State.STOP;
        //////////////////////////////////////////////////////////////////////////
        //      tao NV            //
        Map map = new Map();
        try {
            map.LoadMap(0);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        Bomber man = new Bomber();
        man.setPosition(constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);



        enemies.add(new Enemy1());
        enemies.get(0).setPosition(27*constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
        enemies.add(new Enemy1());
        enemies.get(1).setPosition(8 * constValue.ENTITY_SIZE, 5 * constValue.ENTITY_SIZE);
        enemies.add(new Enemy1());
        enemies.get(2).setPosition(5 * constValue.ENTITY_SIZE, 11 * constValue.ENTITY_SIZE);
        enemies.add(new Enemy1());
        enemies.get(3).setPosition(15 * constValue.ENTITY_SIZE, 11 * constValue.ENTITY_SIZE);
        enemies.add(new Enemy2());
        enemies.get(4).setPosition(23 * constValue.ENTITY_SIZE, 6 * constValue.ENTITY_SIZE);
        enemies.add(new Enemy2());
        enemies.get(5).setPosition(17 * constValue.ENTITY_SIZE, 6 * constValue.ENTITY_SIZE);
        Bom[] bom = new Bom[1];
        for (int i = 0; i < Brick.amountBrick; i++) {
            Brick brick = new Brick();
            brickList.add(brick);
        }

        Item itemSpeed = new ItemSpeed();
        Item itemSuperBom = new ItemSuperBom();
        itemList.add(itemSpeed);
        itemList.add(itemSuperBom);


        boolean[] keyCheck = new boolean[120]; // Check xem con phim nao dang an khong, neu khong con thi moi dung nhan vat.
        for (int i = 0; i < 120; i++) {
            keyCheck[i] = false;
        }
        mainScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent_down) {
                if (keyEvent_down.getCode() == KeyCode.DOWN) {
                    keyCheck[KeyCode.DOWN.getCode()] = true;
                    mainState[0] = State.DOWN;
                    man.setIsMoving(true);
                }
                if (keyEvent_down.getCode() == KeyCode.UP) {
                    keyCheck[KeyCode.UP.getCode()] = true;
                    mainState[0] = State.UP;
                    man.setIsMoving(true);
                }
                if (keyEvent_down.getCode() == KeyCode.LEFT) {
                    keyCheck[KeyCode.LEFT.getCode()] = true;
                    mainState[0] = State.LEFT;
                    man.setIsMoving(true);
                }
                if (keyEvent_down.getCode() == KeyCode.RIGHT) {
                    keyCheck[KeyCode.RIGHT.getCode()] = true;
                    mainState[0] = State.RIGHT;
                    man.setIsMoving(true);
                }
                if (keyEvent_down.getCode() == KeyCode.Q) {
                    isQuit = true;
                }
                if (keyEvent_down.getCode() == KeyCode.SPACE && (bom[0] == null || !bom[0].getIsPut())) {
                    bom[0] = new Bom(man.getPositionBom());
                    bom[0].setIsPut(true);//Bom.isPut = true;
                    bom[0].setIsExplode(false);//Bom.isExplode = false;
                }

            }
        });

        mainScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent_up) {
                if ( mainState[0] != State.DIE) {
                    if (keyEvent_up.getCode() != KeyCode.SPACE) {
                        {
                            if (keyEvent_up.getCode() == KeyCode.DOWN) {
                                keyCheck[KeyCode.DOWN.getCode()] = false;
                            }
                            if (keyEvent_up.getCode() == KeyCode.UP) {
                                keyCheck[KeyCode.UP.getCode()] = false;
                            }
                            if (keyEvent_up.getCode() == KeyCode.LEFT) {
                                keyCheck[KeyCode.LEFT.getCode()] = false;
                            }
                            if (keyEvent_up.getCode() == KeyCode.RIGHT) {
                                keyCheck[KeyCode.RIGHT.getCode()] = false;
                            }
                            boolean isMove = false;
                            for(int i=0;i<120;i++) {
                                if (keyCheck[i]) {
                                    isMove = true;
                                    break;
                                }
                            }
                            if (!isMove) {
                                man.setIsMoving(false);
                            }
                        }
                    }
                }
            }

        });


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                mainGc.setFill(Color.GREEN);
                //mainGc.fillRect(0,0, constValue.GAME_WIDTH,constValue.GAME_HEIGHT);
                mainGc.fillRect(0,0, constValue.ENTITY_SIZE * 29, constValue.ENTITY_SIZE * 13);

                man.update(mainState[0]);
                man.drawBomMan(mainGc);

                for (Enemy e : enemies) {
                    e.update();
                }

                for (Enemy e : enemies) {
                    e.drawEnemy(mainGc);
                }
//                enemy1.update();
////                if (!enemy1.isAlive) {
////                    enemy1.drawEnemy1Die(mainGc);
////                } else {
////                    enemy1.drawEnemy1(mainGc);
////                }
//                enemy1.drawEnemy(mainGc);

                //bricks.drawBrick(mainGc);
                if (bom[0] != null){
                    if (bom[0].getIsPut()) {
                        bom[0].drawBom(mainGc);
                        bom[0].checkWithBomMan(man.getPosition());
                        if (bom[0].getIsExplode()){
                            map.checkWithBom(bom[0].getPosition());
                            if (bom[0].checkWithBomMan(man.getPosition())) {
                                //System.out.println("DIE");
//                                mainState[0] = State.DIE;
                            }
                            for (Enemy e : enemies) {
                                if (bom[0].checkWithEnemy(e.getPosition())) {
                                    System.out.println("Enemy1 DIE");
                                    e.setState(State.DIE);
                                }

                            }
                        }
                    }
                }
                map.loadImage();
                map.DrawMap(mainGc, brickList,itemList,man.getPosition());
                //System.out.println("DI");
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


    }
    public static void main(String[] args) {
        launch();
    }
}