package BomberMan.entities;

import BomberMan.constValue.State;
import BomberMan.constValue.constValue;
import com.almasb.fxgl.texture.AnimatedTexture;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public abstract class Entity {
    protected Point2D position; // vi tri nhan vat
    protected double width;
    protected double height;
    protected AnimatedTexture texture;

    protected Image entityImage;

    //public Entity() chim{}

    public Entity() {
        //this.entityImage = entityImage;
        this.width = constValue.ENTITY_SIZE;
        this.height = constValue.ENTITY_SIZE;
    }

    public Point2D getPosition() {
        return this.position;
    }

    public void setPosition(double x_pos, double y_pos) {
        this.position = new Point2D(x_pos, y_pos);
    }

    public void move(Point2D vector) {
        this.position =this.position.add(vector);
    }

    public Image getEntityImage() {
        return this.entityImage;
    }
    public void update(State sta){}



    ///////////////////////////////////////////////////////////////////////////////////////////
    /*protected double x; // vi tri nhan vat
    protected double y;
    protected Image image;

    //    public Entity() {
    //    }

    public Entity( int xUnit, int yUnit, Image image) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.image = image;
    }

    /**
     * render entity.
     * @param gc
     *
    public void render(GraphicsContext gc) {
        gc.drawImage(image, x, y);
    }
    /**
        * update trạng thái của thực thể trong vòng lặp game.
     *
    public abstract void update();*/

}
