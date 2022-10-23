package BomberMan.Item;

import BomberMan.constValue.constValue;
import BomberMan.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class ItemPortal extends Item {
    @Override
    public void drawItem(GraphicsContext gc) {
        gc.drawImage(Sprite.portal.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
    }

    @Override
    public void checkPickUp() {
        if (this.getPickUp()) {
            constValue.WIN_LEVEL = true;
            if (constValue.winTime == 0) {
                constValue.winTime = System.currentTimeMillis();
            }
        }
    }
}
