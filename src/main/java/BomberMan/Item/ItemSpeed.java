package BomberMan.Item;

import BomberMan.constValue.constValue;
import BomberMan.gameSound.soundPlayer;
import BomberMan.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;
//
public class ItemSpeed extends Item {

    @Override
    public void drawItem(GraphicsContext gc) {
        gc.drawImage(Sprite.powerup_speed.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);
    }

    @Override
    public void checkPickUp() {
        if (this.getPickUp()) {
            soundPlayer.playSoundEffect(soundPlayer.power_up, 1);
            constValue.SPEED = 8;
            constValue.speed = 8;
        }
    }


}