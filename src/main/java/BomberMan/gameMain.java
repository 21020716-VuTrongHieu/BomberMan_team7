package BomberMan;

import BomberMan.Item.*;
import BomberMan.Map.Map;
import BomberMan.constValue.State;
import BomberMan.constValue.constValue;
import BomberMan.entities.*;
import BomberMan.gameSound.soundPlayer;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
    public static List<Enemy> enemies = new ArrayList<>();
    private List<Bom> bomList = new ArrayList<>();
    int level = 1;

    public Text textInGame = new Text();
    public Text textStage = new Text();


    @Override
    public void start(Stage stage) throws IOException {

        root = new Group();
        mainCanvas = new Canvas(constValue.ENTITY_SIZE * 29, constValue.ENTITY_SIZE * 14);
        mainGc = mainCanvas.getGraphicsContext2D();
        mainScene =new Scene(root);
        mainState[0] = State.STOP;
        ////////////////////////////////////////////////////////////////////////
        // Text //

        textInGame.setFont(Font.font("", FontWeight.BOLD, FontPosture.REGULAR,48));
        textInGame.setX(0);
        textInGame.setY(48);

        textStage.setFont(Font.font("", FontWeight.BOLD, FontPosture.REGULAR, 100));
        textStage.setX(constValue.ENTITY_SIZE * 29 / 3 + 80);
        textStage.setY(constValue.ENTITY_SIZE * 14 / 2);
        textStage.setFill(Color.GHOSTWHITE);


        //////////////////////////////////////////////////////////////////////////
        //          SOUND Vi du thoiii         //

        soundPlayer.playMusic(soundPlayer.stage_theme, MediaPlayer.INDEFINITE);

        //////////////////////////////////////////////////////////////////////////
        //      tao NV            //

        //////////////////////////////////////////////////////////////////////////
        //      tao NV            //
        Map map = new Map();
//        try {
//            map.LoadMap(1);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }


//
        Bomber man = new Bomber();
        man.setPosition(constValue.ENTITY_SIZE, 2*constValue.ENTITY_SIZE);


//        for (int i = 0; i < 14; i++) {
//            for (int j = 0; j < 29; j++) {
//                if (Map.mapTitle[i][j] == constValue.ENEMY_1) {
//                    Enemy newEnemy = new Enemy1();
//                    newEnemy.setPosition((j) * constValue.ENTITY_SIZE, (i) * constValue.ENTITY_SIZE);
//                    enemies.add(newEnemy);
//                    Map.mapTitle[i][j] = constValue.GRASS;
//                    constValue.ENEMIES++;
//                } else if (Map.mapTitle[i][j] == constValue.ENEMY_2) {
//                    Enemy newEnemy = new Enemy2();
//                    newEnemy.setPosition((j) * constValue.ENTITY_SIZE, (i) * constValue.ENTITY_SIZE);
//                    enemies.add(newEnemy);
//                    Map.mapTitle[i][j] = constValue.GRASS;
//                    constValue.ENEMIES++;
//                } else if (Map.mapTitle[i][j] == constValue.ENEMY_3) {
//                    Enemy newEnemy = new Enemy3();
//                    newEnemy.setPosition((j) * constValue.ENTITY_SIZE, (i) * constValue.ENTITY_SIZE);
//                    enemies.add(newEnemy);
//                    Map.mapTitle[i][j] = constValue.GRASS;
//                    constValue.ENEMIES++;
//                } else if (Map.mapTitle[i][j] == constValue.ENEMY_4) {
//                    Enemy newEnemy = new Enemy4();
//                    newEnemy.setPosition((j) * constValue.ENTITY_SIZE, (i) * constValue.ENTITY_SIZE);
//                    enemies.add(newEnemy);
//                    Map.mapTitle[i][j] = constValue.GRASS;
//                    constValue.ENEMIES++;
//                }
//            }
//        }
//
//        ///Bom[] bom = new Bom[1];
//
//
//        for (int i = 0; i < Brick.amountBrick; i++) {
//            Brick brick = new Brick();
//            brickList.add(brick);
//        }
//
        Item itemPortal = new ItemPortal();
        itemPortal.setPosition(constValue.ENTITY_SIZE, 2*constValue.ENTITY_SIZE);
//        Item itemSpeed = new ItemSpeed();
//        Item itemSuperBom = new ItemSuperBom();
//        Item itemBomUp = new ItemBomUp();
//        itemList.add(itemSpeed);
//        itemList.add(itemSuperBom);
//        itemList.add(itemBomUp);



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
                if (keyEvent_down.getCode() == KeyCode.SPACE /*&& (bom[0] == null || !bom[0].getIsPut())*/) {
                    //bom[0] = new Bom(man.getPositionBom());
                    //bom[0].setIsPut(true);//Bom.isPut = true;
                    //bom[0].setIsExplode(false);//Bom.isExplode = false;
                    if (bomList.size() < constValue.BOMS) {
                        //sound dat bom
                        soundPlayer.playSoundEffect(soundPlayer.place_bomb,1);
                        Bom bom = new Bom(man.getPositionBom());
                        //bom.setIsPut(true);
                        bom.setIsExplode(false);
                        bomList.add(bom);
                    }
                }

            }
        });

        mainScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent_up) {
                if (mainState[0] != State.DIE) {
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
                            for (int i = 0; i < 120; i++) {
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

        constValue.winTime = System.currentTimeMillis();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (constValue.WIN_LEVEL) {
                    if (System.currentTimeMillis() - constValue.winTime >= 3000) {
                        textStage.setText("");
                        textInGame.setFont(Font.font("", FontWeight.BOLD, FontPosture.REGULAR,48));
                        textInGame.setX(0);
                        textInGame.setY(48);
                        constValue.LEVEL++;
                        constValue.winTime = 0;
                        constValue.WIN_LEVEL = false;
                        brickList = new ArrayList<>();
                        itemList = new ArrayList<>();
                        try {
                            map.LoadMap(constValue.LEVEL);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }

                    } else {
                        mainGc.setFill(Color.BLACK);
                        mainGc.fillRect(0, 0, constValue.ENTITY_SIZE * 29, constValue.ENTITY_SIZE * 14);
                        textStage.setText("STAGE " + (constValue.LEVEL + 1));
                        // render ảnh load map mới
                    }
                } else {


                    for (int i = 0; i < 14; i++) {
                        for (int j = 0; j < 29; j++) {
                            if (Map.mapTitle[i][j] == constValue.ENEMY_1) {
                                Enemy newEnemy = new Enemy1();
                                newEnemy.setPosition((j) * constValue.ENTITY_SIZE, (i) * constValue.ENTITY_SIZE);
                                enemies.add(newEnemy);
                                Map.mapTitle[i][j] = constValue.GRASS;
                                constValue.ENEMIES++;
                            } else if (Map.mapTitle[i][j] == constValue.ENEMY_2) {
                                Enemy newEnemy = new Enemy2();
                                newEnemy.setPosition((j) * constValue.ENTITY_SIZE, (i) * constValue.ENTITY_SIZE);
                                enemies.add(newEnemy);
                                Map.mapTitle[i][j] = constValue.GRASS;
                                constValue.ENEMIES++;
                            } else if (Map.mapTitle[i][j] == constValue.ENEMY_3) {
                                Enemy newEnemy = new Enemy3();
                                newEnemy.setPosition((j) * constValue.ENTITY_SIZE, (i) * constValue.ENTITY_SIZE);
                                enemies.add(newEnemy);
                                Map.mapTitle[i][j] = constValue.GRASS;
                                constValue.ENEMIES++;
                            } else if (Map.mapTitle[i][j] == constValue.ENEMY_4) {
                                Enemy newEnemy = new Enemy4();
                                newEnemy.setPosition((j) * constValue.ENTITY_SIZE, (i) * constValue.ENTITY_SIZE);
                                enemies.add(newEnemy);
                                Map.mapTitle[i][j] = constValue.GRASS;
                                constValue.ENEMIES++;
                            }
                        }
                    }

                    for (int i = 0; i < Brick.amountBrick; i++) {
                        Brick brick = new Brick();
                        brickList.add(brick);
                    }
                    Item itemSpeed = new ItemSpeed();
                    Item itemSuperBom = new ItemSuperBom();
                    Item itemBomUp = new ItemBomUp();
                    itemList.add(itemSpeed);
                    itemList.add(itemSuperBom);
                    itemList.add(itemBomUp);

                    mainGc.setFill(Color.GREEN);
                    mainGc.fillRect(0, 0, constValue.ENTITY_SIZE * 29, constValue.ENTITY_SIZE * 14);
                    ////text////
                    textInGame.setText("🚩 " + constValue.LEVEL + "    ❤ " + constValue.LIFE + "    💵 " + constValue.SCORE
                            + "    🔥 " + constValue.FLAME + "    👟 " + constValue.SPEED + "     💣 " + constValue.BOMS
                            + "    👻 " + constValue.ENEMIES + "    ⏰ " + constValue.TIME);

                    ///Portal///
                    if (constValue.ENEMIES == 0) {
                        itemPortal.drawItem(mainGc);
                        itemPortal.setPickUp(itemPortal.checkWithBomMan(man.getPosition()));
                        itemPortal.checkPickUp();
                    }
                    ///Bom Man///

                    man.update(mainState[0]);

                    for (Enemy e : enemies) {
                        man.checkwithEnemy(e);
                        e.update(man);
                    }
                    man.drawBomMan(mainGc);

                    if (mainState[0] == State.DIE) {
                        mainState[0] = State.STOP;
                    }

                    for (Enemy e : enemies) {
                        e.drawEnemy(mainGc);
                    }
                    //
                    if (!bomList.isEmpty()) {
                        for (int i = 0; i < bomList.size(); i++) {
                            bomList.get(i).drawBom(mainGc);
                            bomList.get(i).checkWithBomMan(man.getPosition());
                            if (bomList.get(i).getIsExplode()) {
                                map.checkWithBom(bomList.get(i).getPosition());
                                if (bomList.get(i).checkWithBomMan(man.getPosition())) {
                                    //System.out.println("Main DIE");
                                    mainState[0] = State.DIE;

                                }
                                for (int j = 0; j < bomList.size(); j++) {
                                    if (j != i) {
                                        bomList.get(i).checkWithOtherBom(bomList.get(j));
                                    }
                                }
                                for (Enemy e : enemies) {
                                    if (bomList.get(i).checkWithEnemy(e.getPosition())) {
                                        System.out.println("Enemy1 DIE");
                                        e.setState(State.DIE);

                                        //enemies.remove(e);
                                    }
                                }
                            }
                            if (bomList.get(i).getIsExploded()) {
                                bomList.remove(i);
                            }

                        }
                    }


                    map.loadImage();
                    map.DrawMap(mainGc, brickList, itemList, man.getPosition());

                    if (isQuit) {
                        mainStage.close();
                    }
                }

            }

        }; timer.start();


        root.getChildren().addAll(mainGc.getCanvas(),textInGame, textStage);

        mainScene.setFill(Color.GREEN);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        mainStage.setTitle(constValue.GAME_TITLE);
        mainStage.show();


    }
    public static void main(String[] args) {
        launch();
    }
}