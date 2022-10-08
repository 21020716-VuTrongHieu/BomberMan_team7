package BomberMan.entities;


import BomberMan.constValue.constValue;
import BomberMan.graphics.Sprite;
//import com.example.demo.graphics.Sprite;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Bom extends Entity{
//chim chim

    public boolean isExplode = false;
    public boolean isPut = false;
    private int frame = 0;
    public Bom(Point2D point) {
        super();
        this.position = point;
        frame = 0;
        this.isPut = false;
        this.isExplode = false;
    }
    public void drawBom(GraphicsContext gc) {
        frame++;
        if (frame > 60) frame = 0;
        if (frame >=0 && frame < 10){
            gc.drawImage(Sprite.bomb.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
        } else if (frame >= 10 && frame < 20) {
            gc.drawImage(Sprite.bomb_1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(), constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
        } else if (frame >=20 && frame < 30) {
            gc.drawImage(Sprite.bomb_2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
        } else if (frame >=30 && frame < 40){
            isExplode = true;
            gc.drawImage(Sprite.bomb_exploded.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
            gc.drawImage(Sprite.explosion_vertical_top_last.getFxImage(),this.getPosition().getX() ,this.getPosition().getY() - constValue.ENTITY_SIZE,constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
            gc.drawImage(Sprite.explosion_vertical_down_last.getFxImage(),this.getPosition().getX() ,this.getPosition().getY() + constValue.ENTITY_SIZE,constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
            gc.drawImage(Sprite.explosion_horizontal_right_last.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            gc.drawImage(Sprite.explosion_horizontal_left_last.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);

        } else if (frame >= 40 && frame < 50) {
            gc.drawImage(Sprite.bomb_exploded1.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
            gc.drawImage(Sprite.explosion_vertical_top_last1.getFxImage(),this.getPosition().getX() ,this.getPosition().getY() - constValue.ENTITY_SIZE,constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
            gc.drawImage(Sprite.explosion_vertical_down_last1.getFxImage(),this.getPosition().getX() ,this.getPosition().getY() + constValue.ENTITY_SIZE,constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
            gc.drawImage(Sprite.explosion_horizontal_right_last1.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            gc.drawImage(Sprite.explosion_horizontal_left_last1.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);

        } else if (frame >=50 && frame < 60) {
            gc.drawImage(Sprite.bomb_exploded2.getFxImage(), this.getPosition().getX(),this.getPosition().getY(),constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
            gc.drawImage(Sprite.explosion_vertical_top_last2.getFxImage(),this.getPosition().getX() ,this.getPosition().getY() - constValue.ENTITY_SIZE,constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
            gc.drawImage(Sprite.explosion_vertical_down_last2.getFxImage(),this.getPosition().getX() ,this.getPosition().getY() + constValue.ENTITY_SIZE,constValue.ENTITY_SIZE,constValue.ENTITY_SIZE);
            gc.drawImage(Sprite.explosion_horizontal_right_last2.getFxImage(), this.getPosition().getX() + constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
            gc.drawImage(Sprite.explosion_horizontal_left_last2.getFxImage(), this.getPosition().getX() - constValue.ENTITY_SIZE, this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);

        } else {

            isPut = false;
        }
    }

    public void setIsExplode(boolean a) {
        this.isExplode = a;
    }

    public boolean getIsExplode() {
        return this.isExplode;
    }

    public void setIsPut(boolean a) {
        this.isPut = a;
    }

    public boolean getIsPut() {
        return this.isPut;
    }


}
