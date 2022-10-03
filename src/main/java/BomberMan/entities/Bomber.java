package BomberMan.entities;

import BomberMan.constValue.State;
import BomberMan.constValue.constValue;
import BomberMan.graphics.Sprite;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bomber extends Entity {
    private State state;

    private static int frame = 0;


    public Bomber(Image image){
        super(image);
        frame = 0;
        state = State.STOP;
    }


    public void upDate(State sta) {
        state = sta;

        switch (state) {
            case LEFT:
                Point2D up = new Point2D(-constValue.SPEED, 0);
                this.move(up);
                break;
            case RIGHT:
                Point2D down = new Point2D(constValue.SPEED, 0);
                this.move(down);
                break;
            case UP:
                Point2D left = new Point2D(0, -constValue.SPEED);
                this.move(left);
                break;
            case DOWN:
                Point2D right = new Point2D(0, constValue.SPEED);
                this.move(right);
                break;
            default:
                break;
        }


    }


    public void drawBomMan(GraphicsContext gc) {
        frame++;
        if(frame>=15) frame = 0;
        switch (state) {
            case STOP:
                gc.drawImage(Sprite.bomber.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                break;
            case UP:
                if (frame >=0 && frame < 5){
                    gc.drawImage(Sprite.player_up.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >= 5 && frame < 10) {
                    gc.drawImage(Sprite.player_up_1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >=10 && frame < 15) {
                    gc.drawImage(Sprite.player_up_2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                }
                break;
            case DOWN:
                if (frame >=0 && frame < 5){
                    gc.drawImage(Sprite.player_down.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >= 5 && frame < 10) {
                    gc.drawImage(Sprite.player_down_1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >=10 && frame < 15) {
                    gc.drawImage(Sprite.player_down_2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                }
                break;
            case LEFT:
                if (frame >=0 && frame < 5){
                    gc.drawImage(Sprite.player_left.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >= 5 && frame < 10) {
                    gc.drawImage(Sprite.player_left_1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >=10 && frame < 15) {
                    gc.drawImage(Sprite.player_left_2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                }
                break;
            case RIGHT:
                if (frame >=0 && frame < 5){
                    gc.drawImage(Sprite.player_right.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >= 5 && frame < 10) {
                    gc.drawImage(Sprite.player_right_1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                } else if (frame >=10 && frame < 15) {
                    gc.drawImage(Sprite.player_right_2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
                }
                break;
        }

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
