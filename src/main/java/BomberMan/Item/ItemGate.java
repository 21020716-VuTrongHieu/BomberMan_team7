package BomberMan.Item;

import BomberMan.constValue.constValue;
import BomberMan.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class ItemGate extends Item {
    @Override
    public void drawItem(GraphicsContext gc) {
        gc.drawImage(Sprite.gate.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
    }

    @Override
    public void checkPickUp() {
        if (this.getPickUp()) {
            constValue.WIN_LEVEL = true;
        }
    }
}
