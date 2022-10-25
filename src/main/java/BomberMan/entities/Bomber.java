package BomberMan.entities;

import BomberMan.Map.Map;
import BomberMan.constValue.State;
import BomberMan.constValue.constValue;
import BomberMan.gameSound.soundPlayer;
import BomberMan.graphics.Sprite;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import static BomberMan.constValue.constValue.LIFE;
import static BomberMan.constValue.constValue.SPEED;


public class Bomber extends Entity {

    protected boolean isMoving = true;

    protected static int frame = 0;

    protected State state;
    public Bomber(){
        super();
        frame = 0;
        state = State.STOP;
        isMoving = true;
    }

    private Point2D moveXY = new Point2D(0,0);

    /**
     * hàm này return true tạm đã rồi sau làm xong check va chạm thì chim dùng.
     * @return
     */
    public boolean canMove() {
        return true;
    }
    public void setFrame(int val) {
        frame = val;
    }
    public void update(State sta) {
        state = sta;
        if (isMoving) {
            switch (state) {
                case LEFT:
                    this.moveXY = new Point2D(-constValue.SPEED, 0);
                    this.move(moveXY);
                    isMoving = true;
                    break;
                case RIGHT:
                    this.moveXY = new Point2D(constValue.SPEED, 0);
                    this.move(moveXY);
                    isMoving = true;
                    break;
                case UP:
                    this.moveXY = new Point2D(0, -constValue.SPEED);
                    this.move(moveXY);
                    isMoving = true;
                    break;
                case DOWN:
                    moveXY = new Point2D(0, constValue.SPEED);
                    this.move(moveXY);
                    isMoving = true;
                    break;
                default:
                    break;
            }
        }
        this.checkToMap();

    }

