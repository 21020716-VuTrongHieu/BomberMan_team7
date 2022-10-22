package BomberMan.Item;

import BomberMan.constValue.constValue;
import BomberMan.entities.Entity;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public abstract class Item extends Entity {

    private boolean isPickUp = false;
    public Item() {}


    public abstract void drawItem(GraphicsContext gc) ;
        ///gc.drawImage(Sprite.powerup_speed.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);


    public boolean checkWithBomMan(Point2D positionBomMan) {
        double x1 = positionBomMan.getX() + 5;
        double x2 = positionBomMan.getX() + constValue.FRAME_SIZE - 15;
        double y1 = positionBomMan.getY() + 5;
        double y2 = positionBomMan.getY() + constValue.FRAME_SIZE - 5;
        if (((x2 >= this.getPosition().getX() && x1 <= this.getPosition().getX() + constValue.ENTITY_SIZE)
            && (y2 >= this.getPosition().getY() && y1 <= this.getPosition().getY() + constValue.ENTITY_SIZE))) {
            isPickUp = true;
            return true;
        }
        return false;
    }

    public void setPickUp(boolean a) {
        this.isPickUp = a;
    }

    public boolean getPickUp() {
        return this.isPickUp;
    }

    public abstract void checkPickUp();
}
