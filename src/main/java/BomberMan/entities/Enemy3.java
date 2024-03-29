package BomberMan.entities;

import BomberMan.Map.Map;
import BomberMan.constValue.State;
import BomberMan.constValue.constValue;
import BomberMan.graphics.Sprite;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

import static BomberMan.constValue.constValue.SCORE;
import static BomberMan.gameMain.enemies;

public class Enemy3 extends Enemy {
    private int frame;
    private State state;

    private Point2D moveXY = new Point2D(0, 0);

    public Enemy3(){
        super();
        frame = 0;
        state = State.LEFT;
    }

    public void update(Bomber man) {
        if (!isAlive) {
            return;
        }
        switch (state) {
            case LEFT:
                this.moveXY = new Point2D(-constValue.ENEMY3_SPEED, 0);
                this.move(moveXY);
                break;
            case RIGHT:
                this.moveXY = new Point2D(constValue.ENEMY3_SPEED, 0);
                this.move(moveXY);
                break;
            case UP:
                this.moveXY = new Point2D(0, -constValue.ENEMY3_SPEED);
                this.move(moveXY);
                break;
            case DOWN:
                moveXY = new Point2D(0, constValue.ENEMY3_SPEED);
                this.move(moveXY);
                break;
            default:
                break;
        }

        if (state != State.DIE) {
            calculateState();
        }
//            this.checkToMap();
    }

    @Override
    public void drawEnemy(GraphicsContext gc) {
        frame++;
        if (!isAlive) {
            if (frame >= 0 && frame < 15) {
                gc.drawImage(Sprite.pass_dead.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 15 && frame < 30) {
                gc.drawImage(Sprite.mob_dead1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 30 && frame < 45) {
                gc.drawImage(Sprite.mob_dead2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame >= 45 && frame < 60) {
                gc.drawImage(Sprite.mob_dead3.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            } else if (frame == 60) {
                constValue.ENEMIES++;
            } else {
                SCORE += 200;
                Enemy1 em1 = new Enemy1();
                em1.setPosition(this.getPosition().getX(), this.getPosition().getY());
                enemies.add(em1);
                em1 = new Enemy1();
                em1.setPosition(this.getPosition().getX(), this.getPosition().getY());
                em1.setState(State.RIGHT);
                enemies.add(em1);
                enemies.remove(this);
            }
            return;
        }
        if(frame>=12) frame = 0;
        switch (state) {
            case STOP:
                gc.drawImage(Sprite.pass_left1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                break;
            case UP:
                if (frame >= 0 && frame < 4) {
                    gc.drawImage(Sprite.pass_left1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                } else if (frame >= 4 && frame < 8) {
                    gc.drawImage(Sprite.pass_left2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                } else if (frame >= 8 && frame < 12) {
                    gc.drawImage(Sprite.pass_left3.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                break;
            case DOWN:
                if (frame >= 0 && frame < 4) {
                    gc.drawImage(Sprite.pass_right1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                } else if (frame >= 4 && frame < 8) {
                    gc.drawImage(Sprite.pass_right2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                } else if (frame >= 8 && frame < 12) {
                    gc.drawImage(Sprite.pass_right3.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
                }
                break;
            case LEFT:
                if (frame >=0 && frame < 4){
                    gc.drawImage(Sprite.pass_left1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >= 4 && frame < 8) {
                    gc.drawImage(Sprite.pass_left2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >=8 && frame < 12) {
                    gc.drawImage(Sprite.pass_left3.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                }
                break;
            case RIGHT:
                if (frame >=0 && frame < 4){
                    gc.drawImage(Sprite.pass_right1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >= 4 && frame < 8) {
                    gc.drawImage(Sprite.pass_right2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >= 8 && frame < 12) {
                    gc.drawImage(Sprite.pass_right3.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                }
                break;
            case DIE:
                frame = 0;
                isAlive = false;
                break;
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public void calculateState() {
        Random generator = new Random();
        int cal;
//        switch (cal % 99) {
//            case 0 -> {
//                moveXY = new Point2D(0, 0);
///                break;
//            }
//        }

        int x1 = (int) ((this.getPosition().getX()) / constValue.ENTITY_SIZE);
        int x2 = (int) ((this.getPosition().getX() + constValue.ENTITY_SIZE - 1) / constValue.ENTITY_SIZE); // Frame_size - 10) / ...
        int y1 = (int) ((this.getPosition().getY()) / constValue.ENTITY_SIZE);
        int y2 = (int) ((this.getPosition().getY() + constValue.ENTITY_SIZE - 1) / constValue.ENTITY_SIZE);

        if (moveXY.getX() > 0) {
            if (Map.mapTitle[y2][x2] != constValue.GRASS || Map.mapTitle[y1][x2] != constValue.GRASS) {
                this.setPosition((float) (x1 * constValue.ENTITY_SIZE), (float) (this.getPosition().getY()));
                moveXY = new Point2D(0, 0);
            }
        } else if (moveXY.getX() < 0) {
            if (Map.mapTitle[y1][x1] != constValue.GRASS || Map.mapTitle[y2][x1] != constValue.GRASS) {
                this.setPosition((float) ((x1 + 1) * constValue.ENTITY_SIZE), (float) (this.getPosition().getY()));
                moveXY = new Point2D(0, 0);
            }
        } else if (moveXY.getY() > 0) {
            if (Map.mapTitle[y2][x1] != constValue.GRASS || Map.mapTitle[y2][x2] != constValue.GRASS) {
                this.setPosition((float) (this.getPosition().getX()), (float) (y1 * constValue.ENTITY_SIZE));
                moveXY = new Point2D(0, 0);
            }
        } else if (moveXY.getY() < 0) {
            if (Map.mapTitle[y1][x1] != constValue.GRASS || Map.mapTitle[y1][x2] != constValue.GRASS) {
                this.setPosition((float) (this.getPosition().getX()), (float) ((y1 + 1) * constValue.ENTITY_SIZE));
                moveXY = new Point2D(0, 0);
            }
        }

        if (moveXY.getX() == 0 && moveXY.getY() == 0) { // Random vi tri di chuyen
            State temp = null;
            while (temp == null) {
                generator = new Random();
                cal = generator.nextInt();
                switch (cal % 4) {
                    case 0 -> {
                        if (Map.mapTitle[y2][x1 + 1] == constValue.GRASS || Map.mapTitle[y1][x1 + 1] == constValue.GRASS) {
                            state = State.RIGHT;
                            temp = state;
                            break;
                        }
                    }
                    case 1 -> {
                        if (Map.mapTitle[y1 + 1][x2] == constValue.GRASS || Map.mapTitle[y1 + 1][x1] == constValue.GRASS) {
                            state = State.DOWN;
                            temp = state;
                            break;
                        }
                    }
                    case 2 -> {
                        if (Map.mapTitle[y1][x2 - 1] == constValue.GRASS || Map.mapTitle[y2][x2 - 1] == constValue.GRASS) {
                            state = State.LEFT;
                            temp = state;
                            break;
                        }
                    }
                    case 3 -> {
                        if (Map.mapTitle[y2 - 1][x1] == constValue.GRASS || Map.mapTitle[y2 - 1][x2] == constValue.GRASS) {
                            state = State.UP;
                            temp = state;
                            break;
                        }
                    }
                }
            }
        }
    }

}
