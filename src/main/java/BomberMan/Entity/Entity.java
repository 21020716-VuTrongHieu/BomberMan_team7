package BomberMan.Entity;

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

    public Entity() {
    }

    public Entity(Image entityImage) {
        this.entityImage = entityImage;
        this.width = constValue.ENTITY_SIZE;
        this.height = constValue.ENTITY_SIZE;
    }

    public Point2D getPosition() {
        return this.position;
    }

    public void setPosition(float x_pos, float y_pos) {
        this.position = new Point2D(x_pos, y_pos);
    }

    public void move(Point2D vector) {
        this.position = this.position.add(vector);
    }

    public Image getEntityImage() {
        return this.entityImage;
    }

    public void setTexture(AnimatedTexture texture) {
        this.texture = texture;
    }

    public AnimatedTexture getTexture() {
        return this.texture;
    }

    public void upDate() {

    }
}
