package BomberMan.entities;

import BomberMan.constValue.State;
import javafx.scene.canvas.GraphicsContext;

public abstract class Enemy extends Entity {
    public abstract void update();

    public abstract void drawEnemy(GraphicsContext gc);

    public abstract void setState(State state);
}
//