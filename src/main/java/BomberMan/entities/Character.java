package BomberMan.entities;

import BomberMan.constValue.State;
import javafx.scene.image.Image;

public class Character extends Entity {
    protected State state;

    protected static int frame = 0;
    protected boolean isMoving = true;

    public Character(Image image) {
        super(image);
    }

    /**
     * is moving.
     * @param isMoving
     */
    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }
}
