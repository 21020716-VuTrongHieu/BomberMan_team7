package BomberMan.entities;

import BomberMan.constValue.constValue;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import BomberMan.graphics.Sprite;

public abstract class Entity {
    protected double x; // vi tri nhan vat
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
     */
    public void render(GraphicsContext gc) {
        gc.drawImage(image, x, y);
    }
    /**
        * update trạng thái của thực thể trong vòng lặp game.
     */
    public abstract void update();
}
