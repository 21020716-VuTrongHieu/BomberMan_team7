package BomberMan.Item;

import BomberMan.constValue.constValue;
import BomberMan.entities.Bom;
import BomberMan.gameSound.soundPlayer;
import BomberMan.graphics.Sprite;

import javafx.scene.canvas.GraphicsContext;

public class ItemSuperBom extends Item {


    @Override
    public void drawItem(GraphicsContext gc) {
        gc.drawImage(Sprite.powerup_flames.getFxImage(), this.getPosition().getX(), this.getPosition().getY(), constValue.ENTITY_SIZE, constValue.ENTITY_SIZE);

    }

    @Override
    public void checkPickUp() {
        if (this.getPickUp()) {
            soundPlayer.playSoundEffect(soundPlayer.power_up, 1);
            Bom.superBom = true;
            constValue.FLAME++;
        }
    }


}