package BomberMan.Item;

import BomberMan.constValue.constValue;
import BomberMan.gameSound.soundPlayer;
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
            soundPlayer.gameMusic.pause();
            // Level < so man choi dang co
            if (constValue.LEVEL < constValue.DEM_MAN) {
                soundPlayer.playSoundEffect(soundPlayer.next_level, 1);
            } else {
                soundPlayer.playSoundEffect(soundPlayer.ending,1);
            }
            constValue.WIN_LEVEL = true;
            if (constValue.winTime == 0) {
                constValue.winTime = System.currentTimeMillis();
            }
        }
    }
}