    public void drawBomMan(GraphicsContext gc) {
        frame++;
        if (!isAlive) {
            if (frame == 2) {
                soundPlayer.playSoundEffect(soundPlayer.player_die, 1);
            }
            SPEED = 0;
            if (frame >=0 && frame < 15){
                gc.drawImage(Sprite.player_dead1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
            } else if (frame >= 15 && frame < 30) {
                gc.drawImage(Sprite.player_dead2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
            } else if (frame >= 30 && frame < 45) {
                gc.drawImage(Sprite.player_dead3.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.FRAME_SIZE, constValue.FRAME_SIZE);
            } else {
                SPEED = constValue.speed;
                LIFE--;
                this.setPosition(constValue.ENTITY_SIZE, 2 * constValue.ENTITY_SIZE);
                isAlive = true;
            }
            return;
        }

        if(frame>=10) frame = 0;
        if (!isMoving) {
            switch (state) {
                case STOP:
                    gc.drawImage(Sprite.bomber.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.FRAME_SIZE, constValue.FRAME_SIZE);
                    break;
                case UP:
                    gc.drawImage(Sprite.player_up.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.FRAME_SIZE, constValue.FRAME_SIZE);
                    break;
                case DOWN:
                    gc.drawImage(Sprite.player_down.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.FRAME_SIZE, constValue.FRAME_SIZE);
                    break;
                case LEFT:
                    gc.drawImage(Sprite.player_left.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.FRAME_SIZE, constValue.FRAME_SIZE);
                    break;
                case RIGHT:
                    gc.drawImage(Sprite.player_right.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.FRAME_SIZE, constValue.FRAME_SIZE);
                    break;
                case DIE:
                    frame = 0;
                    isAlive = false;
//                    if (frame >=0 && frame < 3){
//                        gc.drawImage(Sprite.player_dead1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
//                    } else if (frame >= 3 && frame < 6) {
//                        gc.drawImage(Sprite.player_dead2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
//                    } else if (frame >= 6 && frame < 9) {
//                        gc.drawImage(Sprite.player_dead3.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.FRAME_SIZE, constValue.FRAME_SIZE);
//                    } else {
//                        gc.drawImage(Sprite.player_dead3.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.FRAME_SIZE, constValue.FRAME_SIZE);
//                        LIFE--;
//                        this.setPosition(constValue.ENTITY_SIZE, 2 * constValue.ENTITY_SIZE);
//                    }
                    break;
            }
        } else {
            switch (state) {
                case STOP:
                    gc.drawImage(Sprite.bomber.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
                    break;
                case UP:
                    if (frame >=0 && frame < 3){
                        gc.drawImage(Sprite.player_up.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
                    } else if (frame >= 3 && frame <6) {
                        gc.drawImage(Sprite.player_up_1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
                    } else if (frame >=6 && frame < 10) {
                        gc.drawImage(Sprite.player_up_2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
                    }
                    break;
                case DOWN:
                    if (frame >=0 && frame < 3){
                        gc.drawImage(Sprite.player_down.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
                    } else if (frame >= 3 && frame < 6) {
                        gc.drawImage(Sprite.player_down_1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
                    } else if (frame >= 6 && frame < 10) {
                        gc.drawImage(Sprite.player_down_2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
                    }
                    break;
                case LEFT:
                    if (frame >=0 && frame < 3){
                        gc.drawImage(Sprite.player_left.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
                    } else if (frame >= 3 && frame < 6) {
                        gc.drawImage(Sprite.player_left_1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
                    } else if (frame >=6 && frame < 10) {
                        gc.drawImage(Sprite.player_left_2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
                    }
                    break;
                case RIGHT:
                    if (frame >=0 && frame < 3){
                        gc.drawImage(Sprite.player_right.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
                    } else if (frame >= 3 && frame < 6) {
                        gc.drawImage(Sprite.player_right_1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
                    } else if (frame >= 6 && frame < 10) {
                        gc.drawImage(Sprite.player_right_2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
                    }
                    break;
                case DIE:
                    frame = 0;
                    isAlive = false;
//                    if (frame >=0 && frame < 3){
//                        gc.drawImage(Sprite.player_dead1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
//                    } else if (frame >= 3 && frame < 6) {
//                        gc.drawImage(Sprite.player_dead2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.FRAME_SIZE,constValue.FRAME_SIZE);
//                    } else if (frame >= 6 && frame < 9) {
//                        gc.drawImage(Sprite.player_dead3.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.FRAME_SIZE, constValue.FRAME_SIZE);
//                    } else {
//                        gc.drawImage(Sprite.player_dead3.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.FRAME_SIZE, constValue.FRAME_SIZE);
//                        LIFE--;
//                        this.setPosition(constValue.ENTITY_SIZE, 2 * constValue.ENTITY_SIZE);
//                    }
                    break;
            }
        }


    }

    public void checkToMap(){
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;

        x1 = (int) ((this.getPosition().getX()) / constValue.ENTITY_SIZE);
        x2 = (int) ((this.getPosition().getX() + constValue.FRAME_SIZE - 10) / constValue.ENTITY_SIZE);

        y1 = (int) ((this.getPosition().getY()) / constValue.ENTITY_SIZE);
        y2 = (int) ((this.getPosition().getY() + constValue.FRAME_SIZE - 5) / constValue.ENTITY_SIZE);

        if (moveXY.getX() > 0) {
            if ((Map.mapTitle[y2][x2] != constValue.GRASS && Map.mapTitle[y2][x2] != constValue.BOM_WAIT && Map.mapTitle[y2][x2] != constValue.ITEM_SHOW)
                    || (Map.mapTitle[y1][x2] != constValue.GRASS && Map.mapTitle[y1][x2] != constValue.BOM_WAIT && Map.mapTitle[y1][x2] != constValue.ITEM_SHOW)) {
                this.setPosition((float) (x1 * constValue.ENTITY_SIZE + constValue.ENTITY_SIZE - constValue.FRAME_SIZE + 9), (float) (this.getPosition().getY()));
                moveXY = new Point2D(0,0);
            }
        } else if (moveXY.getX() < 0) {
            if ((Map.mapTitle[y1][x1] != constValue.GRASS && Map.mapTitle[y1][x1] != constValue.BOM_WAIT && Map.mapTitle[y1][x1] != constValue.ITEM_SHOW)
                    || (Map.mapTitle[y2][x1] != constValue.GRASS && Map.mapTitle[y2][x1] != constValue.BOM_WAIT && Map.mapTitle[y2][x1] != constValue.ITEM_SHOW)){
                this.setPosition((float) ((x1+1) * constValue.ENTITY_SIZE ), (float) (this.getPosition().getY()));
                moveXY = new Point2D(0,0);
            }
        }


        if (moveXY.getY() > 0) {
            if ((Map.mapTitle[y2][x1] != constValue.GRASS && Map.mapTitle[y2][x1] != constValue.BOM_WAIT && Map.mapTitle[y2][x1] != constValue.ITEM_SHOW)
                    || (Map.mapTitle[y2][x2] != constValue.GRASS && Map.mapTitle[y2][x2] != constValue.BOM_WAIT && Map.mapTitle[y2][x2] != constValue.ITEM_SHOW)) {
                this.setPosition((float) (this.getPosition().getX()), (float) (y1*constValue.ENTITY_SIZE + constValue.ENTITY_SIZE - constValue.FRAME_SIZE));
                moveXY = new Point2D(0,0);
            }
        } else if (moveXY.getY() < 0) {
            if ((Map.mapTitle[y1][x1] != constValue.GRASS && Map.mapTitle[y1][x1] != constValue.BOM_WAIT && Map.mapTitle[y1][x1] != constValue.ITEM_SHOW)
                    || (Map.mapTitle[y1][x2] != constValue.GRASS && Map.mapTitle[y1][x2] != constValue.BOM_WAIT && Map.mapTitle[y1][x2] != constValue.ITEM_SHOW)){
                this.setPosition((float) (this.getPosition().getX()), (float) ((y1+1)*constValue.ENTITY_SIZE));
                moveXY = new Point2D(0,0);
            }
        }


    }

    public void checkwithEnemy(Enemy enemy) {
        if (enemy.isAlive == false || state == State.DIE) {
            return;
        }
        int x1 = (int) (this.getPosition().getX());
        int y1 = (int) (this.getPosition().getY());
        int x2 = (int) (this.getPosition().getX() + constValue.FRAME_SIZE - 10);
        int y2 = (int) (this.getPosition().getY() + constValue.FRAME_SIZE - 5);

        int xx1 = (int) (enemy.getPosition().getX());
        int yy1 = (int) (enemy.getPosition().getY());
        int xx2 = (int) (enemy.getPosition().getX() + constValue.ENTITY_SIZE - 1);
        int yy2 = (int) (enemy.getPosition().getY() + constValue.ENTITY_SIZE - 1);

        if (xx1 >= x1 && xx1 <= x2){
            if ((yy2 >= y1 && yy2 <= y2) || (yy1 <= y2 && yy1 >= y1) || (yy1 <= y1 && yy2 >= y2)){
                state = State.DIE;
            }
        } else if (xx2 >= x1 && xx2 <= x2){
            if ((yy2 >= y1 && yy2 <= y2) || (yy1 >= y1 && yy1 <= y2) || (yy1 <= y1 && yy2 >= y2) ) {
                state = State.DIE;
            }
        } else if ((yy2 >= y1 && yy2 <= y2) && (xx1 <= x1 && xx2 >= x2)) {
            state = State.DIE;
        } else if ((yy1 >= y2 && yy1 <= y2) && (xx1 <= x1 && xx2 >= x2)) {
            state = State.DIE;
        }
    }

    public Point2D getPositionBom() {
        int x1 = (int) ((this.getPosition().getX()+constValue.FRAME_SIZE/2) / constValue.ENTITY_SIZE);
        int y1 = (int) ((this.getPosition().getY()+constValue.FRAME_SIZE/2) / constValue.ENTITY_SIZE);
        Point2D p = new Point2D(x1*constValue.ENTITY_SIZE,y1*constValue.ENTITY_SIZE);
        return p;
    }

    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    /*private State state;
    private static int frame = 0;
    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {

    }*/
}