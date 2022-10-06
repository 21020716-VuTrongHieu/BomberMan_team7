package BomberMan.entities;

import BomberMan.constValue.constValue;
import BomberMan.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Brick extends Entity {
    private int frame;
    private boolean isExploded;

    public static int amountBrick = 0;
    public Brick() {
        super();
        frame = 0;
        isExploded = false;
    }

    public void drawBrick(GraphicsContext gc) {

        if (this.isExploded) {
            frame++;
            if (frame > 60) frame = 0;
            if (frame >= 0 && frame < 20) {
                gc.drawImage(Sprite.brick_exploded.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE );
            } else if (frame >= 20 && frame < 40) {
                gc.drawImage(Sprite.brick_exploded1.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE );
            } else if (frame >= 40 && frame < 60) {
                gc.drawImage(Sprite.brick_exploded2.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE );
            } else {
                isExploded = false;
            }
        } else {
            gc.drawImage(Sprite.brick.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE );
        }
    }

    public void setIsExploded(boolean a) {
        this.isExploded = a;
    }

    public boolean getIsExploded() {
        return this.isExploded;
    }
}
