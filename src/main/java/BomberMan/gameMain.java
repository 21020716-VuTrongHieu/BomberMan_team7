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
import javafx.scene.image.Image;
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
import java.util.ArrayList;
import java.util.List;



public class gameMain extends Application {

    private Canvas mainCanvas;
    private GraphicsContext mainGc;
    private Scene mainScene;
    private Group root;
    private Stage mainStage;
    private State[] mainState = new State[1];

    public static boolean isQuit = false;
    private boolean gameOver = false;

    private List<Brick> brickList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();
    public static List<Enemy> enemies = new ArrayList<>();
    private List<Bom> bomList = new ArrayList<>();
    int cnt = 0;
    int count = 0;

    public Text textInGame = new Text();
    public Text textStage = new Text();
    public Text winGame = new Text();
    public Text textMenu = new Text();
    public Text textStart = new Text();
    public Text textQuit = new Text();
    public Text textGameOver = new Text();
    public Text textRePlay = new Text();
    Image image = new Image("file:src/main/resources/54929f197a677.png");

    @Override
    public void start(Stage stage) {

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

        textStage.setFont(Font.loadFont("file:src/main/resources/assets/ui/fonts/game_font.ttf",60));
        textStage.setX(constValue.ENTITY_SIZE * 29 / 3 + 15);
        textStage.setY(constValue.ENTITY_SIZE * 14 / 2 - 20);
        textStage.setFill(Color.GHOSTWHITE);

        winGame.setFont(Font.loadFont("file:src/main/resources/assets/ui/fonts/game_font.ttf",60));
        winGame.setX(constValue.ENTITY_SIZE * 29 / 3 - 20);
        winGame.setY(constValue.ENTITY_SIZE * 14 / 2);
        winGame.setFill(Color.GHOSTWHITE);

        textGameOver.setFont(Font.loadFont("file:src/main/resources/assets/ui/fonts/game_font.ttf",60));
        textGameOver.setX(constValue.ENTITY_SIZE * 29 / 3 - 55);
        textGameOver.setY(constValue.ENTITY_SIZE * 14 / 2 - 120);
        textGameOver.setFill(Color.GHOSTWHITE);

        textStart.setFont(Font.loadFont("file:src/main/resources/assets/ui/fonts/game_font.ttf",30));
        textStart.setX(constValue.ENTITY_SIZE * 29 / 2 - 75);
        textStart.setY(constValue.ENTITY_SIZE * 14 / 2 + 70);
        textStart.setFill(Color.WHITE);

        textQuit.setFont(Font.loadFont("file:src/main/resources/assets/ui/fonts/game_font.ttf",30));
        textQuit.setX(constValue.ENTITY_SIZE * 29 / 2 - 56);
        textQuit.setY(constValue.ENTITY_SIZE * 14 / 2 + 155);
        textQuit.setFill(Color.WHITE);

        textRePlay.setFont(Font.loadFont("file:src/main/resources/assets/ui/fonts/game_font.ttf",30));
        textRePlay.setX(constValue.ENTITY_SIZE * 29 / 2 - 160);
        textRePlay.setY(constValue.ENTITY_SIZE * 14 / 2 + 30);
        textRePlay.setFill(Color.WHITE);
        //////////////////////////////////////////////////////////////////////////
        //      tao NV            //
        Map map = new Map();


        Bomber man = new Bomber();
        man.setPosition(constValue.ENTITY_SIZE, 2*constValue.ENTITY_SIZE);

        Item itemPortal = new ItemPortal();
        itemPortal.setPosition(2*constValue.ENTITY_SIZE, 2*constValue.ENTITY_SIZE);

        boolean[] keyCheck = new boolean[120]; // Check xem con phim nao dang an khong, neu khong con thi moi dung nhan vat.
        for (int i = 0; i < 120; i++) {
            keyCheck[i] = false;
        }
        mainScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent_down) {
                if (mainState[0] != State.DIE && !constValue.isPause) {
                    if (keyEvent_down.getCode() == KeyCode.ENTER) {
                        keyCheck[KeyCode.ENTER.getCode()] = true;
                        mainState[0] = State.STOP;
                        if (soundPlayer.menuMusic != null) {
                            soundPlayer.menuMusic.stop();
                        }
                        if (soundPlayer.soundEffect != null) {
                            soundPlayer.soundEffect.stop();
                        }
                    }
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
                    if (keyEvent_down.getCode() == KeyCode.SPACE && man.isAlive) {
                        if (bomList.size() < constValue.BOMS) {
                            soundPlayer.playSoundEffect(soundPlayer.place_bomb, 1);
                            Bom bom = new Bom(man.getPositionBom());
                            bom.setIsExplode(false);
                            bomList.add(bom);
                        }
                    }
                }
                if (keyEvent_down.getCode() == KeyCode.ESCAPE) {
                    constValue.isPause = !constValue.isPause;
                }
            }
        });

        mainScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent_up) {
                if (mainState[0] != State.DIE) {
                    if (keyEvent_up.getCode() != KeyCode.SPACE) {
                        {
                            if (keyEvent_up.getCode() == KeyCode.ENTER) {
                                keyCheck[KeyCode.ENTER.getCode()] = false;
                            }
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
        soundPlayer.playMenuMusic();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (isQuit) {
                    mainStage.close();
                }

                if (gameOver) {
                    soundPlayer.gameMusic.pause();
                    if (count == 0) {
                        soundPlayer.playSoundEffect(soundPlayer.game_over,1);
                    }
                    count++;
                    mainGc.setFill(Color.BLACK);
                    mainGc.fillRect(0, 0, constValue.ENTITY_SIZE * 29, constValue.ENTITY_SIZE * 14);
                    textGameOver.setText("GAME OVER!");
                    textRePlay.setText("Play Again");
                    textQuit.setText("Quit");
                    if (cnt > 0) {
                        textQuit.setFill(Color.YELLOW);
                        if (keyCheck[KeyCode.ENTER.getCode()]) {
                            textRePlay.setText("");
                            textQuit.setText("");
                            isQuit = true;
                        }
                        if (keyCheck[KeyCode.UP.getCode()]) {
                            textQuit.setFill(Color.WHITE);
                            cnt--;
                        }
                    } else {
                        textRePlay.setFill(Color.YELLOW);
                        if (keyCheck[KeyCode.ENTER.getCode()]) {
                            textRePlay.setText("");
                            textQuit.setText("");
                            constValue.isRePlay = true;
                            count = 0;
                            gameOver = false;
                            constValue.LIFE = 4;
                            constValue.LEVEL = 0;
                            constValue.SCORE = 0;
                            constValue.FLAME = 1;
                            constValue.BOMS = 1;
                            constValue.SPEED = 6;
                            constValue.ENEMIES = 0;
                            Bom.superBom = false;
                            constValue.WIN_LEVEL = true;
                            textGameOver.setText("");
                            soundPlayer.gameMusic.play();
                            constValue.winTime = System.currentTimeMillis();
                        }
                        if (keyCheck[KeyCode.DOWN.getCode()]) {
                            textRePlay.setFill(Color.WHITE);
                            cnt++;
                        }
                    }
                }
                if (!gameOver) {
                    if (!constValue.isStart) {
                        mainGc.setFill(Color.BLACK);
                        mainGc.fillRect(0, 0, constValue.ENTITY_SIZE * 29, constValue.ENTITY_SIZE * 14);
                        mainGc.drawImage(image,380,0);

                        textStart.setText("Start");
                        textQuit.setText("Quit");
                        if (cnt > 0) {
                            textQuit.setFill(Color.YELLOW);
                            if (keyCheck[KeyCode.ENTER.getCode()]) {
                                textMenu.setText("");
                                textStart.setText("");
                                textQuit.setText("");
                                isQuit = true;
                            }
                            if (keyCheck[KeyCode.UP.getCode()]) {
                                textQuit.setFill(Color.WHITE);
                                cnt--;
                            }
                        } else {
                            textStart.setFill(Color.YELLOW);
                            if (keyCheck[KeyCode.ENTER.getCode()]) {
                                textMenu.setText("");
                                textStart.setText("");
                                textQuit.setText("");
                                constValue.isStart = true;
                                soundPlayer.playMusic(soundPlayer.stage_theme, MediaPlayer.INDEFINITE);
                                constValue.winTime = System.currentTimeMillis();
                            }
                            if (keyCheck[KeyCode.DOWN.getCode()]) {
                                textStart.setFill(Color.WHITE);
                                cnt++;
                            }
                        }
                    } else {
                        if (constValue.isWin) {
                            if (System.currentTimeMillis() - constValue.winTime < 14000) {
                                mainGc.setFill(Color.BLACK);
                                mainGc.fillRect(0, 0, constValue.ENTITY_SIZE * 29, constValue.ENTITY_SIZE * 14);
                                winGame.setText("VICTORY!");
                            } else {
                                constValue.isWin = false;
                                isQuit = true;
                            }
                        } else {
                            if (constValue.WIN_LEVEL) {
                                if (constValue.LEVEL < constValue.DEM_MAN) {
                                    if (System.currentTimeMillis() - constValue.winTime >= 4000) {
                                        textStage.setText("");
                                        textInGame.setFont(Font.font("", FontWeight.BOLD, FontPosture.REGULAR, 48));
                                        textInGame.setX(200);
                                        textInGame.setY(48);
                                        constValue.LEVEL++;
                                        constValue.winTime = 0;
                                        constValue.WIN_LEVEL = false;
                                        constValue.speed = 6;
                                        constValue.SPEED = constValue.speed;
                                        constValue.LIFE++;
                                        constValue.FLAME = 1;
                                        Bom.superBom = false;
                                        brickList = new ArrayList<>();
                                        itemList = new ArrayList<>();
                                        enemies = new ArrayList<>();
                                        soundPlayer.gameMusic.play();
                                        try {
                                            map.LoadMap(constValue.LEVEL);
                                        } catch (FileNotFoundException e) {
                                            throw new RuntimeException(e);
                                        }

                                    } else {
                                        mainGc.setFill(Color.BLACK);
                                        mainGc.fillRect(0, 0, constValue.ENTITY_SIZE * 29, constValue.ENTITY_SIZE * 14);
                                        textStage.setText("STAGE " + (constValue.LEVEL + 1));
                                    }
                                } else {
                                    constValue.isWin = true;
                                }
                            } else {
                                if (constValue.LIFE == 0) {
                                    constValue.dieTime = System.currentTimeMillis();
                                    gameOver = true;
                                }
                                if (!constValue.isPause)
                                {
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
                                            } else if (Map.mapTitle[i][j] == constValue.ENEMY_5) {
                                                Enemy newEnemy = new Enemy5();
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

                                    mainGc.setFill(Color.CADETBLUE);
                                    mainGc.fillRect(0, 0, constValue.ENTITY_SIZE * 29, constValue.ENTITY_SIZE);
                                    ////text////
                                    textInGame.setText("🚩 " + constValue.LEVEL + "    ❤ " + constValue.LIFE + "    💵 " + constValue.SCORE
                                            + "    🔥 " + constValue.FLAME + "    👟 " + constValue.SPEED + "     💣 " + constValue.BOMS
                                            + "    👻 " + constValue.ENEMIES);

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

                                    //
                                    if (!bomList.isEmpty()) {
                                        for (int i = 0; i < bomList.size(); i++) {
                                            bomList.get(i).drawBom(mainGc);
                                            bomList.get(i).checkWithBomMan(man.getPosition());
                                            if (bomList.get(i).getIsExplode()) {
                                                map.checkWithBom(bomList.get(i).getPosition());
                                                if (bomList.get(i).checkWithBomMan(man.getPosition())) {
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
                                    for (Enemy e : enemies) {
                                        e.drawEnemy(mainGc);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }; timer.start();


        root.getChildren().addAll(mainGc.getCanvas(),textMenu,textStart,textQuit,textInGame, textStage, textGameOver ,winGame, textRePlay);

        mainScene.setFill(Color.GREEN);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        mainStage.setTitle(constValue.GAME_TITLE);
        Image icon = new Image("file:src/main/resources/icon.png");
        mainStage.setFullScreen(false);
        mainStage.setResizable(false);
        mainStage.getIcons().add(icon);
        mainStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}